import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] isVisited;
    static int[] sequence;
    static int N;
    static int M;
    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
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

        sequence = new int[N + 1];
        isVisited = new boolean[N + 1];

        dfs(R);

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            answer.append(sequence[i]).append("\n");
        }
        System.out.println(answer);
    }

    public static void dfs(int cur) {
        isVisited[cur] = true;
        sequence[cur] = ++index;

        for (int x : graph[cur]) {
            if (isVisited[x]) continue;
            dfs(x);
        }
    }
}