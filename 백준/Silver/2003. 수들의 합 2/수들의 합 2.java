import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] comm = br.readLine().split(" ");
        int N = Integer.parseInt(comm[0]);
        int M = Integer.parseInt(comm[1]);
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int j = 0; j < N; j++) {
            int sum = arr[j];
            if (sum == M) {
                answer++;
                continue;
            }
            for (int k = j + 1; k < N; k++) {
                if (sum + arr[k] == M) {
                    answer++;
                    break;
                }
                if (sum + arr[k] < M) {
                    sum += arr[k];
                } else if (sum + arr[k] > M) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
