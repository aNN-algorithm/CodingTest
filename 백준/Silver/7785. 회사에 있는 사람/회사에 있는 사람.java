import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, String> coll = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            coll.put(str[0], str[1]);  // 마지막 상태만 저장
        }

        List<String> people = new ArrayList<>();
        for (Map.Entry<String, String> entry : coll.entrySet()) {
            if (entry.getValue().equals("enter")) {
                people.add(entry.getKey());
            }
        }

        people.sort(Comparator.reverseOrder());

        for (String person : people) {
            System.out.println(person);
        }
    }
}
