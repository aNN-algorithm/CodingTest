import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[102];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine()) - 1;

            if (dp[n] != 0) {
                answer.append(dp[n]).append("\n");
                continue;
            }
            for (int j = 5; j <= n; j++) {
                if (dp[j] != 0) continue;
                dp[j] = dp[j - 1] + dp[j - 5];
            }
            answer.append(dp[n]).append("\n");
        }
        System.out.println(answer);
    }
}