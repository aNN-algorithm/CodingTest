import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int WORD_LEN = 50;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<String>[] dictionary = new ArrayList[WORD_LEN + 1];
        for (int i = 0; i < WORD_LEN + 1; i++) {
            dictionary[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (dictionary[word.length()].contains(word)) continue;
            dictionary[word.length()].add(word);
            Collections.sort(dictionary[word.length()]);
        }

        for (int i = 0; i < WORD_LEN + 1; i++) {
            for (String word : dictionary[i]) {
                System.out.println(word);
            }
        }
    }
}