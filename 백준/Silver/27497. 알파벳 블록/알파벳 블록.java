import java.io.*;
import java.util.*;

/**
 *
 -----------------------------------------------------------------------------
 * 5 : 알파벳 블록(27497)
 * https://www.acmicpc.net/problem/27497
 * 입력된 명령어에 따라
 * 1. 1이나 2일 경우에는 앞, 뒤 여부를 Stack 에 추가
 *  - 입력받은 문자를 Deque 에 위치에 맞게 추가
 * 2. 3인 경우에는 Stack 에서 pop 한 앞, 뒤 여부에 따라 deque 에서 삭제
 -----------------------------------------------------------------------------
 */

public class Main {

    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Character> deque = new ArrayDeque<>();
        Stack<Boolean> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String[] comm = br.readLine().split(" ");

            if (comm[0].equals("1")) {
                stack.add(false);
                deque.addLast(comm[1].charAt(0));
            } else if (comm[0].equals("2")) {
                stack.add(true);
                deque.addFirst(comm[1].charAt(0));
            } else if (comm[0].equals("3")) {
                if (deque.isEmpty()) {
                    continue;
                }
                boolean isFirst = stack.pop();
                if (isFirst) deque.removeFirst();
                else deque.removeLast();
            }
        }

        if (deque.isEmpty()) {
            System.out.println(0);
            return;
        }
        int size = deque.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(deque.poll());
        }
        System.out.println(sb);
    }
}