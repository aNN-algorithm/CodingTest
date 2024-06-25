import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine().toLowerCase();

        int[] findAlphabet = new int[26];

        for (int i = 0; i < comm.length(); i++) {
            findAlphabet[comm.charAt(i) - 'a']++;
        }

        int maxValue = -1;
        int maxIndex = -1;
        boolean isDuplicate = false;
        for (int i = 0; i < 26; i++) {
            if (findAlphabet[i] > maxValue) {
                maxValue = findAlphabet[i];
                maxIndex = i;
                isDuplicate = false;
            } else if (findAlphabet[i] == maxValue) {
                isDuplicate = true;
            }
        }

        if (isDuplicate) {
            System.out.println("?");
        } else {
            System.out.printf("%c", maxIndex + 'A');
        }
    }
}
