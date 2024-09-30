import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static boolean[] isUsed;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        isUsed = new boolean[n + 1];

        answer = new StringBuilder();
        backTracking(0);
        System.out.println(answer);
    }

    private static void backTracking(int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                answer.append(arr[i]).append(" ");
            }
            answer.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            if (isUsed[i]) continue;
            arr[cur] = i;
            isUsed[i] = true;
            backTracking(cur + 1);
            isUsed[i] = false;
        }
    }
}