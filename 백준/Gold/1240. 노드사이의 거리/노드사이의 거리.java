import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Node>[] tree = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[u].add(new Node(v, weight));
            tree[v].add(new Node(u, weight));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int[] isVisited = new int[n + 1];
            for (int j = 0; j < n + 1; j++) {
                isVisited[j] = -1;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            isVisited[start] = 0;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (Node x : tree[cur]) {
                    if (isVisited[x.dest] > -1) continue;

                    isVisited[x.dest] = isVisited[cur] + x.weight;
                    queue.add(x.dest);
                }
            }
            sb.append(isVisited[end]).append("\n");
        }
        System.out.println(sb);
    }
}
