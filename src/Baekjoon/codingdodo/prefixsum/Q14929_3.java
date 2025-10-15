package Baekjoon.codingdodo.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배열 없이
public class Q14929_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 1; i <= n-1; i++){
            for(int j = i+1; j <= n; j++){
                sum += num[i-1]*num[j-1];
            }
        }

        System.out.println(sum);
    }
}
