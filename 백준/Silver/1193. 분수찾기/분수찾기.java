import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int index = 0;
        int x = 0;
        int y = 0;
        boolean isFind = false;
        for (int i = 1; ; i++) {
            if (isFind) {
                break;
            }
            for (int j = 1; j <= i; j++) {
                index++;
                if (index == N) {
                    if (i % 2 == 0) {
                        x = j;
                        y = i + 1 - j;
                    } else {
                        x = i + 1 - j;
                        y = j;
                    }

                    isFind = true;
                    break;
                }
            }
        }

        System.out.println(x + "/" + y);
    }
}
