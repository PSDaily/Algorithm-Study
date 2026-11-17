package codeTree.samsung;

import java.util.*;
import java.io.*;

public class Q2017_s_a_1 {
    static boolean[][] visited;
    static int[][] graph;
    static int[] dRow = {-1,0,1,0}; // 북, 동, 남, 서
    static int[] dCol = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        int dis = 0;

        while(true){

            // 1. 현재 칸 방문
            if(!visited[x][y]){
                visited[x][y] = true;
                dis++;
            }

            boolean moved = false;

            // 2. 반시계 방향으로 4방향 탐색
            for(int i=0;i<4;i++){

                d = (d+3)%4; // 왼쪽 회전

                int nextR = x + dRow[d];
                int nextC = y + dCol[d];

                if(nextR>=0 && nextR<n && nextC>=0 && nextC<m
                        && graph[nextR][nextC]==0 && !visited[nextR][nextC]){

                    x = nextR;
                    y = nextC;
                    moved = true;
                    break;
                }
            }

            // 이동했으면 다시 방문 시작
            if (moved) {
                continue;
            }

            // 3. 4방향 모두 방문했으면 후진
            int backR = x - dRow[d];
            int backC = y - dCol[d];
            if(backR>=0 && backR<n && backC>=0 && backC<m
                    && graph[backR][backC]==0){

                x = backR;
                y = backC;
            }
            // 후진할 수 없으면 종료
            else{
                break;
            }

        }

        System.out.println(dis);

    }
}