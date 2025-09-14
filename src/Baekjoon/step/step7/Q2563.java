package Baekjoon.step.step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2563 {
    public static void main(String[] args) throws IOException {
        int [][] arr = new int[100][100];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        // System.out.println("n: "+n);

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // System.out.println("a: "+a+" b: "+b);

            for(int j=a-1;j<a+9;j++){
                for(int k=b-1;k<b+9;k++){
                    arr[j][k] = 1;
                }
            }
        }

        int count = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(arr[i][j]==1){
                    count ++;
                }
            }
        }

        System.out.print(count);
    }
}
