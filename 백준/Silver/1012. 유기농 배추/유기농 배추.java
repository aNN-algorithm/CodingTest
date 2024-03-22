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
        StringTokenizer st = new StringTokenizer(comm);

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            comm = br.readLine();
            st = new StringTokenizer(comm);

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int j = 0; j < k; j++) {
                comm = br.readLine();
                st = new StringTokenizer(comm);

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            Queue<Node> queue = new LinkedList<>();
            int[] dx = {0, 1, 0, -1};
            int[] dy = {-1, 0, 1, 0};
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                for (int l = 0; l < M; l++) {
                    if (map[j][l] == 1) {
                        if (visited[j][l] == false){
                            queue.add(new Node(j, l));
                            visited[j][l] = true;
                            cnt++;
                        }
                    }

                    while (!queue.isEmpty()) {
                        Node cur = queue.poll();

                        for (int m = 0; m < 4; m++) {
                            int nx = cur.x + dx[m];
                            int ny = cur.y + dy[m];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                                continue;
                            }
                            if (map[nx][ny] != 1 || visited[nx][ny] == true) {
                                continue;
                            }

                            queue.add(new Node(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}