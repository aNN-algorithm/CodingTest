import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[] input;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        StringTokenizer st = new StringTokenizer(comm);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n];
        arr = new int[n];
        comm = br.readLine();
        st = new StringTokenizer(comm);
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        sb = new StringBuilder();
        func(0, 0);
        System.out.println(sb);
    }

    public static void func(int start, int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = start; i < n; i++) {
            if (before == input[i]) {
                continue;
            }
            arr[cur] = input[i];
            before = arr[cur];
            func(i, cur + 1);
        }
    }
}