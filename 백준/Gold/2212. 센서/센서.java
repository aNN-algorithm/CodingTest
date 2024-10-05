import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 시스템 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // 센서 입력
        Integer[] sensors = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors);

        // 센서의 간격을 저장할 배열 선언
        Integer[] distOfSensors = new Integer[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distOfSensors[i] = sensors[i + 1] - sensors[i];
        }

        // 센서의 간격 배열 내림차순으로 정렬
        Arrays.sort(distOfSensors, Collections.reverseOrder());

        int answer = 0;
        for (int i = k - 1; i < n - 1; i++) {
            answer += distOfSensors[i];
        }
        System.out.println(answer);
    }
}