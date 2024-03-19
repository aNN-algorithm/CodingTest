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

        String size = br.readLine();

        StringTokenizer st = new StringTokenizer(size);

        int answer = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        int[][] fire = new int[n][m];
        int[][] escape = new int[n][m];

        Queue<Node> qFire = new LinkedList<>();
        Queue<Node> qEscape = new LinkedList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            size = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = size.charAt(j);
                fire[i][j] = -1;
                escape[i][j] = -1;
                if (map[i][j] == 'F') {
                    qFire.add(new Node(i, j));
                    fire[i][j] = 0;
                }
                if (map[i][j] == 'J') {
                    qEscape.add(new Node(i, j));
                    escape[i][j] = 0;
                }
            }
        }

        while (!qFire.isEmpty()) {
            Node cur = qFire.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == '#' || fire[nx][ny] >= 0) {
                    continue;
                }

                fire[nx][ny] = fire[cur.x][cur.y] + 1;
                qFire.add(new Node(nx, ny));
            }
        }

        while (!qEscape.isEmpty()) {
            Node cur = qEscape.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    // 탈출
                    System.out.println(escape[cur.x][cur.y] + 1);;
                    return;
                }
                if (map[nx][ny] == '#' || escape[nx][ny] >= 0) {
                    continue;
                }
                if (fire[nx][ny] >= 0 && fire[nx][ny] <= escape[cur.x][cur.y] + 1) {
                    continue;
                }

                escape[nx][ny] = escape[cur.x][cur.y] + 1;
                qEscape.add(new Node(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}