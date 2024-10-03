import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cntStudent = Integer.parseInt(br.readLine());
        int[][] students = new int[cntStudent][5];

        for (int i = 0; i < cntStudent; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                students[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] isSameClass = new boolean[cntStudent][cntStudent];
        for (int i = 0; i < cntStudent; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < cntStudent; k++) {
                    if (students[i][j] == students[k][j]) {
                        if (i == k) continue;
                        isSameClass[i][k] = true;
                    }
                }
            }
        }

        int[][] maxVotes = new int[cntStudent][2];
        for (int i = 0; i < cntStudent; i++) {
            maxVotes[i][0] = i;

            for (int j = 0; j < cntStudent; j++) {
                if (isSameClass[i][j]) maxVotes[i][1]++;
            }
        }

        Arrays.sort(maxVotes, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               return o1[0]!=o2[0] ? o2[1]-o1[1] : o1[0]-o2[0];
           }
        });

        System.out.println(maxVotes[0][0] + 1);
    }
}
