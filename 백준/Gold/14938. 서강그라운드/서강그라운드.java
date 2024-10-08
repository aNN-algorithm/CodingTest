import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static int MAX_LOAD = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cntArea = Integer.parseInt(st.nextToken());
        int searchScope = Integer.parseInt(st.nextToken());
        int cntRoad = Integer.parseInt(st.nextToken());

        int[] items = new int[cntArea + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < cntArea + 1; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] field = new int[cntArea + 1][cntArea + 1];
        for (int i = 1; i < cntArea + 1; i++) {
            for (int j = 1; j < cntArea + 1; j++) {
                if (i == j) continue;
                field[i][j] = MAX_LOAD;
            }
        }
        for (int i = 0; i < cntRoad; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());
            field[u][v] = road;
            field[v][u] = road;
        }

        for (int k = 1; k < cntArea + 1; k++) {
            for (int i = 1; i < cntArea + 1; i++) {
                for (int j = 1; j < cntArea + 1; j++) {
                    if (field[i][j] > field[i][k] + field[k][j]) {
                        field[i][j] = field[i][k] + field[k][j];
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < cntArea + 1; i++) {
            int maxItems = 0;
            for (int j = 1; j < cntArea + 1; j++) {
                if (field[i][j] > searchScope) continue;
                maxItems += items[j];
            }
            answer = Math.max(maxItems, answer);
        }
        System.out.println(answer);
    }
}