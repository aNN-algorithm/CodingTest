import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] isVisited = new int[N + 1];

        int index = 0;
        queue.add(R);
        isVisited[R] = ++index;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int x : graph[cur]) {
                if (isVisited[x] > 0) continue;

                isVisited[x] = ++index;
                queue.add(x);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            answer.append(isVisited[i]).append("\n");
        }
        System.out.println(answer.toString());
    }
}