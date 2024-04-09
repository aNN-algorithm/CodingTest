import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int parents[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        StringTokenizer st = new StringTokenizer(comm);

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] list = new int[E][3];

        for (int i = 0; i < E; i++) {
            comm = br.readLine();
            st = new StringTokenizer(comm);
            for (int j = 0; j < 3; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(list, (x, y) -> x[2] - y[2]);

        parents = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            parents[i] = i;
        }

        int weightSum = 0;
        for (int i = 0; i < E; i++) {
            if (find(list[i][0]) != find(list[i][1])) {
                union(list[i][0], list[i][1]);
                weightSum += list[i][2];
            }
        }

        System.out.println(weightSum);
    }

    public static void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);

        if (aP != bP) {
            parents[aP] = b;
        }
    }

    public static int find(int a) {
        if (a == parents[a]) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }
}