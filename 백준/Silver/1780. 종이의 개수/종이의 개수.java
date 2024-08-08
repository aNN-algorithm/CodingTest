import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int minusOne;
    static int plusOne;
    static int zero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        minusOne = 0;
        plusOne = 0;
        zero = 0;

        for (int i = 0; i < n; i++) {
            String comm = br.readLine();
            StringTokenizer st = new StringTokenizer(comm);
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findColor(0, 0, n);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);
    }

    public static void findColor(int x, int y, int n) {
        if (isSameColor(x, y, n)) {
            if (map[x][y] == -1) {
                minusOne++;
            } else if (map[x][y] == 1) {
                plusOne++;
            } else {
                zero++;
            }
            return;
        }

        int size = n / 3;
        findColor(x, y, size);
        findColor(x, y + size, size);
        findColor(x, y + 2 * size, size);

        findColor(x + size, y, size);
        findColor(x + size, y + size, size);
        findColor(x + size, y + 2 * size, size);

        findColor(x + 2 * size, y, size);
        findColor(x + 2 * size, y + size, size);
        findColor(x + 2 * size, y + 2 * size, size);

    }

    public static boolean isSameColor(int x, int y, int n) {
        if (n == 1) {
            return true;
        }
        int number = map[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (map[i][j] != number) {
                    return false;
                }
            }
        }
        return true;
    }
}