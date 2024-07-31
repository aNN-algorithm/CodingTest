import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            if (n == 0 && m == 0) {
                break;
            }
            Map<Integer, Integer> mapN = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                mapN.put(num, mapN.getOrDefault(num, 0) + 1);
            }

            Map<Integer, Integer> mapM = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(br.readLine());
                mapM.put(num, mapM.getOrDefault(num, 0) + 1);
            }

            int answer = 0;
            for (int num : mapN.keySet()) {
                if (mapM.containsKey(num)) {
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}