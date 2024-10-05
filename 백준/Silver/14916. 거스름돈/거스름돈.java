import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        // 시스템 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n < 5 && n % 2 == 1) {
            System.out.println(-1);
            return;
        }

        int cntOfCoin = n / 5;
        int remainingCoins = n % 5;
        if (remainingCoins % 2 == 0) {
            cntOfCoin += remainingCoins / 2;
        } else {
            remainingCoins += 5;
            cntOfCoin += remainingCoins / 2 - 1;
        }
        System.out.println(cntOfCoin);
    }
}