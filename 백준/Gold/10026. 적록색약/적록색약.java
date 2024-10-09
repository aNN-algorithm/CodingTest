import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static char[][] grid;

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            grid[i] = st.nextToken().toCharArray();
        }

        StringBuilder answer = new StringBuilder();
        answer.append(bfs()).append(" ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'G') grid[i][j] = 'R';
            }
        }

        answer.append(bfs());
        System.out.println(answer);
    }

    private static int bfs() {
        int cnt = 0;
        boolean[][] isVisited = new boolean[n][n];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isVisited[i][j]) continue;

                cnt++;

                queue.add(new Node(i, j));
                isVisited[i][j] = true;

                int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                while (!queue.isEmpty()) {
                    Node cur = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dir[k][0];
                        int ny = cur.y + dir[k][1];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        if (isVisited[nx][ny] || grid[i][j] != grid[nx][ny]) continue;

                        queue.add(new Node(nx, ny));
                        isVisited[nx][ny] = true;
                    }
                }
            }
        }
        return cnt;
    }
}