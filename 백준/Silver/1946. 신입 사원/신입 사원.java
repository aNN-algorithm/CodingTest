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
            int[] testResult = new int[N + 1];

            for (int j = 0; j < N; j++) {
                String[] result = br.readLine().split(" ");
                int docScore = Integer.parseInt(result[0]);
                int intvScore = Integer.parseInt(result[1]);
                testResult[docScore] = intvScore;
            }

            int passingScore = testResult[1]; // 서류 심사 1등의 면접 순위
            int cntPassed = 1;
            for (int j = 1; j < N + 1; j++) {
                if (passingScore > testResult[j]) {
                    passingScore = testResult[j];
                    cntPassed++;
                }
            }
            answer.append(cntPassed).append("\n");
        }
        System.out.println(answer);
    }
}