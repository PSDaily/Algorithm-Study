package codeTree.hyundai;

import java.util.*;

public class Q10_2 {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static boolean[][] visited;
    static int N,M;
    static int[][] board;
    static List<int[][]> grades;
    static Set<String> set;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        grades = new ArrayList<>();
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];
                visited[i][j] = true;
                int[][] cell = new int[6][2];
                cell[0] = new int[]{i,j};
                dfs(i,j,0,board[i][j],cell);
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<grades.size();i++){
            for(int j=i;j<grades.size();j++){
                int count = 0;

                int[][] cells1 = grades.get(i);
                int[][] cells2 = grades.get(j);

                for(int a=0;a<cells1.length-1;a++){
                    for(int b=0;b<cells2.length-1;b++){
                        int[] cell1 = cells1[a];
                        int[] cell2 = cells2[b];
                        if(cell1[0]==cell2[0] && cell1[1]==cell2[1]){
                            count++;
                        }
                    }
                }

                if(count == 2){
                    max = Math.max(max,cells1[5][0]+cells2[5][0]);
                }
            }
        }

        System.out.println(max);
    }


    // 5개가 이어진 것 2개 -> '2개만' 겹치도록

    // 2개 선택 -> 나머지 3개가 이어진 것 2개
    // 24개 * dfs 2번 -> 최대 2개

    static void dfs(int r,int c, int d, int sum, int[][] cells){
        if(d == 4){
            int[][] copy = new int[6][2];
            for(int i=0;i<5;i++){
                copy[i] = cells[i].clone();
            }

            Arrays.sort(copy,0,5,(a,b)->{
                if(a[0]!=b[0]){
                    return a[0]-b[0];
                }
                else{
                    return a[1]-b[1];
                }
            });

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<5;i++){
                sb.append(copy[i][0]).append(",").append(copy[i][1]).append(";");
            }
            if(set.add(sb.toString())){
                copy[5] = new int[]{sum,0};
                grades.add(copy);
            }

            return;
        }

        for(int k=0;k<=d;k++){
            int cr = cells[k][0];
            int cc = cells[k][1];

            for(int i=0;i<4;i++){
                int nextR = cr+dRow[i];
                int nextC = cc+dCol[i];

                if(nextR>=0 && nextR<N && nextC>=0 && nextC<M
                        && !visited[nextR][nextC]){
                    visited[nextR][nextC] = true;
                    cells[d+1] = new int[]{nextR,nextC};
                    dfs(nextR,nextC,d+1,sum+board[nextR][nextC],cells);
                    visited[nextR][nextC] = false;
                }
            }

        }

    }
}