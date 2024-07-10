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
            int num = Integer.parseInt(aStr[i]);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        aStr = br.readLine().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(aStr[i]);
            if (map.containsKey(num)) {
                sb.append(map.get(num)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
