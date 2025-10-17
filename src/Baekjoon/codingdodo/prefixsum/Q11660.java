package Baekjoon.codingdodo.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        int[][] prefix = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            String[] tokens = br.readLine().split(" ");
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(tokens[j-1]);
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + arr[i][j];
            }
        }

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());
            int endRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());

            int sum = prefix[endRow][endCol] - prefix[startRow-1][endCol] - prefix[endRow][startCol-1] + prefix[startRow-1][startCol-1];
            System.out.println(sum);
        }
    }
}
