import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int[] arr;
    static boolean[] isUsed;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        StringTokenizer st = new StringTokenizer(comm);
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isUsed = new boolean[N + 1];
        arr = new int[N];

        func(1, 0);
        System.out.println(sb);
    }

    public static void func(int x, int cur) {
        if (cur == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = x; i <= N; i++) {
            if (isUsed[i]) {
                continue;
            }
            arr[cur] = i;
            isUsed[i] = true;
            func(i, cur + 1);
            isUsed[i] = false;
        }
    }
}