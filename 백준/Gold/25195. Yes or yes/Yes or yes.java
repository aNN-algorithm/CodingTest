import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
        }

        int cntFan = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Set<Integer> isFan = new HashSet<>();
        for (int i = 0; i < cntFan; i++) {
            isFan.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> queue = new LinkedList<>();
        if (isFan.contains(1)) {
            System.out.println("Yes");
            return;
        }
        queue.add(1);
        boolean isHappyTour = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (graph[cur].isEmpty()) {
                isHappyTour = false;
                break;
            }

            for (int x : graph[cur]) {
                if (isFan.contains(x)) continue;

                queue.add(x);
            }
        }
        System.out.println(isHappyTour ? "Yes" : "yes");
    }
}