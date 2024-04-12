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
        int broken;

        public Node(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        StringTokenizer st = new StringTokenizer(comm);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            comm = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = comm.charAt(j) - '0';
            }
        }

        int[][][] dist = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j][0] = -1;
                dist[i][j][1] = -1;
            }
        }

        dist[0][0][0] = 1;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int nextDist = dist[cur.x][cur.y][cur.broken] + 1;

            if (cur.x == n -1 && cur.y == m - 1) {
                System.out.println(dist[cur.x][cur.y][cur.broken]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 0 && dist[nx][ny][cur.broken] == -1) {
                    dist[nx][ny][cur.broken] = nextDist;
                    queue.add(new Node(nx, ny, cur.broken));
                }
                // 부수기
                if (cur.broken == 0 && map[nx][ny] == 1 && dist[nx][ny][1] == -1) {
                    dist[nx][ny][1] = nextDist;
                    queue.add(new Node(nx, ny, 1));
                }
            }
        }
        System.out.println(-1);
    }
}