import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
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
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] isVisit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String comm = br.readLine();

            for (int j = 0; j < N; j++) {
                if (comm.charAt(j) == '1') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        Stack<Node> stack = new Stack<Node>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        int houseIdx = 0;
        Map<Integer, Integer> houseMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !isVisit[i][j]) {
                    stack.add(new Node(i, j));
                    isVisit[i][j] = true;
                    houseIdx++;
                    houseMap.put(houseIdx, 1);

                    while (!stack.isEmpty()) {
                        Node cur = stack.pop();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                                continue;
                            }
                            if (map[nx][ny] != 1 || isVisit[nx][ny]) {
                                continue;
                            }

                            stack.add(new Node(nx, ny));
                            isVisit[nx][ny] = true;
                            houseMap.put(houseIdx, houseMap.getOrDefault(houseIdx, 0) + 1);
                        }
                    }
                }
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(houseMap.entrySet());
        list.sort(Map.Entry.comparingByValue());

        System.out.println(houseIdx);
        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.getValue());
        }
    }
}
