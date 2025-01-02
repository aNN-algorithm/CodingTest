import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        List<String> noRedun = new ArrayList<>(new HashSet<>(Arrays.asList(report)));
        Map<String, Integer> reportCnt = new HashMap<>();
        Map<String, List<String>> reportLog = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            reportLog.put(id_list[i], new ArrayList<>());
        }

        for (String rep : noRedun) {
            String[] parts = rep.split(" ");
            String reporting = parts[0];
            String reported = parts[1];

            List<String> list = reportLog.get(reporting);
            list.add(reported);
            reportLog.put(reporting, list);

            reportCnt.put(reported, reportCnt.getOrDefault(reported, 0) + 1);
        }

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            List<String> list = reportLog.get(id);

            for (String s : list) {

                if (reportCnt.getOrDefault(s, 0) >= k) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}