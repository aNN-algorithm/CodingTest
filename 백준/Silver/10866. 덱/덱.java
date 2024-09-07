import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 -----------------------------------------------------------------------------
 * 6 : 덱(10866)
 * https://www.acmicpc.net/problem/10866
 *
 * 입력된 문자열을 공백 기준으로 파싱하여
 * 명령어에 따라 Deque 에 입력 및 추가 실행
 *
 -----------------------------------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            if (command[0].equals("push_front")) {
                deque.addFirst(Integer.parseInt(command[1]));
            } else if (command[0].equals("push_back")) {
                deque.addLast(Integer.parseInt(command[1]));
            } else if (command[0].equals("pop_front")) {
                if (deque.isEmpty()) answer.append("-1");
                else answer.append(deque.removeFirst());
                answer.append("\n");
            } else if (command[0].equals("pop_back")) {
                if (deque.isEmpty()) answer.append("-1");
                else answer.append(deque.removeLast());
                answer.append("\n");
            } else if (command[0].equals("size")) {
                answer.append(deque.size());
                answer.append("\n");
            } else if (command[0].equals("empty")) {
                if (deque.isEmpty()) answer.append("1");
                else answer.append("0");
                answer.append("\n");
            } else if (command[0].equals("front")) {
                if (deque.isEmpty()) answer.append("-1");
                else answer.append(deque.peekFirst());
                answer.append("\n");
            } else if (command[0].equals("back")) {
                if (deque.isEmpty()) answer.append("-1");
                else answer.append(deque.peekLast());
                answer.append("\n");
            }
        }
        System.out.println(answer);
    }
}