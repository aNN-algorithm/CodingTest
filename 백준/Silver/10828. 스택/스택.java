import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine(), " ");
            String comm = str.nextToken();

            if (comm.equals("push")) {
                int num = Integer.parseInt(str.nextToken());
                stack.add(num);
            } else if (comm.equals("top")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.peek()).append('\n');
                }
            } else if (comm.equals("size")) {
                sb.append(stack.size()).append('\n');
            } else if (comm.equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (comm.equals("pop")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.pop()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
