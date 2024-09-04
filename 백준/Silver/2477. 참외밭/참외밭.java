import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 입력되는 수(1, 2, 3, 4)를 인덱스로 사용하기 위해
        // 크기가 7 / 5인 배열 선언
        int[] dir = new int[7];
        int[] len = new int[7];
        int[] dirCount = new int[5];
        for (int i = 1; i < 7; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            // 입력되는 방향과 길이를 그대로 각각의 배열에 저장
            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
            dirCount[dir[i]]++;
        }

        int maxArea = 1;
        int minArea = 1;
        for (int i = 1; i < 7; i++) {
            if (dirCount[dir[i]] != 1) {
                continue;
            }
            // 1번만 입력된 변이 큰 면접의 변이다.
            maxArea *= len[i];
            int next = i + 3 > 6 ? i - 3 : i + 3;
            minArea *= len[next];
        }
        // 입력은 반시계방향으로 진행되므로, 
        // 긴 변이 입력된 후 3번째로 입력되는 변이 짧은 면적의 변이다.
        System.out.println((maxArea - minArea) * n);
    }
}