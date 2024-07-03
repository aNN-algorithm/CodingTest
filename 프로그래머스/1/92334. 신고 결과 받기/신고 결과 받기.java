
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 중복 신고를 제거한 신고 리스트
        List<String> noRedun = new ArrayList<>(new HashSet<>(Arrays.asList(report)));

        // 각 사용자가 몇 번 신고를 받았는지 저장하는 맵
        Map<String, Integer> reportCnt = new HashMap<>();

        // 각 사용자가 누구를 신고했는지 기록하는 맵
        Map<String, List<String>> reportLog = new HashMap<>();

        // reportLog 맵 초기화
        for (String id : id_list) {
            reportLog.put(id, new ArrayList<>());
            reportCnt.put(id, 0);
        }

        // 중복이 제거된 신고 내역 처리
        for (String rep : noRedun) {
            String[] parts = rep.split(" ");
            String reporting = parts[0]; // 신고자
            String reported = parts[1]; // 신고당한자

            // 신고자의 신고 내역에 신고당한자를 추가
            reportLog.get(reporting).add(reported);

            // 신고당한자의 신고 횟수를 카운트
            reportCnt.put(reported, reportCnt.getOrDefault(reported, 0) + 1);
        }

        // 신고 처리 결과를 기반으로 메일 발송 횟수 계산
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            List<String> reportedUsers = reportLog.get(user);

            // 각 사용자가 신고한 대상 중에서 정지된 사용자를 찾아 알림 횟수 증가
            for (String reported : reportedUsers) {
                if (reportCnt.getOrDefault(reported, 0) >= k) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}