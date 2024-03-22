import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pair {
        int tmp;
        int sec;

        public Pair(int tmp, int sec) {
            this.tmp = tmp;
            this.sec = sec;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        StringTokenizer st = new StringTokenizer(comm);

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visited = new int[100005];

        Queue<Pair> queue = new LinkedList<>();
        int cnt = 0;
        queue.add(new Pair(N, 0));
        visited[N] = 1;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            if (cur.tmp == X) {
                cnt = cur.sec;
                break;
            }

            if (cur.tmp - 1 >= 0 && visited[cur.tmp - 1] == 0) {
                queue.add(new Pair(cur.tmp - 1, cur.sec + 1));
                visited[cur.tmp - 1] = 1;
            }
            if (cur.tmp + 1 <= 100000 && visited[cur.tmp + 1] == 0) {
                queue.add(new Pair(cur.tmp + 1, cur.sec + 1));
                visited[cur.tmp + 1] = 1;
            }
            if (cur.tmp * 2 <= 100000 && visited[cur.tmp * 2] == 0) {
                queue.add(new Pair(cur.tmp * 2, cur.sec + 1));
                visited[cur.tmp * 2] = 1;
            }
        }

        System.out.println(cnt);
    }
}