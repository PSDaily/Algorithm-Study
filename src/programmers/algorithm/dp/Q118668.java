package programmers.algorithm.dp;

import java.util.*;

class Q118668 {
    static int nowAlp,nowCop;
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;

        // 알고력, 코딩력 최대 구하기
        int alMax = Integer.MIN_VALUE;
        int coMax = Integer.MIN_VALUE;
        for(int i=0;i<problems.length;i++){
            alMax = Math.max(alMax,problems[i][0]);
            coMax = Math.max(coMax,problems[i][1]);
        }

        // dp: 해당 알고력, 코딩력에 도달하기까지 최소 시간
        int[][] dp = new int[alMax+1][coMax+1];
        for(int i=0;i<=alMax;i++){
            Arrays.fill(dp[i],10000);
        }

        alp = Math.min(alp,alMax);
        cop = Math.min(cop,coMax);
        dp[alp][cop] = 0;

        for(int i=alp;i<=alMax;i++){
            for(int j=cop;j<=coMax;j++){
                // 알고력 공부
                if(i<alMax){
                    dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]+1);
                }

                // 코딩력 공부
                if(j<coMax){
                    dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]+1);
                }

                // 문제 풀기
                for(int p=0;p<problems.length;p++){
                    int[] problem = problems[p];
                    int alp_req = problem[0];
                    int cop_req = problem[1];
                    int alp_rwd = problem[2];
                    int cop_rwd = problem[3];
                    int cost = problem[4];

                    if(i>=alp_req && j>=cop_req){
                        int nextAlp = Math.min(alMax,i+alp_rwd);
                        int nextCop = Math.min(coMax,j+cop_rwd);

                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop],dp[i][j]+cost);
                    }
                }
            }
        }

        return dp[alMax][coMax];
    }

}