import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] isUsed;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int tail = 0;
        for (int i = 0; i < n; i++) {
            String[] comm = br.readLine().split(" ");
            if (comm[0].equals("push")) {
                tail = Integer.parseInt(comm[1]);
                queue.add(tail);
            } else if (comm[0].equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");;
                }
            } else if (comm[0].equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (comm[0].equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (comm[0].equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.peek()).append("\n");
                }
            } else if (comm[0].equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(tail).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}