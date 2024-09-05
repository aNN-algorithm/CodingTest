import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 7번 - 칸토어 집합
 * https://www.acmicpc.net/problem/4779
 -----------------------------------------------------------------------------
 *
 -----------------------------------------------------------------------------
 */

public class Main {

    private static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = "";

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int n = Integer.parseInt(input);

            int size = 1;
            for (int j = 0; j < n; j++) {
                size *= 3;
            }
            arr = new char[size];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = '-';
            }

            func(0, size - 1);
            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void func(int x, int y) {
        if (y == x) {
            return;
        }
        int start = x + (y - x + 1) / 3;
        int end = start + (y - x + 1) / 3;
        for (int i = start; i < end; i++) {
            arr[i] = ' ';
        }

        func(x, start - 1);
        func(end, y);
    }
}