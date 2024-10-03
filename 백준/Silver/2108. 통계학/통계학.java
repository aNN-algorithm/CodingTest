import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int avg = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            avg += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        List<Integer> freList = new ArrayList<>();
        int maxFre = list.get(0).getValue();
        for(Map.Entry<Integer, Integer> entry : list) {
            if (entry.getValue() == maxFre) {
                freList.add(entry.getKey());
            } else {
                break;
            }
        }
        Collections.sort(freList);

        Arrays.sort(arr);
        System.out.println(Math.round((float) avg / n));
        System.out.println(arr[n / 2]);
        System.out.println(freList.size() > 1 ? freList.get(1) : freList.get(0));
        System.out.println(arr[n - 1] - arr[0]);
    }
}
