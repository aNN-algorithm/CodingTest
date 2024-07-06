public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100005];

        for (int i = 0; i < 10000; i++) {
            int num = i;
            int tmp = i;

            while (tmp > 0) {
                num += tmp % 10;
                tmp /= 10;
            }

            arr[num]++;
        }

        for (int i = 1; i < 10000; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
