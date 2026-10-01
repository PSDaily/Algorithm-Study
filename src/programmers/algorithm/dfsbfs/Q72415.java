package programmers.algorithm.dfsbfs;

import java.util.*;

class Q72415 {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static Queue<int[]> q;
    static int[][] board;
    static boolean[][] visited = new boolean[4][4];
    public int solution(int[][] Board, int r, int c) {
        int answer = 0;

        board = Board;

        return dfs(r,c);
    }

    static int dfs(int row, int col) {

        int min = Integer.MAX_VALUE;
        boolean cardExists = false;

        for (int n = 1; n <= 6; n++) {

            int[][] card = new int[2][2];
            int count = 0;

            // n번 카드 위치 찾기
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {

                    if (board[i][j] == n) {
                        card[count][0] = i;
                        card[count][1] = j;
                        count++;
                    }
                }
            }

            // 이미 제거된 카드
            if (count == 0) {
                continue;
            }

            cardExists = true;

            int ar = card[0][0];
            int ac = card[0][1];

            int br = card[1][0];
            int bc = card[1][1];


            // A → B 이동 비용
            int cost1 =
                    bfs(row, col, ar, ac)
                            + bfs(ar, ac, br, bc)
                            + 2;


            // B → A 이동 비용
            int cost2 =
                    bfs(row, col, br, bc)
                            + bfs(br, bc, ar, ac)
                            + 2;


            // 카드 제거
            board[ar][ac] = 0;
            board[br][bc] = 0;


            // 나머지 카드 제거
            cost1 += dfs(br, bc);
            cost2 += dfs(ar, ac);


            // 원상복구
            board[ar][ac] = n;
            board[br][bc] = n;

            min = Math.min(min, Math.min(cost1, cost2));
        }

        // 카드가 하나도 안 남았다면
        if (!cardExists) {
            return 0;
        }

        return min;
    }

    static int bfs(int startRow, int startCol, int targetRow, int targetCol){
        q = new LinkedList<>();
        visited = new boolean[4][4];

        q.offer(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            int dis = cur[2];

            if (row == targetRow && col == targetCol) {
                return dis;
            }

            for(int i=0;i<4;i++){
                // 1칸
                int nextRow = row+dRow[i];
                int nextCol = col+dCol[i];

                if(nextRow>=0 && nextRow<4
                        && nextCol>=0 && nextCol<4
                        && !visited[nextRow][nextCol]){
                    visited[nextRow][nextCol] = true;
                    q.offer(new int[]{nextRow,nextCol,dis+1});
                }

                // ctrl
                nextRow = row;
                nextCol = col;

                while (nextRow + dRow[i] >= 0 && nextRow + dRow[i] < 4
                        && nextCol + dCol[i] >= 0 && nextCol + dCol[i] < 4) {

                    nextRow += dRow[i];
                    nextCol += dCol[i];

                    // 카드를 만나면 멈춤
                    if (board[nextRow][nextCol] != 0) {
                        break;
                    }
                }

                if (!visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    q.offer(new int[]{nextRow,nextCol,dis+1});
                }
            }
        }
        return -1;
    }
}