package Baekjoon.codingdodo.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
    static int[][] distance;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        /*
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
         */

        distance = new int[N][M];

        System.out.println(bfsQueue(0,0,arr));
    }

    static int bfsQueue(int x,int y,int[][] arr){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x,y});
        distance[y][x] = 1;

        int nx,ny;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            // System.out.print(cur[1]+","+cur[0]+"  ");

            if(cur[0] == M-1 && cur[1] == N-1){
                return distance[cur[1]][cur[0]];
            }
            for(int i=0;i<4;i++){
                nx = cur[0]+dx[i];
                ny = cur[1]+dy[i];

                if(nx>=0 && nx<M && ny>=0 && ny<N
                        && arr[ny][nx]==1){
                    arr[ny][nx] = 0;
                    queue.add(new int[]{nx,ny});
                    distance[ny][nx] = distance[cur[1]][cur[0]] + 1;
                }
            }
        }
        return 0;
    }
}
