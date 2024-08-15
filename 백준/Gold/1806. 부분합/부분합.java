
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = arr[0];
        int fin = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            while (total < S && fin < N) {
                fin++;
                if (fin != N) {
                    total += arr[fin];
                }
            }
            if (total < S) {
                continue;
            }
            min = Math.min(min, fin - i + 1);
            total -= arr[i];
        }
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        System.out.println(min);
    }
}