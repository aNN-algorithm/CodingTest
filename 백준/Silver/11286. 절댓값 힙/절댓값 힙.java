import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    int[] arr = queue.poll();
                    System.out.println(arr[1]);
                }
                continue;
            }
            if (num < 0) {
                queue.add(new int[] {num * -1, num});
            } else if (num > 0) {
                queue.add(new int[] {num, num});
            }
        }

    }
}
