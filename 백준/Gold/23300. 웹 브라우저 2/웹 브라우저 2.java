import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        StringTokenizer st = new StringTokenizer(num, " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Stack<Integer> backStack = new Stack<>();
        Stack<Integer> frontStack = new Stack<>();
        int nowPage = 0;
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("B")) {
                if (!backStack.isEmpty()) {
                    frontStack.push(nowPage);
                    nowPage = backStack.pop();
                }
            }
            else if (input[0].equals("F")) {
                if (!frontStack.isEmpty()) {
                    backStack.push(nowPage);
                    nowPage = frontStack.pop();
                }
            }
            else if (input[0].equals("A")) {
                    if (nowPage != 0) {
                        frontStack = new Stack<>();
                        backStack.push(nowPage);
                    }
                    nowPage = Integer.parseInt(input[1]);
                }
            else if (input[0].equals("C")) {
                Stack<Integer> press = new Stack<>();
                int size = backStack.size() - 1;
                if (backStack.isEmpty()) {
                    continue;
                }
                press.push(backStack.pop());
                for (int j = 0; j < size; j++) {
                    if (Objects.equals(press.peek(), backStack.peek())) {
                        backStack.pop();
                    } else {
                        press.push(backStack.pop());
                    }
                }
                size = press.size();
                for (int j = 0; j < size; j++) {
                    backStack.push(press.pop());
                }
            }
        }
        System.out.println(nowPage);
        if (backStack.isEmpty()) {
            System.out.println(-1);
        } else {
            int size = backStack.size();
            for (int i = 0; i < size; i++) {
                System.out.print(backStack.pop() + " ");
            }
            System.out.println();
        }
        if (frontStack.isEmpty()) {
            System.out.println(-1);
        } else {
            int size = frontStack.size();
            for (int i = 0; i < size; i++) {
                System.out.print(frontStack.pop() + " ");
            }
            System.out.println();
        }
    }
}