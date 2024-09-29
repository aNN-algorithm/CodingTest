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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] isVisited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();
        int cntOfPic = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // 시작점 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) continue;
                // 방문 검증
                if (isVisited[i][j]) continue;

                // 탐색할 노드
                cntOfPic++; // 영역의 개수++;
                queue.add(new Node(i, j)); // 1. 큐에 넣는다.
                isVisited[i][j] = true; // 2. 큐에 넣었으면 방문한 것
                int currentWidth = 1;

                while (!queue.isEmpty()) {
                    Node cur = queue.poll(); // cur의 상하좌우를 보겠다!

                    // 상하좌우 이동
                    int[] dx = {0, 1, 0, -1};
                    int[] dy = {-1, 0, 1, 0};
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if (isVisited[nx][ny] || map[nx][ny] == 0) continue;

                        // 탐색할 노드
                        queue.add(new Node(nx, ny));
                        isVisited[nx][ny] = true;
                        currentWidth++;
                    }
                }

                pq.add(currentWidth);
            }
        }
        System.out.println(cntOfPic); // 그림의 개수
        System.out.println(pq.isEmpty() ? 0 : pq.peek()); // 그림의 넓이
    }
}