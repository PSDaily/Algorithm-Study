import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static long[] height;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.valueOf(br.readLine());
        height = new long[N];
        dp = new int[N];

        for(int i=0; i<N;i++)
        {
            long num = Long.valueOf(br.readLine());

            height[i]=num;
        }

        //when
        dp[N-1]=0;

        for(int i=N-2;i>=0;i--)
        {
            if(height[i] <= height[i+1]) dp[i]=0;
            else
            {
                dp[i] += dp[i+1]+1;
                int delta =dp[i+1] + 2;
                while(true)
                {
                    int next = i + delta;
                    if(next >= N || height[i] <= height[next]) break;

                    if(height[i] > height[next]) dp[i] += dp[next]+1;
                    delta += dp[next] + 1;
                }

            }
        }

        long sum=0;
        for(int i=0;i<N;i++)
        {
            sum+=(long)dp[i];
        }

        System.out.print(sum);
    }
}
