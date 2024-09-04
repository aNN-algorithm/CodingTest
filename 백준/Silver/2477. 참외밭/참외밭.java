import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dir = new int[7];
        int[] len = new int[7];
        int[] dirCount = new int[5];
        for (int i = 1; i < 7; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
            dirCount[dir[i]]++;
        }

        int maxArea = 1;
        int minArea = 1;
        for (int i = 1; i < 7; i++) {
            if (dirCount[dir[i]] != 1) {
                continue;
            }
            maxArea *= len[i];
            int next = i + 3 > 6 ? i - 3 : i + 3;
            minArea *= len[next];
        }
        System.out.println((maxArea - minArea) * n);
    }
}