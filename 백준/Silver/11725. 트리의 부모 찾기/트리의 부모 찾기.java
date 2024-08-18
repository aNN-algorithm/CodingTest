import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] isVisited;
    static int[] parent;
    static LinkedList<Integer>[] tree;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new LinkedList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new LinkedList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] node = br.readLine().split(" ");
            int u = Integer.parseInt(node[0]);
            int v = Integer.parseInt(node[1]);

            tree[u].add(v);
            tree[v].add(u);
        }

        isVisited = new boolean[N + 1];
        parent = new int[N + 1];
        bfs(1);

        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int x : tree[cur]) {
                if (isVisited[x]) {
                    continue;
                }
                parent[x] = cur;
                isVisited[x] = true;
                queue.add(x);
            }
        }
    }
}