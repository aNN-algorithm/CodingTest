import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map1.put(players[i], i);
            map2.put(i, players[i]);
        }
        
        for (String call : callings) {
            int grade = map1.get(call) - 1;
            map1.put(call, grade);
            String player = map2.get(grade);
            map1.put(player, grade + 1);
            map2.put(grade, call);
            map2.put(grade + 1, player);
        }
        
        for (int i = 0; i < players.length; i++) {
            answer[i] = map2.get(i);
        }
        
        return answer;
    }
}