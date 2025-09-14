package Baekjoon.codingdodo.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10];
        boolean[] appear = new boolean[10];

        int count = 0;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            if(appear[num-1]){
                if(arr[num-1] != position){
                    // System.out.println("num: " + num + ", past position: " + arr[num-1] + ", now position: " + position);
                    arr[num-1] = position;
                    count++;
                }
            }
            else{
                appear[num-1] = true;
                arr[num-1] = position;
                continue;
            }
        }

        /*
        for(int i = 0; i < 10; i++){
            System.out.println(appear[i]);
        }
         */
        System.out.println(count);

    }
}
