import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] commands = br.readLine().split(" ");
            String command = commands[0];
            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(commands[1]));
                    break;
                case "pop":
                    answer.append(stack.isEmpty() ?  -1 : stack.pop()).append("\n");
                    break;
                case "size":
                    answer.append(stack.size()).append("\n");
                    break;
                case "empty":
                    answer.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    answer.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }

        System.out.println(answer);
    }
}