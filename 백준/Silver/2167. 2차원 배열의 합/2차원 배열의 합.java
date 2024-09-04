import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int sum = 0;
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    sum += matrix[j][k];
                }
            }
            System.out.println(sum);
        }
    }
}