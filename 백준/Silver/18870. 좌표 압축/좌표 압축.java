import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        Map<Integer, Integer> cntOfNum = new HashMap<>();
        cntOfNum.put(sortedArr[0], 0);
        for (int i = 1; i < n; i++) {
            if (sortedArr[i] == sortedArr[i - 1]) {
                continue;
            }
            cntOfNum.put(sortedArr[i], cntOfNum.get(sortedArr[i - 1]) + 1);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(cntOfNum.get(arr[i])).append(" ");
        }
        System.out.println(answer);
    }
}