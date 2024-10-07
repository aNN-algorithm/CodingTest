import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Edge {
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 헛간의 개수 == 찬홍이가 존재하는 정점
        int m = Integer.parseInt(st.nextToken()); // 간선의 길이

        // 인접 리스트 생성
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선의 개수만큼, 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w)); // u번째 정점의 리스트에 Edge 추가
            graph.get(v).add(new Edge(u, w));
        }

        // 우선순위 큐 생성
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        // 1에서 (인덱스)까지 도착하는 최단거리를 저장할 배열
        int[] dist = new int[n + 1];
        // 최단거리 배열은 최댓값으로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 1에서 1까지 도착하는 최단거리는 0이니까...
        dist[1] = 0;
        // 1에서 1까지 도착하는 Edge를 큐에 추가
        pq.add(new Edge(1, 0));

        // 큐가 빌 때까지
        while (!pq.isEmpty()) {
            // Edge를 꺼내어, cur에 저장 - 살펴볼 Edge
            Edge cur = pq.poll();
            // int u = cur.target;
            // int curDist = cur.weight;

            // 현재 cur 에서 target
            if (cur.weight > dist[cur.target]) continue;

            for (Edge edge : graph.get(cur.target)) {
                if (dist[edge.target] > dist[cur.target] + edge.weight) {
                    dist[edge.target] = dist[cur.target] + edge.weight;
                    pq.add(new Edge(edge.target, dist[edge.target]));
                }
            }
        }
        System.out.println(dist[n]);
    }
}