import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] difficulty = new int[5][5];
        int[][] time = new int[5][5];

        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            for (int j = 0; j < 5; j++) {
                difficulty[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            for (int j = 0; j < 5; j++) {
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] expectedAmount = new int[5][5];
        int[] finalAmount = new int[5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    expectedAmount[i][j] += difficulty[i][k] * time[k][j];
                }
                finalAmount[i] += expectedAmount[i][j];
            }
        }
        int min = 4;
        for (int i = 3; i >= 0; i--) {
            if (finalAmount[min] > finalAmount[i]) {
                min = i;
            }
        }
        switch(min) {
            case 0:
                System.out.println("Inseo");
                break;
            case 1:
                System.out.println("Junsuk");
                break;
            case 2:
                System.out.println("Jungwoo");
                break;
            case 3:
                System.out.println("Jinwoo");
                break;
            case 4:
                System.out.println("Youngki");
                break;
        }
    }
}