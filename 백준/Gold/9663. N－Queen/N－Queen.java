import java.util.Scanner;

public class Main {
    static int[] isused1;
    static int[] isused2;
    static int[] isused3;
    static int n;
    static int cnt;

    public static void func(int cur) {
        if (cur == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isused1[i] == 1 || isused2[cur + i] == 1 || isused3[cur - i + n - 1] == 1) {
                continue;
            }
            isused1[i] = 1;
            isused2[cur + i] = 1;
            //isused3[Math.abs(cur - i)] = 1;
            isused3[cur - i + n - 1] = 1;
            func(cur + 1);
            isused1[i] = 0;
            isused2[cur + i] = 0;
            //isused3[Math.abs(cur - i)] = 0;
            isused3[cur - i + n - 1] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cnt = 0;

        isused1 = new int[40];
        isused2 = new int[40];
        isused3 = new int[40];

        func(0);

        System.out.println(cnt);
    }
}