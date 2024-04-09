import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        StringTokenizer st = new StringTokenizer(comm);

        int T = Integer.parseInt(st.nextToken());
        int[] coin = new int[T];
        int sum = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = T - 1; i >= 0; i--) {
            if (coin[i] <= sum) {
                cnt = cnt + sum / coin[i];
                sum %= coin[i];
            }
        }

        System.out.println(cnt);
    }
}