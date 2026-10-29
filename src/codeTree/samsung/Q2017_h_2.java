package codeTree.samsung;

import java.io.*;
import java.util.*;

public class Q2017_h_2 {
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] visited = new int[3];
    static int[] number,operand;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        number = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        operand = new int[3];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++){
            operand[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1,number[0]);
        System.out.println(min+" "+max);

    }

    static void dfs(int now, int sum){
        if(now == n){
            max = Math.max(max,sum);
            min = Math.min(min,sum);
            return;
        }

        for(int i=0;i<3;i++){
            if(operand[i] > visited[i]){
                visited[i]++;
                int nextSum;
                if(i==0){
                    nextSum = sum+number[now];
                }
                else if(i==1){
                    nextSum = sum-number[now];
                }
                else{
                    nextSum = sum*number[now];
                }
                dfs(now+1,nextSum);
                visited[i]--;
            }
        }
    }
}