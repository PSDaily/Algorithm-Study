package Baekjoon.codingdodo.prefixsum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// split + BufferedWriter
public class Q14929_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(tokens[i]);
        }

        int sum = 0;
        for(int i = 1; i <= n-1; i++){
            for(int j = i+1; j <= n; j++){
                sum += num[i-1]*num[j-1];
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
