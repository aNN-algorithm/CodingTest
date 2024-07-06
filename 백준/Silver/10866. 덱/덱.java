import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < T; i++) {
            String[] comm = br.readLine().split(" ");

            if (comm[0].equals("push_back")) {
                deque.addLast(Integer.parseInt(comm[1]));
            } else if (comm[0].equals("push_front")) {
                deque.addFirst(Integer.parseInt(comm[1]));
            } else if (comm[0].equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.peekFirst()).append("\n");
                }
            } else if (comm[0].equals("back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.peekLast()).append("\n");
                }
            } else if (comm[0].equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (comm[0].equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (comm[0].equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.pollFirst()).append("\n");
                }
            } else if (comm[0].equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.pollLast()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
