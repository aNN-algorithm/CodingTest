import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] network = new ArrayList[V + 1];
        int[] isVirus = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            network[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            network[u].add(v);
            network[v].add(u);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        queue.add(1);
        isVirus[1] = 1;
        int answer = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int x : network[cur]) {
                if (isVirus[x] == 0) {
                    isVirus[x] = 1;
                    queue.add(x);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}