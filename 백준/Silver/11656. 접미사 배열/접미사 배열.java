import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        PriorityQueue<StringBuilder> pq = new PriorityQueue<>();
        for (int i = 0; i < input.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < input.length(); j++) {
                sb.append(input.charAt(j));
            }
            pq.add(sb);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().toString());
        }
    }
}