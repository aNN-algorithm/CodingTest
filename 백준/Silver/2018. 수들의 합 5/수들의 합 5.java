import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = 0;
        for (int i = 1; i < n / 2 + 1; i++) {
            int sum = 0;
            for (int j = i; j <= n / 2 + 1; j++) {
                sum += j;
                if (sum > n) {
                    break;
                }
                if (sum == n) {
                    answer++;
                }
            }
        }
        System.out.println(answer + 1);
    }
}