import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        int[][] map = new int[n][n];
        
        for (int i = 0; i < gifts.length; i++) {
            StringTokenizer st = new StringTokenizer(gifts[i]);
            String sender = st.nextToken();
            String receiver = st.nextToken();
            int idxSend = 0;
            int idxReceive = 0;
            
            for (int j = 0; j < friends.length; j++) {
                if (friends[j].equals(sender)) {
                    idxSend = j;
                }
                if (friends[j].equals(receiver)) {
                    idxReceive = j;
                }
            }
            
            map[idxSend][idxReceive]++;
        }
        
        int[] level = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                level[i] += map[i][j];
            }            
        }
        
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                level[j] -= map[i][j];
            }
        }
        
        int[] nextGift = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (map[i][j] < map[j][i]) {
                    nextGift[j]++;
                } else if (map[i][j] > map[j][i]) {
                    nextGift[i]++;
                } else if (map[i][j] == map[j][i]) {
                    if (level[i] < level[j]) {
                        nextGift[j]++;
                    } else if (level[i] > level[j]) {
                        nextGift[i]++;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(nextGift[i] + " ");
            if (answer < nextGift[i]) {
                answer = nextGift[i];
            }
        }
        
        return answer/2;
    }
}