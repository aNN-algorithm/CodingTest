import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]) - 1;

        Queue<Integer> queue = new LinkedList<>();
        for (Integer i = 1; i <= n; i++) {
            queue.add(i);
        }

        StringBuilder answer = new StringBuilder();
        answer.append("<");

        int cursor = 0;
        while (!queue.isEmpty()) {
            if (cursor == k) {
                answer.append(queue.poll()).append(queue.isEmpty() ? "" : ", ");
                cursor = 0;
            } else {
                queue.offer(queue.poll());
                cursor++;
            }
        }

        answer.append(">");
        System.out.println(answer);
    }
}