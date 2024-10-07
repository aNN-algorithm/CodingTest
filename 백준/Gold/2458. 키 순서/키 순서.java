import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int MAX_CNT_STUDENT = 500;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] height = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) continue;

                height[i][j] = MAX_CNT_STUDENT;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            height[u][v] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (height[i][j] > height[i][k] + height[k][j]) {
                        height[i][j] = height[i][k] + height[k][j];
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (height[i][j] <= 0 || height[i][j] >= MAX_CNT_STUDENT) continue;
                height[j][i] = height[i][j] * -1;
            }
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            int cntBigger = 0;
            for (int j = 1; j < n + 1; j++) {
                if (height[i][j] == MAX_CNT_STUDENT) continue;
                cntBigger++;
            }
            if (cntBigger == n) answer++;
        }

        System.out.println(answer);
    }
}