import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        StringTokenizer st = new StringTokenizer(comm);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] preSum = new int[n];
        comm = br.readLine();
        st = new StringTokenizer(comm);
        int num = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            num += arr[i];
            preSum[i] += num;
        }

        int[] answer = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            answer[i] = preSum[end];
            if (start != 0) {
                answer[i] -= preSum[start - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(answer[i]);
        }
    }
}