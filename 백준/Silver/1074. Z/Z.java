import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] comm = br.readLine().split(" ");
        
        int N = Integer.parseInt(comm[0]);
        int r = Integer.parseInt(comm[1]);
        int c = Integer.parseInt(comm[2]);

        int size = (int) Math.pow(2, N);
        func(size / 2, r, c);
        System.out.println(answer);
    }

    private static void func(int N, int r, int c) {
        if (N == 0) {
            return;
        }
        if (r < N && c < N ) {
            func(N / 2, r, c);
        } else if (r < N && c >= N ) {
            answer += N * N;
            func(N / 2, r, c - N);
        } else if (r >= N && c < N ) {
            answer += 2 * N * N;
            func(N / 2, r - N , c);
        } else if (r >= N && c >= N) {
            answer += 3 * N * N;
            func(N / 2, r - N, c - N);
        }
    }
}