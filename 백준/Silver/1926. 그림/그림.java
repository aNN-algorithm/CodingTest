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
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        StringTokenizer st = new StringTokenizer(comm);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            comm = br.readLine();
            st = new StringTokenizer(comm);

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> queue = new LinkedList<>();
        int max = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1 && visited[i][j] == false) {
                    int tmp = 1;
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                    cnt++;

                    while (!queue.isEmpty()) {
                        Node cur = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                                continue;
                            }
                            if (visited[nx][ny] == true || map[nx][ny] != 1) {
                                continue;
                            }

                            queue.add(new Node(nx, ny));
                            visited[nx][ny] = true;
                            tmp++;
                        }
                    }

                    if (max < tmp) {
                        max = tmp;
                    }
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);

    }
}
