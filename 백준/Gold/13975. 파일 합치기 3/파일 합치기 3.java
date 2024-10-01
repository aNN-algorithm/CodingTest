import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int j = 0; j < k; j++) {
               pq.add(Long.parseLong(st.nextToken()));
            }

            long sumFile = 0;
            while (pq.size() > 1) {
                long file1 = pq.poll();
                long file2 = pq.poll();
                sumFile += file1 + file2;

                pq.offer(file1 + file2);
            }
            answer.append(sumFile).append("\n");
        }
        System.out.println(answer);
    }
}