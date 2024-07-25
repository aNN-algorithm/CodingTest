import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] score = br.readLine().split(" ");
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(score[i]);
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        double sum = 0;
        for (Integer num : arr) {
            sum += (double) num / max * 100;
        }
        System.out.println(sum/n);
    }
}