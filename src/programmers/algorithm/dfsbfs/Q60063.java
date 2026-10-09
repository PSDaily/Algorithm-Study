package programmers.algorithm.dfsbfs;

import java.util.*;

// 틀린 답안
class Q60063 {
    static int n;
    static int[][] time;
    static int[] dRow1 = {-1,1,0,0,1,0,-1,0};
    static int[] dCol1 = {0,0,-1,1,1,0,1,0};
    static int[] dRow2 = {-1,1,0,0,0,1,0,-1};
    static int[] dCol2 = {0,0,-1,1,0,-1,0,-1};

    // 4,1,2,3
    static int[] checkRow = {1,1,-1,-1};
    static int[] checkCol = {0,1,0,1};

    static int[][] Board;
    static Queue<int[]> q;
    public int solution(int[][] board) {

        n = board.length;
        time = new int[n][n];
        Board = board;
        q = new LinkedList<>();
        q.offer(new int[]{0,0,0,0,1,0});

        return bfs();
    }

    static int bfs(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row1 = cur[0];
            int col1 = cur[1];
            int time1 = cur[2];
            int row2 = cur[3];
            int col2 = cur[4];
            int time2 = cur[5];

            if(row1==n-1 && col1==n-1){
                System.out.println("row1="+row1+" col1="+col1+"row2="+row2+" col2="+col2);
                return time1;
            }
            else if(row2==n-1 && col2==n-1){
                System.out.println("row1="+row1+" col1="+col1+" row2="+row2+" col2="+col2);
                return time2;
            }

            // 이동
            for(int i=0;i<8;i++){
                //System.out.println("i="+i);
                int nextRow1,nextCol1,nextRow2,nextCol2,nextTime1,nextTime2;
                if(i>=4){
                    if((i-4)%2==0){
                        nextRow1= row2+dRow2[i];
                        nextCol1 = col2+dCol2[i];
                        nextRow2 = row1+dRow1[i];
                        nextCol2 = col1+dCol1[i];
                        nextTime1 = time1+1;
                        nextTime2 = time2+1;
                    }
                    else{
                        nextRow1 = row1+dRow1[i];
                        nextCol1 = col1+dCol1[i];
                        nextRow2 = row2+dRow2[i];
                        nextCol2 = col2+dCol2[i];
                        nextTime1 = time1+1;
                        nextTime2 = time2+1;
                    }

                    if(nextRow1>=0 && nextRow1<n && nextCol1>=0 && nextCol1<n
                            && nextRow2>=0 && nextRow2<n && nextCol2>=0 && nextCol2<n
                            && Board[nextRow1][nextCol1]==0 && Board[nextRow2][nextCol2]==0
                            && Board[row1+checkRow[i-4]][col1+checkCol[i-4]]==0){

                        q.offer(new int[]{nextRow1,nextCol1,nextRow2,nextCol2,nextTime1,nextTime2});
                    }
                }
                else{
                    nextRow1 = row1+dRow1[i];
                    nextCol1 = col1+dCol1[i];
                    nextRow2 = row2+dRow2[i];
                    nextCol2 = col2+dCol2[i];
                    nextTime1 = time1+1;
                    nextTime2 = time2+1;

                    if(nextRow1>=0 && nextRow1<n && nextCol1>=0 && nextCol1<n
                            && nextRow2>=0 && nextRow2<n && nextCol2>=0 && nextCol2<n
                            && Board[nextRow1][nextCol1]==0 && Board[nextRow2][nextCol2]==0){

                        q.offer(new int[]{nextRow1,nextCol1,nextRow2,nextCol2,nextTime1,nextTime2});
                    }
                }
            }
        }
        return -1;
    }
}