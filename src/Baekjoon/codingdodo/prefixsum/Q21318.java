package Baekjoon.codingdodo.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        /*
        for(int i=0;i<N;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
         */

        int[] mistake = new int[N];
        int[] prefix = new int[N];
        for (int i = 1; i < N; i++) {
            if (arr[i-1] > arr[i]) { //⭐
                mistake[i] = 1;
            }
            prefix[i] = prefix[i-1] + mistake[i];
        }

        /*
        for(int i=1;i<N;i++){
            System.out.print(mistake[i] + " ");
        }
        System.out.println();

        for(int i=1;i<N;i++){
            System.out.print(prefix[i] + " ");
        }
        System.out.println();
         */

        int Q = Integer.parseInt(br.readLine());
        while(Q-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = prefix[y-1] - prefix[x-1]; //⭐
            System.out.println(sum);
        }
    }
}
