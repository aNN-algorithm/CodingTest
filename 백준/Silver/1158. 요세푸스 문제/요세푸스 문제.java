import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        LinkedList list = new LinkedList();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        LinkedList yo_list = new LinkedList();

        int i = 0;
        while (true) {
            if (yo_list.size() == n) {
                break;
            }
            if ((i + 1) % k != 0) {
                list.add(list.poll());
            } else {
                yo_list.add(list.poll());
            }
            i++;
        }

        System.out.print("<");
        for (i = 0; i < n; i++) {
            System.out.print(yo_list.poll());
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}