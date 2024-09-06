import java.io.*;
import java.util.*;

/**
 *
 -----------------------------------------------------------------------------
 * 8 : 베스트셀러(1302)
 * https://www.acmicpc.net/problem/1302
 * 1. Map 에 책을 사전순으로 제목과 판매 개수 저장
 *  - 가장 많이 팔린 책의 개수를 저장 -> max
 * 2. Map 을 순서대로 확인하여 max 와 같은 량으로 팔린 책 제목 출력
 -----------------------------------------------------------------------------
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 사전순으로 정렬하여 Map에 저장 - TreeMap 사용
        Map<String, Integer> map = new TreeMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book,0) + 1);

            // 제일 많이 팔린 책의 개수 저장
            if (max < map.get(book)) {
                max = map.get(book);
            }
        }

        // 사전순으로 책 판매량을 보며, max값과 비교
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // 가장 많이 팔린 책의 개수와 같은 개수로 팔린 책이 있다면 출력 후 반복문 종료
            if (entry.getValue() == max) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}