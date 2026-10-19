package codeTree.hyundai;

import java.util.*;

public class Q11_2 {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static int n;
    static int[][][] dp;
    static int[][] grid;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int k = scanner.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                grid[i][j] = scanner.nextInt();
            }
        }

        // dp[i][j][l]: (i,j)에서 시작해 정확히 l칸을 지나는 등산로의 높이 차이 최댓값 중 최솟값
        dp = new int[n][n][k+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                answer = Math.min(answer,dfs(i,j,k));
            }
        }

        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }

        System.out.println(answer);

    }
    static int dfs(int r, int c, int l){
        // 이미 계산한 상태면 반환
        if(dp[r][c][l] != -1){
            return dp[r][c][l];
        }

        // 길이가 1이면 높이 차이 없음
        if(l == 1){
            return dp[r][c][l] = 0;
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<4;i++){
            int nextR = r+dRow[i];
            int nextC = c+dCol[i];

            if(nextR>=0 && nextR<n && nextC>=0 && nextC<n
                    && grid[nextR][nextC] > grid[r][c]
            ){
                int diff = grid[nextR][nextC] - grid[r][c];

                min = Math.min(min,Math.max(dfs(nextR,nextC,l-1),diff));
            }
        }

        dp[r][c][l] = min;
        return dp[r][c][l];
    }
}