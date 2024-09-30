import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int src = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] cityMap = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            cityMap[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            cityMap[u].add(v);
        }

        PriorityQueue<Integer> answer = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n + 1];
        int[] tour = new int[n + 1];

        queue.add(src);
        isVisited[src] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int x : cityMap[cur]) {
                if (isVisited[x]) continue;

                if (tour[cur] + 1 == k) {
                    answer.add(x);
                }

                queue.add(x);
                isVisited[x] = true;
                tour[x] = tour[cur] + 1;

            }
        }
        if (answer.isEmpty()) System.out.println(-1);
        else {
            while (!answer.isEmpty()) {
                System.out.println(answer.poll());
            }
        }
    }
}