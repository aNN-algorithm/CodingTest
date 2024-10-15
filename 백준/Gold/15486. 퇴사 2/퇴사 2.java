import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] day = new int[n + 1];   // 각 상담에 걸리는 시간
        int[] price = new int[n + 1]; // 각 상담의 수익
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 2]; // dp 배열 크기를 n+2로 설정 (범위를 초과하지 않도록 하기 위해)
        int max = 0;

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]); // 현재까지의 최대 수익을 갱신

            dp[i] = Math.max(dp[i], dp[i] + price[i]);
            int nextDay = i + day[i]; // 다음 상담을 시작할 수 있는 날

            // 상담이 종료되는 날짜가 범위 내에 있을 경우
            if (nextDay <= n + 1) {
                dp[nextDay] = Math.max(dp[nextDay], max + price[i]);
            }
        }

        // 최종적으로 최대 수익 출력
        System.out.println(Math.max(max, dp[n + 1]));
    }
}
