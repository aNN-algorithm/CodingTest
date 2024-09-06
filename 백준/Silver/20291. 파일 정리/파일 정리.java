import java.io.*;
import java.util.*;

/**
 *
 -----------------------------------------------------------------------------
 * 5 : 파일정리(20291)
 * https://www.acmicpc.net/problem/20291
 * 입력을 받아 확장자를 Key값, 확장자의 개수를 Value값으로 가지는 HashMap에 저장
 * HashMap의 Key값을 오름차순으로 정렬하여, 출력
 *
 * 정렬 ref)
 * https://codechacha.com/ko/java-sort-map/
 -----------------------------------------------------------------------------
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 입력 받은, 파일을 Map에 저장
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split("\\.");
            map.put(command[1], map.getOrDefault(command[1], 0) + 1);
        }

        // 오름차순 출력
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}