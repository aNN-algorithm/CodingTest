import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Character[] cards = new Character[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                cards[j] = st.nextToken().charAt(0);
            }

            Deque<Character> makingCards = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                if (makingCards.isEmpty()) makingCards.addLast(cards[j]);
                else {
                    if (makingCards.getFirst() < cards[j]) makingCards.addLast(cards[j]);
                    else makingCards.addFirst(cards[j]);
                }
            }

            while (!makingCards.isEmpty()) answer.append(makingCards.pollFirst());
            answer.append("\n");
        }
        System.out.println(answer);
    }
}