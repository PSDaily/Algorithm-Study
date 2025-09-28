package Baekjoon.codingdodo.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr[] = new int[9];
        int total = 0;
        for(int i=0;i<9;i++){
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        Arrays.sort(arr); // 오름차순 정렬

        int sum = 0;
        for(int i=0;i<9;i++){
            for(int j=i+1;j<9;j++){
                sum = arr[i] + arr[j];

                if(total - sum == 100){
                    StringBuilder sb = new StringBuilder();

                    for(int k=0;k<9;k++){
                        if(k != i && k != j){
                            sb.append(arr[k]).append("\n");
                        }
                    }
                    // 마지막 개행 제거
                    if(sb.length()>0){
                        sb.setLength(sb.length()-1);
                    }

                    System.out.print(sb.toString());
                    return;
                }
            }
        }
    }
}
