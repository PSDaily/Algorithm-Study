package Baekjoon.codingdodo.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){
                arr[b-1] = c;
            }
            else if (a == 2){
                for(int j=b-1;j<c;j++){
                    if(arr[j]==1){
                        arr[j]=0;
                    }
                    else{
                        arr[j]=1;
                    }
                }
            }
            else if (a == 3){
                for(int j=b-1;j<c;j++){
                    arr[j]=0;
                }
            }
            else if (a == 4){
                for(int j=b-1;j<c;j++){
                    arr[j]=1;
                }
            }
        }

        for(int i = 0; i < N; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
