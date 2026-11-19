package SWEA.D4;

import java.io.*;
import java.util.*;

public class Q3752 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t=0;t<tc;t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int total = 0;
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                total += arr[i];
            }

            boolean[] dp = new boolean[total+1];
            dp[0] = true;

            int sum = 0;
            for(int i=0;i<N;i++) {
                for(int j=sum;j>=0;j--) {
                    if(dp[j]) {
                        dp[j+arr[i]] = true;
                    }
                }
                sum += arr[i];
            }

            int count = 0;
            for(boolean possible : dp) {
                if(possible) {
                    count++;
                }
            }

            System.out.println("#"+(t+1)+" "+count);
        }

    }


}
