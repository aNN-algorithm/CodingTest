import java.io.*;
import java.util.*;

/**
 *
 -----------------------------------------------------------------------------
 * 7 : 단어 뒤집기(17413)
 * https://www.acmicpc.net/problem/17413
 * 1. 입력받은 문자열을 < 와 >로 구분하여 Queue에 add
 * 2. Queue에서 문자열을 하나씩 꺼내어,
 *  2-1. 태그인 경우에는 그대로 출력
 *  2-2. 태그가 아닌 경우에는 공백 기준으로 문자열을 공백 기준 파싱 후 뒤집어서 출력
 -----------------------------------------------------------------------------
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();

        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < words.length(); i++) {
            StringBuilder sb = new StringBuilder();
            if (words.charAt(i) == '<') {
                while (true) {
                    sb.append(words.charAt(i));
                    if (words.charAt(i) == '>') {
                        break;
                    }
                    i++;
                }
            } else {
                while (i < words.length()) {
                    if (words.charAt(i) == '<') {
                        i--;
                        break;
                    }
                    sb.append(words.charAt(i));
                    i++;
                }
            }
            queue.add(sb.toString());
        }

        StringBuilder answer = new StringBuilder();
        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (word.charAt(0) == '<') {
                answer.append(word);
            } else {
                String[] partWord = word.split(" ");
                for (int i = 0; i < partWord.length; i++) {
                    String part = partWord[i];
                    Stack<Character> stack = new Stack<>();
                    for (int j = 0; j < part.length(); j++) {
                        stack.push(part.charAt(j));
                    }
                    StringBuilder sb = new StringBuilder();
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    answer.append(sb.toString());
                    if (i < partWord.length - 1) {
                        answer.append(' ');
                    }
                }
            }
        }
        System.out.println(answer.toString());
    }
}