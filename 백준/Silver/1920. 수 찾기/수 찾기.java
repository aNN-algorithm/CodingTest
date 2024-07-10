import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        String[] aStr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            map.put(Integer.parseInt(aStr[i]), 1);
        }

        int M = Integer.parseInt(br.readLine());
        aStr = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            if (map.containsKey(Integer.parseInt(aStr[i]))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
