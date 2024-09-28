import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] testResult = new int[N][2];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 2; k++) {
                    testResult[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            Arrays.sort(testResult, (x1, x2) -> (x1[0] == x2[0] ? x1[1] - x2[1] : x1[0] - x2[0]));

            int passingScore = testResult[0][1]; // 서류 심사 1등의 면접 순위
            int cntPassed = 1;
            for (int j = 0; j < N - 1; j++) {
                if (testResult[j][1] < passingScore) {
                    cntPassed++;
                    passingScore = testResult[j][1];
                }
            }
            if (testResult[N - 1][1] == 1) cntPassed++;
            answer.append(cntPassed).append("\n");
        }
        System.out.println(answer);
    }
}