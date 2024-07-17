import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[21];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String comm = br.readLine();
            StringTokenizer st = new StringTokenizer(comm, " ");
            comm = st.nextToken();

            if (comm.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                arr[num] = true;
            } else if (comm.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                arr[num] = false;
            } else if (comm.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                if (arr[num]) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (comm.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                arr[num] = !arr[num];
            } else if (comm.equals("all")) {
                for (int j = 1; j < 21; j++) {
                    arr[j] = true;
                }
            } else if (comm.equals("empty")) {
                for (int j = 1; j < 21; j++) {
                    arr[j] = false;
                }
            }
        }

        System.out.println(sb);
    }
}