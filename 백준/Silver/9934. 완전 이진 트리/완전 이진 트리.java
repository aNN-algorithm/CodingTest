import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] answer;
    static int[] input;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        int size = (int) Math.pow(2, k) - 1;

        input = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        answer = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            answer[i] = new ArrayList<>();
        }

        int start = 0;
        int end = size - 1;
        recursive(start, end,  0);

        for (ArrayList<Integer> list : answer) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void recursive(int start, int end, int depth) {
        if (depth == k) {
            return;
        }

        int mid = (start + end) / 2;
        answer[depth].add(input[mid]);

        recursive(start, mid - 1, depth + 1);
        recursive(mid + 1, end, depth + 1);
    }
}
