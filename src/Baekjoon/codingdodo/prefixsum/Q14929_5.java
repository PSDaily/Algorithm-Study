package Baekjoon.codingdodo.prefixsum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// O(N)
public class Q14929_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(tokens[i]);
        }

        long sum = 0;
        long prefix = 0;
        for(int i=0 ; i<n ; i++){
            sum += (long) num[i] * prefix;
            prefix += num[i];
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
