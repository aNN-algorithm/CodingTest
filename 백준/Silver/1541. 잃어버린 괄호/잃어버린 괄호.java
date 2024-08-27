import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] comm = br.readLine().split("-");

        int answer = 0;
        for (int i = 0; i < comm.length; i++) {
            String[] separated = comm[i].split("\\+");
            int num = 0;
            for (int j = 0; j < separated.length; j++) {
                num += Integer.parseInt(separated[j]);
            }
            if (i == 0) {
                answer += num;
            } else {
                answer -= num;
            }
        }
        System.out.println(answer);
    }
}