import java.io.*;
import java.util.*;

/**
 *
 -----------------------------------------------------------------------------
 * 6 : 서로 다른 부분 문자열의 개수(11478)
 * https://www.acmicpc.net/problem/11478
 * 입력받은 문자열의 부분 문자열 구하기
 * 1. 개수에 따라서,
 * 2. 시작 위치 설정
 * 3. 1의 개수만큼 문자를 더해 부분 문자열 완성
 * 시작 위치를 인덱스 범위가 넘지 않게 하면 조정(입력된 문자열 S의 길이를 넘지 않게)
 -----------------------------------------------------------------------------
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        char[] arr = S.toCharArray();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < arr.length; j++) {
                sb.append(arr[j]);
                set.add(sb.toString());
            }
        }
        System.out.println(set.size());
    }
}