import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int num1 = Integer.parseInt(str[0]);
        int num2 = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        int num3 = Integer.parseInt(str[0]);
        int num4 = Integer.parseInt(str[1]);

        int son = num1 * num4 + num2 * num3;
        int mom = num2 * num4;

        int max = 0;
        for (int i = son; i >= 1; i--) {
            if (son % i == 0) {
                if (mom % i == 0) {
                    max = i;
                    break;
                }
            }
        }
        son /= max;
        mom /= max;
        System.out.println(son + " " + mom);
    }
}