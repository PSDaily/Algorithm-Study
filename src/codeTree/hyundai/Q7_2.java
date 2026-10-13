package codeTree.hyundai;

import java.util.Scanner;

public class Q7_2 {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static boolean[][] visited;
    static int N,M;
    static int[][] Grid;
    static int[][] Targets;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[][] targets = new int[m][2];
        for (int i = 0; i < m; i++) {
            targets[i][0] = sc.nextInt();
            targets[i][1] = sc.nextInt();
        }

        N = n;
        M = m;
        visited = new boolean[n][n];
        Grid = grid;
        Targets = targets;

        visited[targets[0][0]-1][targets[0][1]-1] = true;
        dfs(targets[0][0]-1,targets[0][1]-1,0);

        System.out.println(count);
    }

    static void dfs(int r, int c, int index){

        if(r == Targets[index][0]-1 && c == Targets[index][1]-1){
            index++;
        }

        if(index == M){
            count++;
            return;
        }

        for(int i=0;i<4;i++){
            int nextRow = r+dRow[i];
            int nextCol = c+dCol[i];

            if(nextRow>=0 && nextRow<N
                    && nextCol>=0 && nextCol<N
                    && Grid[nextRow][nextCol]==0
                    && !visited[nextRow][nextCol]){
                visited[nextRow][nextCol] = true;
                dfs(nextRow,nextCol,index);
                visited[nextRow][nextCol] = false;
            }
        }
    }
}