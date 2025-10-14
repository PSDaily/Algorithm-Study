package Baekjoon.codingdodo.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1743 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        while(K-- > 0){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[r-1][c-1] = 1;
        }

        /*
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
         */

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 1){
                    int a = bfsQueue(j, i);
                    max = Math.max(max, a);
                    // System.out.println();
                }
            }
        }

        System.out.println(max);

    }
    static int bfsQueue(int x,int y){
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        arr[y][x] = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            // System.out.print((cur[1]+1)+","+(cur[0]+1)+" ");

            int nx,ny;
            for(int i=0;i<4;i++){
                nx = cur[0] + dx[i];
                ny = cur[1] + dy[i];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N
                        && arr[ny][nx] == 1){
                    arr[ny][nx] = 0;
                    queue.add(new int[]{nx,ny});
                    count++;
                }
            }
        }

        return count;
    }
}
