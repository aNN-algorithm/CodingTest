import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[] answer;
    static StringBuilder sb;

    public static void func(int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            answer[cur] = arr[i];
            func(cur + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        StringTokenizer st = new StringTokenizer(comm);
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = new int[m];

        comm = br.readLine();
        st = new StringTokenizer(comm);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        func(0);
        System.out.println(sb);
    }
}