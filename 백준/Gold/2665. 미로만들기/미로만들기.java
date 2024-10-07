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
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                // 현재 노드보다 거리가 짧다면 갱신
                int newDist = dist[cur.x][cur.y] + (map[nx][ny] == '1' ? 0 : 1);
                if (newDist < dist[nx][ny]) {
                    dist[nx][ny] = newDist;
                    queue.add(new Node(nx, ny));
                }
            }
        }
        
        System.out.println(dist[n - 1][n - 1]);
    }
}
