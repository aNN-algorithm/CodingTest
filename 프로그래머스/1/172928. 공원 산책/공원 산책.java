class Solution {
    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int n = park.length;
        int m = park[0].length();
        int[][] map = new int[n][m];
        Node start = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = park[i].charAt(j);

                if (ch == 'S') {
                    start = new Node(i, j);
                    map[i][j] = 0;
                }
                if (ch == 'X') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        Node cur = start;
        for (String route : routes) {
            
            String[] comm = route.split(" ");
            String dir = comm[0];
            int cnt = Integer.parseInt(comm[1]);
            boolean canGo = true;

            // 시뮬레이션하여 이동 가능한지 체크
            int newX = cur.x;
            int newY = cur.y;

            for (int j = 1; j <= cnt; j++) {
                switch (dir) {
                    case "E" -> newY = cur.y + j;
                    case "S" -> newX = cur.x + j;
                    case "W" -> newY = cur.y - j;
                    case "N" -> newX = cur.x - j;
                }

                // 경계를 벗어나거나 장애물을 만나면 이동 불가능
                if (newX < 0 || newX >= n || newY < 0 || newY >= m || map[newX][newY] == 1) {
                    canGo = false;
                    break;
                }
            }

            // 이동 가능할 경우에만 현재 위치를 갱신
            if (canGo) {
                cur.x = newX;
                cur.y = newY;
            }
        }

        answer[0] = cur.x;
        answer[1] = cur.y;
        return answer;
    }
}