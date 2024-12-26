import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        // 오늘 날짜 변환
        String[] part = today.split("\\.");
        int todayYear = Integer.parseInt(part[0]);
        int todayMonth = Integer.parseInt(part[1]);
        int todayDay = Integer.parseInt(part[2]);
        
        int todayTotalDays = toTotalDays(todayYear, todayMonth, todayDay);

        // 약관 기간 저장
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            termMap.put(t[0], Integer.parseInt(t[1]) * 28); // 약관 기간을 일 단위로 저장 (월 * 28일)
        }

        // 결과 저장
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] dateParts = privacy[0].split("\\.");
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);

            int startDays = toTotalDays(year, month, day);
            int expiryDays = termMap.get(privacy[1]);

            // 만료 날짜 계산
            if (startDays + expiryDays <= todayTotalDays) {
                answer.add(i + 1); // 인덱스는 1-based
            }
        }

        return answer;
    }

    // 날짜를 총 일수로 변환
    private int toTotalDays(int year, int month, int day) {
        return (year * 12 * 28) + (month * 28) + day;
    }
}
