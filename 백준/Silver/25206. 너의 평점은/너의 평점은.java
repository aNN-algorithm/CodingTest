import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double result = 0;
        double sum = 0;
        for (int i = 0; i < 20; i++) {
            String[] grade = br.readLine().split(" ");
            double score = Double.parseDouble(grade[1]);
            String gd = grade[2];
            if (!gd.equals("P")) {
                sum += score;

                if (gd.equals("A+")) {
                    score *= 4.5;
                } else if (gd.equals("A0")) {
                    score *= 4.0;
                } else if (gd.equals("B+")) {
                    score *= 3.5;
                } else if (gd.equals("B0")) {
                    score *= 3.0;
                } else if (gd.equals("C+")) {
                    score *= 2.5;
                } else if (gd.equals("C0")) {
                    score *= 2.0;
                } else if (gd.equals("D+")) {
                    score *= 1.5;
                } else if (gd.equals("D0")) {
                    score *= 1.0;
                } else if (gd.equals("F")) {
                    score *= 0;
                }
                result += score;
            }
        }

        System.out.printf("%.6f", result / sum);
    }
}