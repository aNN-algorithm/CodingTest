import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 7번 - 칸토어 집합
 * https://www.acmicpc.net/problem/4779
 -----------------------------------------------------------------------------
 * 3의 세제곱으로 이루어진 배열을 3등분 하여 지울 위치를 찾아 지우고,
 * 양 옆의 배열을 다시 재귀의 파라미터 값으로 넣어 반복
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
            Arrays.fill(arr, '-');

            func(0, size - 1);
            
            // 출력
            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void func(int x, int y) {
        // base condition
        if (y == x) {
            return;
        }
        
        // 지울 위치 확인
        int start = x + (y - x + 1) / 3;
        int end = start + (y - x + 1) / 3;
        for (int i = start; i < end; i++) {
            arr[i] = ' ';
        }

        func(x, start - 1);
        func(end, y);
    }
}