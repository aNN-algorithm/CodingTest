import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 5번 - Z
 * https://www.acmicpc.net/problem/1074
 --------------------------------------
 * Key point : 몇 번째 방문했는지가 중요
 * 1. 배열(N * N)을 4등분해서, 현재 위치가 어느 면(N / 2 * N / 2)에 있는지 파악 필요
 * ┌───┬───┐
 * │ 1 │ 2 │
 * ├───┼───┤
 * │ 3 │ 4 │
 * └───┴───┘
 * 2 - 1. 다른 면에 방문하지 않음
 * 2 - 2. 첫 번째 면에 방문함
 * 2 - 3. 첫 번재, 두 번재 면에 방문함
 * 2 - 4. 첫 번째, 두 번째, 세 번재 면에 방문함
 * 즉, 다른 면 방문 수 * 면(N / 2 * N / 2)의 크기만큼 방문
 * 3. 현재 위치하는 면을 또 4등분하여 1번부터 반복
 * (위치하는 좌표 r, c는 새로운 면에서의 위치를 파악해야 하므로, 경우에 맞게 N을 빼야 한다.)
 */

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

        // N은 현재 배열의 길이를 2로 나눈 값
        if (r < N && c < N ) { // 1번 면
            func(N / 2, r, c);
        } else if (r < N && c >= N ) { // 2번 면
            answer += N * N;
            func(N / 2, r, c - N);
        } else if (r >= N && c < N ) { // 3번 면
            answer += 2 * N * N;
            func(N / 2, r - N , c);
        } else if (r >= N && c >= N) { // 4번 면
            answer += 3 * N * N;
            func(N / 2, r - N, c - N);
        }
    }
}