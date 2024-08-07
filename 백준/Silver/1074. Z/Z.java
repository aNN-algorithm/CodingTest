import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] comm = br.readLine().split(" ");
        int N = Integer.parseInt(comm[0]);
        int r = Integer.parseInt(comm[1]);
        int c = Integer.parseInt(comm[2]);

        int size = (int) Math.pow(2, N);
        func(size, r, c);
        System.out.println(answer);
    }

    public static void func(int size, int r, int c) {
        if (size == 1) {
            return;
        }

        if (r < size/2 && c < size/2) {
            func(size/2, r, c);
        } else if (r < size/2 && c >= size/2) {
            answer += size * size / 4;
            func(size/2, r, c - size/2);
        } else if (r >= size/2 && c < size/2) {
            answer += size * size / 4 * 2;
            func(size/2, r - size/2, c);
        } else {
            answer += size * size / 4 * 3;
            func(size/2, r - size/2, c - size/2);
        }
    }
}