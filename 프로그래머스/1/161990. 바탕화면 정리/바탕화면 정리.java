class Solution {
    public int[] solution(String[] wallpaper) {
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        int[][] map = new int[n][m];
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                char c = wallpaper[i].charAt(j);
                if (c == '#') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    if (lux > i) {
                        lux = i;
                    }
                    if (luy > j) {
                        luy = j;
                    }
                    if (rdx < i) {
                        rdx = i;
                    }
                    if (rdy < j) {
                        rdy = j;
                    }
                }
            }
        }

        rdx++;
        rdy++;

        int[] answer = {lux, luy, rdx, rdy};
        return answer;
    }
}