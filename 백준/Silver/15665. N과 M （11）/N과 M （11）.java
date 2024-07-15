import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] result;
    static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        arr = new int[n];
        result = new int[m];

        String num = br.readLine();
        StringTokenizer st = new StringTokenizer(num, " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        func(0, 0);
    }

    private static void func(int cur, int x) {
        if (cur == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        int last = 0;
        for (int i = 0; i < n; i++) {
            if (last != arr[i]) {
                result[cur] = arr[i];
                last = result[cur];
                func(cur + 1, i);
            }
        }
    }
}