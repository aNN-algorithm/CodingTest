import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 10;
        if (n == 1) {
            System.out.println(answer);
            return;
        }

        int k = 0;
        int pow = 2;
        while (n >= pow) {
            k++;
            pow *= 2;
        }
        System.out.println(answer + k);
    }
}