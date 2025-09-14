package Baekjoon.step.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        int i = Integer.parseInt(br.readLine());
        System.out.print(S.charAt(i-1));
    }
}
