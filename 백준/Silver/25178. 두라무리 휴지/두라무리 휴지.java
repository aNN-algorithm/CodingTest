import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] originStr = br.readLine().toCharArray();
        char[] mixedStr = br.readLine().toCharArray();

        boolean isDuramari = true;
        if (originStr[0] != mixedStr[0]
                || originStr[n - 1] != mixedStr[n - 1]) isDuramari = false;

        List<Character> originStrList = new ArrayList<>();
        Map<Character, Integer> originVowelsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (originStr[i] == 'a' || originStr[i] == 'e' || originStr[i] == 'i'
                    || originStr[i] == 'o' || originStr[i] == 'u') {
                originVowelsMap.put(originStr[i], originVowelsMap.getOrDefault(originStr[i], 0) + 1);
            } else originStrList.add(originStr[i]);
        }

        List<Character> mixedStrList = new ArrayList<>();
        Queue<Character> mixedVowelsList = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if (mixedStr[i] == 'a' || mixedStr[i] == 'e' || mixedStr[i] == 'i'
                    || mixedStr[i] == 'o' || mixedStr[i] == 'u') {
                mixedVowelsList.add(mixedStr[i]);
            }
            else mixedStrList.add(mixedStr[i]);
        }

        if (!originStrList.equals(mixedStrList)) isDuramari = false;
        else {
            while (!mixedVowelsList.isEmpty()) {
                Character cur = mixedVowelsList.poll();
                if (!originVowelsMap.containsKey(cur) || originVowelsMap.get(cur) == 0) {
                    isDuramari = false;
                    break;
                }

                originVowelsMap.put(cur, originVowelsMap.get(cur) - 1);
            }
        }

        System.out.println(isDuramari ? "YES" : "NO");
    }
}