import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String comm = br.readLine();

            if (comm.equals("ENTER")) {
                answer += set.size();
                set = new HashSet<>();
                continue;
            }

            set.add(comm);
        }

        answer += set.size();
        System.out.println(answer);
    }
}