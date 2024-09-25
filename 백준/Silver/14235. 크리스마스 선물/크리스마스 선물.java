import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.equals("0")) {
                answer.append(pq.isEmpty() ? -1 : pq.poll()).append("\n");
            } else {
                StringTokenizer st = new StringTokenizer(input);
                int cntPresent = Integer.parseInt(st.nextToken());
                for (int j = 0; j < cntPresent; j++) {
                    Integer present = Integer.parseInt(st.nextToken());
                    pq.add(present);
                }
            }
        }
        System.out.println(answer);
    }
}