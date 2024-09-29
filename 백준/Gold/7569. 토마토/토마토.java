import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][][] box;
    static int m;
    static int n;
    static int h;

    public static class Node {
        int x;
        int y;
        int z;
        int day;

        public Node(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[n][m][h];
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        if (isAllTomato()) {
            System.out.println(0);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[i][j][k] == 1) {
                        queue.add(new Node(i, j, k, 1));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            int[] dx = {0, 1, 0, -1, 0, 0};
            int[] dy = {-1, 0, 1, 0, 0, 0};
            int[] dz = {0, 0, 0, 0, -1, 1};

            for (int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) continue;
                if (box[nx][ny][nz] != 0)  continue;

                box[nx][ny][nz] = cur.day + 1;
                queue.add(new Node(nx, ny, nz, cur.day + 1));
            }
        }

        System.out.println(isAllTomato() ? maxTomatoDay() - 1 : -1);
    }

    private static int maxTomatoDay() {
        int max = 0;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    max = Math.max(max, box[i][j][k]);
                }
            }
        }
        return max;
    }

    private static boolean isAllTomato () {
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }
}