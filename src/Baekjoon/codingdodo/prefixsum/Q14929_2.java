package Baekjoon.codingdodo.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2D in_place
public class Q14929_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[][] arr = new int[n+1][n+1];
        for(int i = 1; i <= n-1; i++){
            for(int j = i+1; j <= n; j++){
                arr[i][j] = num[i-1]*num[j-1];
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
            }
        }

        /*
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print(prefix[i][j] + " ");
            }
            System.out.println();
        }
         */

        System.out.println(arr[n][n]);
    }
}
