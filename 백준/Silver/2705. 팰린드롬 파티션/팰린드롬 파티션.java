import java.io.IOException;
import java.util.Scanner;

/**
 * 6번 - 팰린드롬 파티션
 * https://www.acmicpc.net/problem/2705
 -----------------------------------------------------------------------------

 -----------------------------------------------------------------------------
 */

public class Main {

    private static int answer = 0;
    private static int[] palindromeCnt = new int[1001];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        palindromeCnt[1] = 1;
        palindromeCnt[2] = 2;
        palindromeCnt[3] = 2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            for (int j = 4; j <= N; j++) {
                if (palindromeCnt[j] != 0) {
                    continue;
                }
                for (int k = 1; k <= j / 2; k++) {
                    palindromeCnt[j] += palindromeCnt[k];
                }
                palindromeCnt[j]++;
            }

            sb.append(palindromeCnt[N]).append("\n");
        }
        System.out.println(sb);
    }
}