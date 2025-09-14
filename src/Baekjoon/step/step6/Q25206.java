package Baekjoon.step.step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q25206 {
    public static void main(String[] args) throws IOException {
        Map<String, Double> gradeMap = new HashMap<String, Double>();
        gradeMap.put("A+", 4.5);
        gradeMap.put("A0", 4.0);
        gradeMap.put("B+", 3.5);
        gradeMap.put("B0", 3.0);
        gradeMap.put("C+", 2.5);
        gradeMap.put("C0", 2.0);
        gradeMap.put("D+", 1.5);
        gradeMap.put("D0", 1.0);
        gradeMap.put("F", 0.0);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Double totalcredit = 0.0;
        Double sum = 0.0;
        for(int i=0;i<20;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            Double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            // System.out.println("subject: " + subject + " grade: " + grade + " credit: " + credit);
            // System.out.println("grade\'s credit: " + gradeMap.get(grade));
            if(grade.equals("P")){
                continue;
            }
            totalcredit += credit;
            // System.out.println("total credit: " + totalcredit);

            sum += credit * gradeMap.get(grade);
            // System.out.println("sum: " + sum);
        }

        Double Gpa = sum / totalcredit;

        System.out.printf("%.6f\n", Gpa);

    }
}
