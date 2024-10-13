import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int onePointer = 0;
        int twoPointer = 0;
        int max = 0;
        int len;
        Map<Integer, Integer> map = new HashMap<>();
        while (twoPointer < n) {

            int number = arr[twoPointer];
            if (map.containsKey(number) && map.get(number) >= k) {
                int number2 = arr[onePointer];
                map.put(number2, map.get(number2) - 1);
                onePointer++;
            } else {
                map.put(number, map.getOrDefault(number, 0) + 1);
                twoPointer++;
            }
            len = twoPointer - onePointer;
            max = Math.max(max, len);

        }

        System.out.println(max);
    }
}
