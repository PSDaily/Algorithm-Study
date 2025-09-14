package Baekjoon.step.step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10798 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][15];
        for(int i=0;i<5;i++){
            String s = br.readLine();
            for(int j=0;j<15;j++){
                arr[i][j] = (j<s.length()) ? s.charAt(j) : 0;
            }
        }

        for(int i=0;i<15;i++){
            for(int j=0;j<5;j++){
                if(arr[j][i] != 0){
                    System.out.print(arr[j][i]);
                }
            }
        }
    }
}
