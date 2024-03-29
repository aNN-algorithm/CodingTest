import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        StringTokenizer st = new StringTokenizer(comm);

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        System.out.println(solution(A, B, C));
    }

    public static long solution(long A, long B, long C) {
        long sum = 1L;

        if (B == 1) {
            return A % C;
        }

        sum = solution(A, B / 2, C);

        if (B % 2 == 1) {
            return (sum * sum % C) * A % C;
        }
        return sum * sum % C;
    }
}