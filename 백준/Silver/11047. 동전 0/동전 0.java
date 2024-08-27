import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] comm = br.readLine().split(" ");
        int n = Integer.parseInt(comm[0]);
        int K = Integer.parseInt(comm[1]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tmp = K;
        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] <= tmp) {
                answer += tmp / arr[i];
                tmp %= arr[i];
            }
        }
        System.out.println(answer);
    }
}