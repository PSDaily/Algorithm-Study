package codeTree.hyundai;

import java.util.*;

public class Q9_2 {
    static int n,t;
    static int[][] grid;
    static int[][] mx;
    static int[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        grid = new int[n][n];
        mx = new int[n][n];
        dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mx[i][j] = -1000000000;
                dp[i][j][0] = dp[i][j][1] = -1000000000;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                calculateMaxProfit(i,j,i,j,0,grid[i][j]);
            }
        }

        dp[0][0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = Math.max(dp[i][j][1],dp[i][j][0]+mx[i][j]);

                // 아래로 한 칸 이동
                if(i+1<n){
                    dp[i+1][j][0] = Math.max(dp[i+1][j][0],dp[i][j][0]+grid[i+1][j]);
                    dp[i+1][j][1] = Math.max(dp[i+1][j][1],dp[i][j][1]+grid[i+1][j]);
                }

                // 오른쪽으로 한 칸 이동
                if(j+1<n){
                    dp[i][j+1][0] = Math.max(dp[i][j+1][0],dp[i][j][0]+grid[i][j+1]);
                    dp[i][j+1][1] = Math.max(dp[i][j+1][1],dp[i][j][1]+grid[i][j+1]);
                }
            }
        }

        System.out.println(Math.max(dp[n-1][n-1][0],dp[n-1][n-1][1]));
    }

    // i,j -> t초 동안 최대 이득 계산
    static void calculateMaxProfit(int i, int j, int y, int x, int passedTime, int profit){
        if(passedTime == t){
            mx[i][j] = Math.max(mx[i][j],profit);
            return;
        }

        // 아래로 한 칸 이동
        if(y+1 < n){
            calculateMaxProfit(i,j,y+1,x,passedTime+1,profit+grid[y+1][x]);
        }

        // 오른쪽으로 한 칸 이동
        if(x+1 < n){
            calculateMaxProfit(i,j,y,x+1,passedTime+1,profit+grid[y][x+1]);
        }
    }
}