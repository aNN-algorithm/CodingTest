import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        StringBuilder answer = new StringBuilder();

        int[] nums = new int[10];
        for (int i = 0; i < input.length; i++) {
            nums[input[i] - '0']++;
        }

        if (nums[0] == 0) {
            System.out.println(-1);
            return;
        } else {
            nums[0]--;

            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i * nums[i];
            }
            if (sum % 3 != 0) {
                System.out.println(-1);
                return;
            }

            for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < nums[i]; j++) {
                    answer.append(i);
                }
            }
            answer.append(0);
        }
        System.out.println(answer);
    }
}