import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] isUsed;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        n = Integer.parseInt(comm);

        arr = new int[n];
        isUsed = new boolean[n + 1];
        sb = new StringBuilder();

        func(0);
        System.out.println(sb);
    }

    private static void func(int cur) {
        if (cur == n) {
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (isUsed[i]) {
                continue;
            }
            arr[cur] = i;
            isUsed[i] = true;
            func(cur + 1);
            isUsed[i] = false;
        }
    }
}