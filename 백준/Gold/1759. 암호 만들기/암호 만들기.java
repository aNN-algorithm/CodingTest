import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int C;
    static List<Character> charList;
    static char[] password;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comm = br.readLine();
        StringTokenizer st = new StringTokenizer(comm);
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        charList = new ArrayList<>();
        isUsed = new boolean[C];
        comm = br.readLine();
        st = new StringTokenizer(comm);
        for (int i = 0; i < C; i++) {
            charList.add(st.nextToken().charAt(0));
        }
        Collections.sort(charList);
        password = new char[L];

        func(0, 0);
    }

    private static void func(int start, int cur) {
        if (cur == L) {
            boolean isAEIOU = false;
            int isNotAEIOU = 0;
            for (int i = 0; i < L; i++) {
                if (password[i] == 'a' || password[i] == 'e' || password[i] == 'i'
                || password[i] == 'o' || password[i] == 'u') {
                    isAEIOU = true;
                } else {
                    isNotAEIOU++;
                }
            }
            if (isAEIOU && isNotAEIOU >= 2) {
                for (int i = 0; i < L; i++) {
                    System.out.print(password[i]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if (isUsed[i]) {
                continue;
            }
            password[cur] = charList.get(i);
            isUsed[i] = true;
            func(i, cur + 1);
            isUsed[i] = false;
        }
    }
}