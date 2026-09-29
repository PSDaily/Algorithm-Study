package programmers.algorithm.dfsbfs;

import java.util.*;

class Q67259 {
    static int[] dRow = {-1,0,1,0};
    static int[] dCol = {0,-1,0,1};
    static Queue<int[]> q;
    static int N;
    static int[][] board;
    static int min;
    static int[][][] dist;
    public int solution(int[][] Board) {
        int answer = 0;

        N = Board.length;
        board = Board;

        dist = new int[N][N][4];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                Arrays.fill(dist[i][j],Integer.MAX_VALUE);
            }
        }
        dist[0][0][2] = 0;
        dist[0][0][3] = 0;

        q = new LinkedList<>();
        q.offer(new int[]{0,0,0,2});
        q.offer(new int[]{0,0,0,3});

        min = Integer.MAX_VALUE;

        bfs();

        return min;
    }

    static void bfs(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            int cost = cur[2];
            int dis = cur[3];

            if(row == N-1 && col == N-1){
                min = Math.min(min,cost);
                continue;
            }

            for(int i=0;i<4;i++){
                int nextRow = row+dRow[i];
                int nextCol = col+dCol[i];
                int nextCost;
                if(dis%2 == i%2){
                    nextCost = cost+100;
                }
                else{
                    nextCost = cost+600;
                }

                if(nextRow>=0 && nextRow<N && nextCol>=0 && nextCol<N
                        && board[nextRow][nextCol]==0){
                    if(nextCost < dist[nextRow][nextCol][i]){
                        dist[nextRow][nextCol][i] = nextCost;
                        q.offer(new int[]{nextRow,nextCol,nextCost,i});
                    }
                }
            }
        }
    }
}