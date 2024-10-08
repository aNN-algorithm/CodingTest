import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin  = br.readLine();
        String word = br.readLine();

        String result = origin.replace(word, "*");

        int answer = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '*') answer++;
        }
        System.out.println(answer);
    }
}