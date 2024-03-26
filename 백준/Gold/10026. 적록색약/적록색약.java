import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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
        int N = Integer.parseInt(comm);

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            comm = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = comm.charAt(j);
            }
        }

        boolean[][] visited = new boolean[N][N];
        Queue<Node> queue = new LinkedList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        int gCnt = 0;
        int rCnt = 0;
        int bCnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false) {
                    if (map[i][j] == 'B') {
                        bCnt++;
                    } else if (map[i][j] == 'G') {
                        gCnt++;
                    } else if (map[i][j] == 'R') {
                        rCnt++;
                    }

                    visited[i][j] = true;
                    queue.add(new Node(i, j));
                    while (!queue.isEmpty()) {
                        Node cur = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                                continue;
                            }
                            if (visited[nx][ny] == true || map[nx][ny] != map[cur.x][cur.y]) {
                                continue;
                            }

                            visited[nx][ny] = true;
                            queue.add(new Node(nx, ny));
                        }
                    }
                }
            }
        }

        int notIt = gCnt + rCnt + bCnt;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        rCnt = 0;
        bCnt = 0;
        visited = new boolean[N][N];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (visited[i][j] == false) {

                    if (map[i][j] == 'B') {
                        bCnt++;
                    } else {
                        rCnt++;
                    }

                    visited[i][j] = true;
                    queue.add(new Node(i, j));
                    while (!queue.isEmpty()) {
                        Node cur = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                                continue;
                            }
                            if (visited[nx][ny] == true) {
                                continue;
                            }
                            if (visited[nx][ny] == true || map[nx][ny] != map[cur.x][cur.y]) {
                                continue;
                            }

                            visited[nx][ny] = true;
                            queue.add(new Node(nx, ny));
                        }
                    }
                }
            }
        }

        int isIt = bCnt + rCnt;

        System.out.println(notIt + " " + isIt);
    }
}