package programmers.algorithm.dp;

class Q258750 {
    public int solution(int n, int[] tops) {
        int answer = 0;

        int[][] dp = new int[n+1][2];

        if(tops[0] == 0){
            dp[1][0] = 2;
            dp[1][1] = 1;
        }
        else{
            dp[1][0] = 3;
            dp[1][1] = 1;
        }

        for(int i=2;i<n+1;i++){
            if(tops[i-1] == 0){
                dp[i][0] = (dp[i-1][0]*2+dp[i-1][1])%10007;
                dp[i][1] = (dp[i-1][0]+dp[i-1][1])%10007;
            }
            else{
                dp[i][0] = (dp[i-1][0]*3+dp[i-1][1]*2)%10007;
                dp[i][1] = (dp[i-1][0]+dp[i-1][1])%10007;
            }
        }
        return (dp[n][0]+dp[n][1])%10007;
    }
}