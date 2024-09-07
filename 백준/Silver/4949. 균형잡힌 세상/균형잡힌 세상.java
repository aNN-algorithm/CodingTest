import java.io.*;
import java.util.*;

/**
 *
 -----------------------------------------------------------------------------
 * 8 : 균형잡힌 세상(4949)
 * https://www.acmicpc.net/problem/4949
 *
 * 1. 주어지는 문자열 하나씩 검증
 * 2. "(" 이나 "[" 이 있으면 해당 문자를 stack 에 저장
 * 3. ")" 이나 "]" 이 있으면 stack 에서 pop 한 문자와 비교
 *  3-1. stack 이 비어있으면 매칭 실패
 *  3-2. stack 이 비어있지 않으면 비교하여 매칭 진행
 *      - 현재 문자가 ")" 이면 pop 한 문자가 "(" 인지 확인되면 매칭 성공
 *      - 현재 문자가 "]" 이면 pop 한 문자가 "[" 인지 확인되면 매칭 성공
 -----------------------------------------------------------------------------
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        StringBuilder answer = new StringBuilder();
        while ((input = br.readLine()) != null && !input.equals(".")) {
            Stack<Character> stack = new Stack<>();

            boolean isYes = true; // 매칭 여부에 대한 flag 변수
            for (int i = 0; i < input.length(); i++) {

                // "(" 이나 "[" 이 있으면 해당 문자를 stack 에 저장
                if (input.charAt(i) == '(' || input.charAt(i) == '[') {
                    stack.push(input.charAt(i));
                    continue;
                }

                // ")" 이나 "]" 이 있으면 stack 에서 pop 한 문자와 비교
                if (input.charAt(i) == ')' || input.charAt(i) == ']') {

                    // stack 이 비어있으면 매칭 실패
                    if (stack.isEmpty()) {
                        isYes = false;
                        break;
                    }

                    // stack 이 비어있지 않으면 비교하여 매칭 진행
                    char ch = stack.pop();
                    // 매칭되지 않으면, false 저장
                    isYes = (ch == '(' && input.charAt(i) == ')')
                            || (ch == '[' && input.charAt(i) == ']');
                    if (!isYes) break;
                }
            }
            // 문자열 검증이 끝나도 stack 이 비어있지 않으면 매칭 실패
            if (!stack.isEmpty()) isYes = false;
            
            // 매칭 결과 출력
            if (isYes) answer.append("yes").append("\n");
            else answer.append("no").append("\n");
        }
        System.out.println(answer);
    }
}