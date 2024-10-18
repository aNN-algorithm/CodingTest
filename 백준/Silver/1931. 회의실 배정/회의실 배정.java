import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] schedules = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedules[i][0] = Integer.parseInt(st.nextToken());
            schedules[i][1] = Integer.parseInt(st.nextToken());
            schedules[i][2] = schedules[i][1] + schedules[i][0];
        }

        Arrays.sort(schedules, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        Set<Integer> set = new HashSet<>();
        int answer = 0;
        int preEndTime = 0;
        for (int i = 0; i < n; i++) {
            if (preEndTime <= schedules[i][0]) {
                preEndTime = schedules[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
