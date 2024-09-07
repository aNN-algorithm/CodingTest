import java.io.*;
import java.util.*;

/**
 *
 -----------------------------------------------------------------------------
 * 7 : 좋은 단어(3986)
 * https://www.acmicpc.net/problem/3986
 *
 * 1. stack1 과 stack2 선언
 * 2. stack1 에 입력받은 문자열의 문자를 모두 추가
 * 3. stack1 이 빌 때까지 아래 과정 반복
 *  3-1. stack2 가 비어있으면 stack1 의 최상위 값 삭제 -> stack2 에 추가
 *  3-2. stack2 가 비어있지 않으면, stack1 의 최상위 값과 stack2 의 최상위 값 비교
 *      - 같으면, 두 stack 다 pop
 *      - 다르면, stack1 의 최상위 값 삭제 -> stack2 에 추가
 * 4. stack2가 비어있으면 좋은 문자
 -----------------------------------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();
            String s = br.readLine();

            // stack1 에 입력받은 문자열의 문자를 모두 추가
            for (int j = 0; j < s.length(); j++) {
                stack1.add(s.charAt(j));
            }
            
            while (!stack1.isEmpty()) {
                // stack2 가 비어있으면 stack1 의 최상위 값 삭제 -> stack2 에 추가
                if (stack2.isEmpty()) {
                    stack2.push(stack1.pop());
                    continue;
                }
                // stack2 가 비어있지 않으면, stack1 의 최상위 값과 stack2 의 최상위 값 비교
                if (stack1.peek() == stack2.peek()) { // 같으면, 두 stack 다 pop
                    stack1.pop();
                    stack2.pop();
                } else { // 다르면, stack1 의 최상위 값 삭제 -> stack2 에 추가
                    stack2.push(stack1.pop());
                }
            }
            
            // stack2가 비어있으면 좋은 문자
            if (stack2.isEmpty()) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}