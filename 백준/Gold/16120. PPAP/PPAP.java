import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ppap = "PPAP";

        int strSize = str.length();
        int ppapSize = ppap.length();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < strSize; i++) {
            stack.push(str.charAt(i));
            boolean isPpap = true;

            if (stack.size() >= ppapSize) {
                for (int j = 0; j < ppapSize; j++) {
                    if (stack.get(stack.size() - ppapSize + j) != ppap.charAt(j)) {
                        isPpap = false;
                        break;
                    }
                }
                if (isPpap) {
                    for (int j = 0; j < ppapSize; j++) {
                        stack.pop();
                    }
                    stack.push('P');
                }
            }
        }

        if (stack.size() == 1 && stack.get(0) == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
