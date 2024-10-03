import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] switches;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cntSwitches = Integer.parseInt(br.readLine());
        switches = new int[cntSwitches + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < cntSwitches + 1; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int cntStudents = Integer.parseInt(br.readLine());
        for (int i = 0; i < cntStudents; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int numSwitch = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = numSwitch; j < cntSwitches + 1; j += numSwitch) {
                    switching(j);
                }
            } else {
                int index = 0;
                for (int j = 1; j <= cntSwitches / 2; j++) {
                    if ((numSwitch - j) > 0 && (numSwitch + j) <= cntSwitches) {
                        if (switches[numSwitch - j] != switches[numSwitch + j]) {
                            break;
                        } else {
                            index++;
                        }
                    }
                }

                for (int j = numSwitch - index; j <= numSwitch + index; j++) {
                    switching(j);
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int k = 1; k < cntSwitches + 1; k++) {
            answer.append(switches[k]).append(" ");
            if (k % 20 == 0) answer.append("\n");
        }
        System.out.println(answer);
    }

    private static void switching(int index) {
        if (switches[index] == 1) switches[index] = 0;
        else switches[index] = 1;
    }
}
