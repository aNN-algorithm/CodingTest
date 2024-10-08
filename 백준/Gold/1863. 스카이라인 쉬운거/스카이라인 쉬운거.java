import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int cntOfBuilding = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                cntOfBuilding++;
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() == y) {
                continue;
            }
            stack.push(y);
        }

        while (!stack.isEmpty()) {
            if(stack.peek() > 0) {
                cntOfBuilding++;
            }
            stack.pop();
        }
        System.out.println(cntOfBuilding);
    }
}