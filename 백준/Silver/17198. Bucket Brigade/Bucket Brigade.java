import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Node {
        int x;
        int y;
        int channel;

        public Node(int x, int y, int channel) {
            this.x = x;
            this.y = y;
            this.channel = channel;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] farm = new char[10][10];
        boolean[][] isVisited = new boolean[10][10];

        for (int i = 0; i < 10; i++) {
            farm[i] = br.readLine().toCharArray();
        }

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (farm[i][j] == '.' || farm[i][j] == 'B' || farm[i][j] == 'R') continue;

                queue.add(new Node(i, j, 0));
                isVisited[i][j] = true;

                while (!queue.isEmpty()) {
                    Node cur = queue.poll();

                    int[] dx = {0, -1, 0, 1};
                    int[] dy = {-1, 0, 1, 0};
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if (nx < 0 || ny < 0 || nx >= 10 || ny >= 10) continue;
                        if (farm[nx][ny] == 'R' || isVisited[nx][ny]) continue;
                        if (farm[nx][ny] == 'B') {
                            System.out.println(cur.channel);
                            return;
                        }

                        queue.add(new Node(nx, ny, cur.channel + 1));
                        isVisited[nx][ny] = true;
                    }
                }
            }
        }
    }
}