import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int blue;
    static int white;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        blue = 0;
        white = 0;

        for (int i = 0; i < n; i++) {
            String comm = br.readLine();
            StringTokenizer st = new StringTokenizer(comm);
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findColor(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void findColor(int x, int y, int n) {
        if (isSameColor(x, y, n)) {
            if (map[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        findColor(x, y, n / 2);
        findColor(x + n / 2, y, n / 2);
        findColor(x, y + n / 2, n / 2);
        findColor(x + n / 2, y + n / 2, n / 2);
    }

    public static boolean isSameColor(int x, int y, int n) {
        if (n == 1) {
            return true;
        }
        int color = map[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (map[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}