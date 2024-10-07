import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int MAX_COUNT_FRIEND = 51;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] friendship = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == j) continue;
                friendship[i][j] = MAX_COUNT_FRIEND;
            }
        }

        String input = "";
        while ((input = br.readLine()) != null && !input.equals("-1 -1")) {
            StringTokenizer st = new StringTokenizer(input);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            friendship[u][v] = 1;
            friendship[v][u] = 1;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (friendship[i][j] > friendship[i][k] + friendship[k][j]) {
                        friendship[i][j] = friendship[i][k] + friendship[k][j];
                    }
                }
            }
        }

        int[] scores = new int[n + 1];
        int min = MAX_COUNT_FRIEND;
        for (int i = 1; i < n + 1; i++) {
            int max = 0;
            for (int j = 1; j < n + 1; j++) {
                max = Math.max(max, friendship[i][j]);
            }
            min = Math.min(min, max);
            scores[i] = max;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (min == scores[i]) list.add(i);
        }

        System.out.println(min + " " + list.size());
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}