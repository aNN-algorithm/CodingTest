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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int mapSize = Integer.parseInt(br.readLine());
            int[][] map = new int[mapSize][mapSize];
            boolean[][] isVisited = new boolean[mapSize][mapSize];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(startX, startY));
            isVisited[startX][startY] = true;
            map[startX][startY] = 0;
            while (!queue.isEmpty()) {
                Node cur = queue.poll();

                int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
                int[] dy = {-2, -2, -1, 1, 2, 2, 1, -1};
                for (int j = 0; j < 8; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= mapSize || ny >= mapSize) continue;
                    if (isVisited[nx][ny]) continue;

                    queue.add(new Node(nx, ny));
                    isVisited[nx][ny] = true;
                    map[nx][ny] = map[cur.x][cur.y] + 1;
                }
            }
            answer.append(map[endX][endY]).append("\n");
        }
        System.out.println(answer);
    }
}