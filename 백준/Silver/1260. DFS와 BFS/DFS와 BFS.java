import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static ArrayList<Integer>[] graph;
    private static boolean[] isVisited;
    private static int N;
    private static StringBuilder sb;

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        sb = new StringBuilder();
        isVisited = new boolean[N + 1];
        queue.add(start);
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for (int x : graph[cur]) {
                if (isVisited[x]) {
                    continue;
                }
                queue.add(x);
                isVisited[x] = true;
            }
        }
        System.out.println(sb);
    }

    public static void dfs(int start) {
        isVisited[start] = true;
        sb.append(start).append(" ");

        for (int x : graph[start]) {
            if (!isVisited[x]) {
                dfs(x);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 1; i <= N ; i++) {
            Collections.sort(graph[i]);
        }

        isVisited = new boolean[N + 1];
        sb = new StringBuilder();
        dfs(V);
        System.out.println(sb);
        bfs(V);
    }
}