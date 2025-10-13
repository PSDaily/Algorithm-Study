package Baekjoon.codingdodo.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// visited 없이 방문 처리하기
public class Q1012_2 {
    static int N,M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][M];
            while(K-- > 0){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                arr[Y][X] = 1;
            }

            int total = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(arr[i][j] == 1){
                        bfsQueue(j,i,arr);
                        total++;
                    }
                }
            }

            System.out.println(total);
        }

    }

    static void bfsQueue(int x,int y,int[][] arr){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        arr[y][x] = 0;

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            // System.out.print(node[0] + "," + node[1] + " ");

            int nx,ny;
            for(int i=0;i<4;i++){
                nx = node[0] + dx[i];
                ny = node[1] + dy[i];

                if((nx >=0 && nx < M && ny >= 0 && ny <N)
                        && (arr[ny][nx] == 1)){
                    queue.add(new int[]{nx,ny});
                    arr[ny][nx] = 0;
                }
            }
        }
    }
}
