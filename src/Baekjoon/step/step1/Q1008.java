package Baekjoon.step.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Double A = Double.parseDouble(st.nextToken());
        Double B = Double.parseDouble(st.nextToken());

        System.out.println(A/B);
    }
}
