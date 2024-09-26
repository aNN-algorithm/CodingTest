import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 5. 센티와 마법의 뿅망치
// https://www.acmicpc.net/problem/19638

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int numOfGiants = Integer.parseInt(input[0]);
        int heightOfCenti = Integer.parseInt(input[1]);
        int timesOfHammer = Integer.parseInt(input[2]);

        PriorityQueue<Integer> heightOfGiants = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < numOfGiants; i++) {
            heightOfGiants.add(Integer.parseInt(br.readLine()));
        }

        int cntOfHit = 0;
        while (timesOfHammer > 0 && !heightOfGiants.isEmpty()) {
            if (heightOfGiants.peek() < heightOfCenti || heightOfGiants.peek() == 1) break;

            int heightOfGiant = heightOfGiants.poll();
            cntOfHit++;
            heightOfGiant /= 2;
            timesOfHammer--;
            heightOfGiants.add(heightOfGiant);
        }

        StringBuilder answer = new StringBuilder();
        answer.append(heightOfGiants.peek() < heightOfCenti ? "YES" : "NO").append("\n");
        answer.append(heightOfGiants.peek() < heightOfCenti ? cntOfHit : heightOfGiants.peek()).append("\n");
        System.out.println(answer);
    }
}
