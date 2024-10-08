import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static int BINGO_SIZE = 5;
    static int[][] board;
    static int[][] bingo;
    static int cntBingo = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[BINGO_SIZE][BINGO_SIZE];

        for (int i = 0; i < BINGO_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < BINGO_SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bingo = new int[2][BINGO_SIZE + 1];
        int answer = 0;
        for (int l = 0; l < BINGO_SIZE; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < BINGO_SIZE; k++) {
                int x = Integer.parseInt(st.nextToken());
                answer++;

                for (int i = 0; i < BINGO_SIZE; i++) {
                    for (int j = 0; j < BINGO_SIZE; j++) {
                        if (board[i][j] != x) continue;

                        checkBingo(0, i);
                        checkBingo(1, j);

                        if (i == j) checkBingo(0, 5);
                        if (i + j == BINGO_SIZE - 1) checkBingo(1, 5);

                        if (cntBingo >= 3) {
                            System.out.println(answer);
                            return;
                        }
                    }
                }
            }
        }
    }

    private static void checkBingo(int x, int y) {
        bingo[x][y]++;
        if (bingo[x][y] == BINGO_SIZE) cntBingo++;
    }
}