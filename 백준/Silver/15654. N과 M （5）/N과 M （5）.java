import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int n = 0;
    static int m = 0;
    static StringBuffer sb = new StringBuffer();

    public static void func(int cur, int[] arr, int[] inputArr, boolean[] isUsed) {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isUsed[i] == true) {
                continue;
            }
            arr[cur] = inputArr[i];
            isUsed[i] = true;
            func(cur + 1, arr, inputArr, isUsed);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[n];
        int[] inputArr = new int[n];
        boolean[] isUsed = new boolean[n];

        for (int i = 0; i < n; i++) {
            inputArr[i] = sc.nextInt();
        }
        sc.nextLine();

        Arrays.sort(inputArr);
        func(0, arr, inputArr, isUsed);

        System.out.println(sb);
    }
}