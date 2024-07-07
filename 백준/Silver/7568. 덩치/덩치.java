import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(info[0]);
            arr[i][1] = Integer.parseInt(info[1]);
            arr[i][2] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
                    arr[j][2]++;
                } else if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    arr[i][2]++;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            System.out.print(arr[k][2] + " ");
        }
    }
}
