import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");

        for (int i = 0; i < input.length; i++) {
            String[] operands = input[i].split("\\+");
            int temp = 0;
            for (int j = 0; j < operands.length; j++) {
                temp += Integer.parseInt(operands[j]);
            }
            input[i] = String.valueOf(temp);
        }

        int answer = Integer.parseInt(input[0]);
        for (int i = 1; i < input.length; i++) {
            answer -= Integer.parseInt(input[i]);
        }
        System.out.println(answer);
    }
}