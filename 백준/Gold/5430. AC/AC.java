import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < T; i++) {
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String inputArr = br.readLine();
            StringTokenizer st = new StringTokenizer(inputArr, ",[]");

            Deque<Integer> queue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            boolean isLeft = true;
            boolean isEmpty = false;
            for (int j = 0; j < func.length(); j++) {
                char comm = func.charAt(j);
                if (comm == 'R') {
                    isLeft = !isLeft;
                } else {
                    if (queue.isEmpty()) {
                        isEmpty = true;
                        break;
                    }
                    if (isLeft) {
                        queue.pollFirst();
                    } else {
                        queue.pollLast();
                    }
                }
            }

            if (isEmpty) {
                sb.append("error").append("\n");
            } else {
                int size = queue.size();
                int[] arr = new int[size];
                for (int j = 0; j < size; j++) {
                    if (isLeft) {
                        arr[j] = queue.pollFirst();
                    } else {
                        arr[j] = queue.pollLast();
                    }
                }
                StringBuffer sbb = new StringBuffer();
                sbb.append("[");
                for (int j = 0; j < arr.length - 1; j++) {
                    sbb.append(arr[j]).append(",");
                }
                if (size != 0) {
                    sbb.append(arr[arr.length - 1]).append("]");
                } else {
                    sbb.append("]");
                }
                sb.append(sbb).append("\n");
            }
        }

        System.out.println(sb);
    }
}
