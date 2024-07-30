import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= max; i++) {
            int[][] region = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] <= i) {
                        region[j][k] = 0;
                    } else {
                        region[j][k] = 1;
                    }
                }
            }

            int tmp = 0;
            Queue<Node> queue = new LinkedList<>();
            boolean[][] isVisited = new boolean[n][n];
            int[] dx = {0, 1, 0, -1};
            int[] dy = {-1, 0, 1, 0};
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (isVisited[j][k] || region[j][k] == 0) {
                        continue;
                    }
                    isVisited[j][k] = true;
                    queue.add(new Node(j, k));
                    tmp++;
                    while (!queue.isEmpty()) {
                        Node cur = queue.poll();

                        for (int l = 0; l < 4; l++) {
                            int nx = cur.x + dx[l];
                            int ny = cur.y + dy[l];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (isVisited[nx][ny] || region[nx][ny] == 0) {
                                continue;
                            }
                            queue.add(new Node(nx, ny));
                            isVisited[nx][ny] = true;
                        }
                    }
                }
            }
            if (answer < tmp) {
                answer = tmp;
            }
        }
        System.out.println(answer);
    }
}