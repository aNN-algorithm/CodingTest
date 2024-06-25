import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = 0;
        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            char nextChar  = (i < input.length() - 1) ? input.charAt(i + 1) : '\0';
            if (i < input.length() - 1) {
                nextChar = input.charAt(i + 1);
            }

            if (curChar == 'c') {
                if (nextChar == '=' || nextChar == '-') {
                    i++;
                }
            } else if (curChar == 'd') {
                if (nextChar == 'z' && i + 2 < input.length() && input.charAt(i + 2) == '=') {
                    i += 2;
                } else if (nextChar == '-') {
                    i++;
                }
            } else if (curChar == 'l' || curChar == 'n') {
                if (nextChar == 'j') {
                    i++;
                }
            } else if (curChar == 's' || curChar == 'z') {
                if (nextChar == '=') {
                    i++;
                }
            }
            answer++;
        }

        System.out.println(answer);
    }
}
