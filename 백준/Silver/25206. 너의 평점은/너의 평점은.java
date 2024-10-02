import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int SUBJECT_CNT = 20;
    final static int GRADE_CNT = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] grade = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        Double[] socre = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};

        Double totalCredit = 0.0; // 학점의 총합
        Double totalScore = 0.0; // (학점 X 과목평점)의 합
        for (int i = 0; i < SUBJECT_CNT; i++) {
            String[] input = br.readLine().split(" ");
            Double credit = Double.parseDouble(input[1]);
            String result = input[2];

            for (int j = 0; j < GRADE_CNT; j++) {
                if (grade[j].equals(result)) {
                    totalScore += credit * socre[j];
                    totalCredit += credit;
                }
            }

        }
        System.out.println(String.format("%.6f", totalScore / totalCredit));
    }
}