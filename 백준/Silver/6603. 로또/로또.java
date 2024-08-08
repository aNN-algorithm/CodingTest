import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] input;
    static int[] lotto;
    static boolean[] isUsed;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        sb = new StringBuilder();
        
        while (!comm.equals("0")) {
            StringTokenizer st = new StringTokenizer(comm);
            n = Integer.parseInt(st.nextToken());
            input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            
            lotto = new int[6];
            isUsed = new boolean[n];
            selectLotto(0, 0);

            sb.append("\n");
            comm = br.readLine();
        }
        System.out.println(sb);
    }

    public static void selectLotto(int start, int cur) {
        if (cur == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(lotto[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (isUsed[i]) {
                continue;
            }
            lotto[cur] = input[i];
            isUsed[i] = true;
            selectLotto(i, cur + 1);
            isUsed[i] = false;
        }
    }
}