package codeTree.samsung;

import java.io.*;
import java.util.*;

public class Q2017_s_2 {
    static int max = Integer.MIN_VALUE;
    static int n;
    static int[][] work;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        work = new int[n][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            work[i][0] = Integer.parseInt(st.nextToken());
            work[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        System.out.println(max);
    }

    static void dfs(int now, int sum){
        if(now >= n){
            max = Math.max(max,sum);
            return;
        }

        // 포함
        if(now+work[now][0] <= n){
            dfs(now+work[now][0],sum+work[now][1]);
        }

        // 포함 x
        dfs(now+1,sum);

    }
}