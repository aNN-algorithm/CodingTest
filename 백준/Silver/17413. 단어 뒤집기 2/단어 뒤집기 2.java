import java.io.*;
import java.util.*;

/**
 *
 -----------------------------------------------------------------------------
 * 7 : 단어 뒤집기(17413)
 * https://www.acmicpc.net/problem/17413
 * 1. 입력받은 문자열을 < 와 >로 구분하여 Queue 에 add
 * 2. Queue 에서 문자열을 하나씩 꺼내어,
 *  2-1. 태그인 경우에는 그대로 출력
 *  2-2. 태그가 아닌 경우에는 공백 기준으로 문자열을 공백 기준 파싱 후 뒤집어서 출력
 -----------------------------------------------------------------------------
 */

public class Main {

    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();

        // 입력 받은 문자열을 < 와 > 로 구분하여 Queue 에 add
        for (int i = 0; i < words.length(); i++) {
            StringBuilder sb = new StringBuilder();

            if (words.charAt(i) == '<') { // 태그인 문자열을 발견했을 때
                // 태그 끝까지 찾아내어 StringBuilder 에 저장
                while (true) {
                    sb.append(words.charAt(i));
                    if (words.charAt(i) == '>') {
                        break;
                    }
                    i++;
                }
            } else { // 태그가 아닌 문자열인 경우
                // 태그가 아닌 문자열 끝까지 StringBuilder 에 저장
                while (i < words.length()) {
                    if (words.charAt(i) == '<') {
                        i--;
                        break;
                    }
                    sb.append(words.charAt(i));
                    i++;
                }
            }
            // 태그 혹은 문자열을 Queue 에 add
            // <tag>word word<tag>의 경우
            // <tag>
            // word word
            // <tag>
            // 위처럼 Queue 에 add
            queue.add(sb.toString());
        }

        // 정답을 출력할 StringBuilder answer 선언
        StringBuilder answer = new StringBuilder();
        // Queue에 저장된 문자열을 꺼내어 출력
        while (!queue.isEmpty()) {
            String word = queue.poll();

            if (word.charAt(0) == '<') { // 저장된 문자열이 태그인 경우
                // 태그 통째로 출력 -> answer 에 저장
                answer.append(word);
            } else { // 저장된 문자열이 태그가 아닌 경우
                // 해당 문자열을 공백 기준 파싱
                String[] partWord = word.split(" ");

                // 파싱된 문자열은 문자 하나씩 stack 에 push 후 pop 하여 거꾸로 출력
                for (int i = 0; i < partWord.length; i++) {
                    // 거꾸로 출력할 문자열
                    String part = partWord[i];

                    Stack<Character> stack = new Stack<>();
                    // 문자열의 문자 하나씩 stack 에 push
                    for (int j = 0; j < part.length(); j++) {
                        stack.push(part.charAt(j));
                    }

                    // stack 에서 다시 pop 하여 StringBuilder 에 임시 저장
                    StringBuilder sb = new StringBuilder();
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    // pop하여 거꾸로 저장된 문자열 answer 에 저장
                    answer.append(sb.toString());

                    // 공백이 있는 경우에는 answer 에 공백 추가
                    if (i < partWord.length - 1) {
                        answer.append(' ');
                    }
                }
            }
        }
        System.out.println(answer.toString());
    }
}