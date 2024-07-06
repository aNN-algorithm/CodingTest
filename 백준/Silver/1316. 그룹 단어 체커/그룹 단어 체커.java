import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < T; i++) {
            String comm = br.readLine();
            int[] checkArr = new int[26];
            boolean isGroupVoca = true;

            for (int j = 0; j < comm.length(); j++) {
                char ch = comm.charAt(j);

                if (j > 0 && checkArr[ch - 'a'] > 0) {
                    if (comm.charAt(j - 1) != ch) {
                        isGroupVoca = false;
                    }
                } else {
                    checkArr[ch - 'a']++;
                }
            }
            if (isGroupVoca) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
