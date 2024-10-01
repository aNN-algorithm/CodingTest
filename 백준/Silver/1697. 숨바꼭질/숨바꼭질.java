import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int MAX_POS = 100000;

    public static class position {
        int pos;
        int time;

        public position(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<position> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[MAX_POS + 1];

        queue.add(new position(n, 0));
        isVisited[n] = true;

        while (!queue.isEmpty()) {
            position cur = queue.poll();

            if (cur.pos == k) {
                System.out.println(cur.time);
                return;
            }

            for (int d : new int[]{-1, 1, cur.pos}) {
                int x = cur.pos + d;

                if (x < 0 || x > MAX_POS) continue;
                if (isVisited[x]) continue;

                queue.add(new position(x, cur.time + 1));
                isVisited[x] = true;
            }
        }
    }
}