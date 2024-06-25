import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        final int[] standardArr = {1, 1, 2, 2, 2, 8};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int[] findArr = new int[6];

        for (int i = 0; i < 6; i++) {
            findArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] needArr = new int[6];

        for (int i = 0; i < 6; i++) {
            needArr[i] = standardArr[i] - findArr[i];
        }

        for (int i = 0; i < 6; i++) {
            System.out.print(needArr[i] + " ");
        }
    }
}
