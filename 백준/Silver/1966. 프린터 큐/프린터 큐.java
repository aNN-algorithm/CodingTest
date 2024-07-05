import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static class Doc {
        int index;
        int imp;

        public Doc(int index, int imp) {
            this.index = index;
            this.imp = imp;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            String[] comm = br.readLine().split(" ");
            int N = Integer.parseInt(comm[0]);
            int k = Integer.parseInt(comm[1]);

            String docArray = br.readLine();
            StringTokenizer st = new StringTokenizer(docArray);
            ArrayList<Doc> docs = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                docs.add(new Doc(j, Integer.parseInt(st.nextToken())));
            }

            int printed = 0;
            while (!docs.isEmpty()) {
                Doc d = docs.get(0);
                boolean isChanged = false;

                for (int j = 1; j < docs.size(); j++) {
                    if (d.imp < docs.get(j).imp) {
                        docs.add(d);
                        docs.remove(docs.get(0));
                        isChanged = true;
                        break;
                    }
                }

                if (!isChanged) {
                    printed++;
                    if (docs.get(0).index == k) {
                        break;
                    }
                    docs.remove(docs.get(0));
                }
            }

            System.out.println(printed);
        }
    }
}
