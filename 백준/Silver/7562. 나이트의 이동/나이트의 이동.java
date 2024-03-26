import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        int T = Integer.parseInt(comm);

        for (int i = 0; i < T; i++) {
            comm = br.readLine();
            int n = Integer.parseInt(comm);

            comm = br.readLine();
            StringTokenizer st = new StringTokenizer(comm);
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            comm = br.readLine();
            st = new StringTokenizer(comm);
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
            int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
            int[][] map = new int[n][n];
            int[][] visited = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    visited[j][k] = -1;
                }
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(x1, y1));
            visited[x1][y1] = 0;
            while (!queue.isEmpty()) {
                Node cur = queue.poll();

                if (cur.x == x2 && cur.y == y2) {
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        continue;
                    }
                    if (visited[nx][ny] > 0) {
                        continue;
                    }

                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                }
            }
            System.out.println(visited[x2][y2]);
        }
    }
}