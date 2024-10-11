import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][][] dp = new int[T + 1][W + 1][3]; // 자두가 떨어지는 위치 | 이동 횟수 | 위치

        int tree = Integer.parseInt(br.readLine());

        if (tree == 1) {
            // 처음에 1번 나무에서 떨어진다면?
            dp[1][0][1] = 1; // 자두도 1번에서 시작
        } else {
            // 처음 2번 나무에서 떨어진다면?
            dp[1][1][2] = 1; // 자두는 2번으로 이동
        }

        for (int i = 2; i < T + 1; i++) {
            tree = Integer.parseInt(br.readLine());

            // i번째(현재) 자두가 떨어질 때,
            if (tree == 1) { // 자두가 1번 나무에서 떨어진다면
                // 여태 이동을 1번도 안 했을 때,
                // 현재 나의 위치가 1번일 때,
                dp[i][0][1] = dp[i - 1][0][1] + 1; // 자두를 얻음
                // 현재 나의 위치가 2번일 때,
                dp[i][0][2] = dp[i - 1][0][2]; // 자두를 얻지 못함

                // W번 이동을 했을 때,
                for (int j = 1; j < W + 1; j++) {
                    // 현재 나의 위치가 1번일 때,
                    // (i - 1)번째(이전)에
                    // - 1번이면 위치 유지 -> j 그대로
                    // - 2번이면 위치 이동 -> j - 1 이동 횟수 감소
                    // 그중 큰 것 + 1(자두를 얻음)
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + 1;
                    // 현재 나의 위치가 2번일 때,
                    // (i - 1)번째(이전)에
                    // - 1번이면 위치 이동 -> j - 1 이동 횟수 감소
                    // - 2번이면 위치 유지 -> j 그대로
                    // 그중 큰 것 (자두는 얻지 못함)
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]);
                }
            } else { // 자두가 2번 나무에서 떨어진다면
                // 여태 이동을 1번도 안 했을 때,
                // 현재 나의 위치가 1번일 때,
                dp[i][0][1] = dp[i - 1][0][1]; // 자두를 얻지 못함
                // 현재 나의 위치가 2번일 때
                dp[i][0][2] = dp[i - 1][0][2] + 1; // 자두를 얻음

                // W번 이동을 했을 때
                for (int j = 1; j < W + 1; j++) {
                    // 현재 나의 위치가 1번일 때
                    // (i - 1)번째(이전)에
                    // - 1번이면 위치 유지 -> j 그대로
                    // - 2번이면 위치 이동 -> j - 1 이동 횟수 감소
                    // 그중 큰 것 (자두는 얻지 못함)
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
                    // 현재 나의 위치가 2번일 때
                    // (i - 1)번째(이전)에
                    // - 1번이면 위치 이동 -> j - 1 이동 횟수 감소
                    // - 2번이면 위치 유지 -> j 그대로
                    // 그중 큰 것 (자두를 얻음)
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]) + 1;
                }
            }
        }

        // 자두가 다 떨어졌을 때
        // 모든 이동의 횟수 중 1번과 2번 중 큰 값이 얻을 수 있는 자두의 가장 큰 수
        int answer = 0;
        for (int i = 0; i < W + 1; i++) {
            answer = Math.max(answer, Math.max(dp[T][i][1], dp[T][i][2]));
        }
        System.out.println(answer);
    }
}