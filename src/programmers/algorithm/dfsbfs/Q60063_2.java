package programmers.algorithm.dfsbfs;

import java.util.*;

class Q60063_2 {
    static int n;
    static int[][] time;
    static int[] dRow = {0,-1,0,1};
    static int[] dCol = {1,0,-1,0};
    static int[] cRow = {-1,-1,1,1};
    static int[] cCol = {1,-1,-1,1};

    static int[][] Board;
    static Queue<int[]> q;

    static boolean[][][] visited;
    public int solution(int[][] board) {

        n = board.length;
        time = new int[n][n];
        Board = board;
        q = new LinkedList<>();
        q.offer(new int[]{0,0,0,0});
        visited = new boolean[n][n][4];
        visited[0][0][0] = true;

        return bfs();
    }

    static int bfs(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            int dir = cur[2];
            int time = cur[3];

            if((row==n-1 && col==n-1) || (row+dRow[dir]==n-1 && col+dCol[dir]==n-1)){
                //System.out.println("dir="+dir);
                //System.out.println("("+row+","+col+")"+" ("+(row+dRow[dir])+","+(col+dCol[dir])+")");
                return time;
            }

            // 이동
            for(int i=0;i<4;i++){
                int nextRow= row+dRow[i];
                int nextCol = col+dCol[i];

                if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<n
                        && nextRow+dRow[dir]>=0 && nextRow+dRow[dir]<n
                        && nextCol+dCol[dir]>=0 && nextCol+dCol[dir]<n
                        && Board[nextRow][nextCol]==0 && Board[nextRow+dRow[dir]][nextCol+dCol[dir]]==0){

                    if(!visited[nextRow][nextCol][dir]){
                        visited[nextRow][nextCol][dir] = true;
                        q.offer(new int[]{nextRow,nextCol,dir,time+1});
                    }
                }
            }

            // 회전
            for (int axis = 0; axis < 2; axis++) {
                int r = row;
                int c = col;
                int d = dir;

                // 반대쪽 칸을 회전축으로 설정
                if (axis == 1) {
                    r += dRow[dir];
                    c += dCol[dir];
                    d = (dir + 2) % 4;
                }

                // 시계 / 반시계 90도 회전
                for (int rotate : new int[]{1, 3}) {
                    int nextDir = (d + rotate) % 4;

                    // 회전 후 로봇의 위치
                    int nextRow = r + dRow[nextDir];
                    int nextCol = c + dCol[nextDir];

                    // 회전 중 지나가는 대각선 칸
                    int checkRow = r + dRow[d] + dRow[nextDir];
                    int checkCol = c + dCol[d] + dCol[nextDir];

                    if (nextRow >= 0 && nextRow < n &&
                            nextCol >= 0 && nextCol < n &&
                            checkRow >= 0 && checkRow < n &&
                            checkCol >= 0 && checkCol < n &&
                            Board[nextRow][nextCol] == 0 &&
                            Board[checkRow][checkCol] == 0) {

                        if (!visited[r][c][nextDir]) {
                            visited[r][c][nextDir] = true;
                            q.offer(new int[]{r, c, nextDir, time + 1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}