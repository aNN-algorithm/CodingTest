import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String search = br.readLine();

        int answer = 0;
        for (int i = 0; i < doc.length(); i++) {
            if (doc.charAt(i) == search.charAt(0)) {
                boolean isFind = true;
                if (i + search.length() > doc.length()) {
                    break;
                }
                for (int j = 0; j < search.length(); j++) {
                    if (doc.charAt(i + j) != search.charAt(j)) {
                        isFind = false;
                        break;
                    }
                }
                if (isFind) {
                    answer++;
                    i += search.length() - 1;
                }
            }
        }
        System.out.println(answer);
    }
}
