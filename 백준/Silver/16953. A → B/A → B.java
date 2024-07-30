import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int bfs() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        StringTokenizer st = new StringTokenizer(comm);
        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());

        Queue<Long> queue = new LinkedList<>();
        queue.add(A);
        int answer = 0;

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long cur = queue.poll();
                if (cur == B) {
                    return answer + 1;
                }

                if (cur * 2 <= B) queue.add(cur * 2);
                if (cur * 10 + 1 <= B) queue.add(cur * 10 + 1);
            }
            answer++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(bfs());
    }
}