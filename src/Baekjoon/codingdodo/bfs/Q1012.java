package Baekjoon.codingdodo.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1012 {
    static int M;
    static int N;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][M];

            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[Y][X] = 1;
            }

            /*
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    System.out.print(arr[j][k] + " ");
                }
                System.out.println();
            }
             */

            visited = new boolean[N][M];

            int total = 0;
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(!visited[j][k] && arr[j][k] == 1){
                        bfsQueue(k,j,arr);
                        // System.out.println();
                        total++;
                    }
                }
            }

            System.out.println(total);
        }
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static void bfsQueue(int x,int y,int[][] arr){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y}); // 시작 노드를 큐에 삽입
        visited[y][x] = true; // 방문 처리

        while(!queue.isEmpty()){ // 큐가 빌 때까지 반복
            int[] node = queue.poll(); // 큐에서 맨 앞 노드 꺼내기
            // System.out.print(node[0] +","+node[1]+ "    "); // 방문 출력

            int nextX;
            int nextY;
            for(int i=0;i<4;i++){
                nextX = node[0] + dx[i];
                nextY = node[1] + dy[i];
                if((nextX>=0 && nextX<M && nextY>=0 && nextY<N)
                        &&(!visited[nextY][nextX])
                        && (arr[nextY][nextX] == 1)){
                    visited[nextY][nextX] = true; // 방문 처리
                    queue.add(new int[] {nextX,nextY}); // 큐에 삽입
                }
            }
        }
    }
}
