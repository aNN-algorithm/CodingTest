import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(Integer.parseInt(cards[i]), 1);
        }

        int M = Integer.parseInt(br.readLine());
        cards = br.readLine().split(" ");
        int[] checkCards = new int[M];
        for (int i = 0; i < M; i++) {
            checkCards[i] = Integer.parseInt(cards[i]);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            if (map.containsKey(checkCards[i])) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
