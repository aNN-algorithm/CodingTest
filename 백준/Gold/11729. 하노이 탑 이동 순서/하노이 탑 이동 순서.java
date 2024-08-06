import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 1;
        for (int i = 0; i < n; i++) {
            answer *= 2;
        }
        System.out.println(answer - 1);
        func(1, 3, n);
        System.out.println(sb);
    }

    public static void func(int a, int b, int n) {
        if (n == 1) {
            sb.append(a + " " + b).append("\n");
            return;
        }

        func(a, 6-a-b, n-1);
        sb.append(a + " " + b).append("\n");
        func(6-a-b, b, n-1);
    }
}