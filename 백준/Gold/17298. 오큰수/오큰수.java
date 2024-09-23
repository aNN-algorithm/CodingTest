import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        int[] answer = new int[n];

        String arr = br.readLine();
        StringTokenizer st = new StringTokenizer(arr);
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            answer[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && input[stack.peek()] < input[i]) {
                answer[stack.pop()] = input[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}