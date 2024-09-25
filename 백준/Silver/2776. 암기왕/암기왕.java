import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int cntNote1 = Integer.parseInt(br.readLine());
            Map<Integer, Integer> note1 = new HashMap<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            for (int j = 0; j < cntNote1; j++) {
                int number = Integer.parseInt(st.nextToken());
                note1.put(number, note1.getOrDefault(number, 0) + 1);
            }

            int cntNote2 = Integer.parseInt(br.readLine());
            int[] note2 = new int[cntNote2];
            input = br.readLine();
            st = new StringTokenizer(input);
            for (int j = 0; j < cntNote2; j++) {
                note2[j] = Integer.parseInt(st.nextToken());
            }

            StringBuilder answer = new StringBuilder();
            for (int j = 0; j < cntNote2; j++) {
                answer.append(note1.containsKey(note2[j]) ? 1 : 0).append(" ");
            }
            System.out.println(answer);
        }
    }
}