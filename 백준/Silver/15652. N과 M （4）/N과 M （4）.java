import java.util.Scanner;

public class Main {
    static int n = 0;
    static int m = 0;
    static int[] arr = new int[10];
    static StringBuffer sb = new StringBuffer();

    public static void func(int cur, int start) {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[cur] = i;
            func(cur + 1, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        func(0, 1);

        System.out.println(sb);
    }
}