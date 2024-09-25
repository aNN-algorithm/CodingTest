import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] commands1 = br.readLine().split(" ");
            int n = Integer.parseInt(commands1[0]);
            int cursor = Integer.parseInt(commands1[1]);

            Queue<Integer> printQueue = new LinkedList<>();
            map = new HashMap<>();
            String commands2 = br.readLine();
            StringTokenizer st = new StringTokenizer(commands2);
            for (int j = 0; j < n; j++) {
                Integer important = Integer.parseInt(st.nextToken());
                printQueue.add(important);
                map.put(important, map.getOrDefault(important, 0) + 1);
            }

            int cnt = 0;
            while (!printQueue.isEmpty()) {
                Integer current = printQueue.peek(); // 현재 문서
                if (cursor == 0) {
                    // 나머지 문서들 중 현재 문서보다 중요한 문서가 있는지 확인
                    if (isBiggerThanCurrentImportant(current)) {
                        // 맨 앞 문서는 뒤로 이동
                        printQueue.add(printQueue.poll());
                        cursor = printQueue.size() - 1;
                    } else {
                        // 문서를 출력
                        printQueue.remove();

                        // 출력이 발생하므로
                        cnt++;

                        // 반복문 과정 종료
                        break;
                    }
                } else {
                    // 나머지 문서들 중 현재 문서보다 중요한 문서가 있는지 확인
                    if (isBiggerThanCurrentImportant(current)) {
                        // 맨 앞 문서는 뒤로 이동
                        printQueue.add(printQueue.poll());
                    } else {
                        // 문서를 출력
                        printQueue.remove();

                        // 출력이 발생하므로
                        cnt++;
                    }

                    // 맨 앞 문서가 출력이든, 뒤로 가든
                    cursor--;
                }
            }
            answer.append(cnt).append("\n");
        }
        System.out.println(answer);
    }

    private static boolean isBiggerThanCurrentImportant(Integer current) {
        for (int i = current + 1; i < 10; i++) {
            if (map.containsKey(i)) {
                return true;
            }
        }
        if (map.containsKey(current)) {
            if (map.get(current) == 1) map.remove(current);
            else map.put(current, map.get(current) - 1);
        }
        return false;
    }
}