import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int num = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            String[] comm = str.split(" ");

            if (comm[0].equals("push")) {
                num = Integer.parseInt(comm[1]);

                queue.add(num);
            } else if (comm[0].equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(queue.poll());
                }
                sb.append("\n");
            } else if (comm[0].equals("size")) {
                sb.append(queue.size());
                sb.append("\n");
            } else if (comm[0].equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else if (comm[0].equals("front")) {
                if (queue.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(queue.peek());
                }
                sb.append("\n");
            } else if (comm[0].equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(num);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}