import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 8. 패션왕 신해빈
// https://www.acmicpc.net/problem/9375

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int cntOfClothes = Integer.parseInt(br.readLine());
            Map<String, Integer> closet = new HashMap<>();
            for (int j = 0; j < cntOfClothes; j++) {
                String[] input = br.readLine().split(" ");
                String kindOfClothes = input[1];
                closet.put(kindOfClothes, closet.getOrDefault(kindOfClothes,0) + 1);
            }

            int answer = 1;
            for (Map.Entry<String, Integer> entry : closet.entrySet()) {
                answer *= (entry.getValue() + 1);
            }

            answer--;
            System.out.println(answer);
        }
    }
}