import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] arrA = new Integer[n];
        Integer[] arrB = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        Integer sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arrA[i] * arrB[i];
        }
        System.out.println(sum);
    }
}