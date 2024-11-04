import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int start = scanner.nextInt();
        int end = scanner.nextInt();

        int m = scanner.nextInt();

        // 그래프 초기화
        ArrayList<Integer>[] graphArray = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graphArray[i] = new ArrayList<>();
        }

        // 관계 입력 받기
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graphArray[u].add(v);
            graphArray[v].add(u);
        }

        // BFS로 두 사람 간의 촌수 계산
        int result = findKinship(n, start, end, graphArray);
        System.out.println(result);
    }

    private static int findKinship(int n, int start, int end, ArrayList<Integer>[] graphArray) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);

        // 시작 노드 설정
        queue.add(start);
        visited[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int neighbor : graphArray[cur]) {
                if (visited[neighbor] > 0) continue;
                
                visited[neighbor] = visited[cur] + 1;
                queue.add(neighbor);
                if (neighbor == end) {
                    return visited[neighbor];
                }
            }
        }
        return -1; // 촌수를 찾을 수 없는 경우
    }
}
