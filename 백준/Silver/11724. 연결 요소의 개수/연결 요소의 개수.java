import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] network = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            network[i] = new ArrayList<>();
        }
        boolean[] isVisited = new boolean[V + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            network[u].add(v);
            network[v].add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;
        for (int i = 1; i <= V; i++) {
            if (isVisited[i]) {
                continue;
            }
            answer++;

            queue.add(i);
            isVisited[i] = true;
            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int x : network[cur]) {
                    if (isVisited[x]) {
                        continue;
                    }
                    queue.add(x);
                    isVisited[x] = true;
                }
            }
        }
        System.out.println(answer);
    }
}