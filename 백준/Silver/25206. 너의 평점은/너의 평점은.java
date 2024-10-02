import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int SUBJECT_CNT = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Double totalCredit = 0.0; // 학점의 총합
        Double totalScore = 0.0; // (학점 X 과목평점)의 합
        for (int i = 0; i < SUBJECT_CNT; i++) {
            String[] input = br.readLine().split(" ");
            Double credit = Double.parseDouble(input[1]);
            String grade = input[2];
            if (!grade.equals("P")) totalCredit += credit;

            switch(grade) {
                case "A+" :
                    totalScore += credit * 4.5;
                    break;
                case "A0" :
                    totalScore += credit * 4.0;
                    break;
                case "B+" :
                    totalScore += credit * 3.5;
                    break;
                case "B0" :
                    totalScore += credit * 3.0;
                    break;
                case "C+" :
                    totalScore += credit * 2.5;
                    break;
                case "C0" :
                    totalScore += credit * 2.0;
                    break;
                case "D+" :
                    totalScore += credit * 1.5;
                    break;
                case "D0" :
                    totalScore += credit * 1.0;
                    break;
                default :
                    totalScore += credit * 0.0;
                    break;
            }
        }
        System.out.println(String.format("%.6f", totalScore / totalCredit));
    }
}