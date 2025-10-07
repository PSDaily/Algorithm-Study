package Baekjoon.codingdodo.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q2583 {
    static int M;
    static int N;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> countArr = new ArrayList<Integer>();

        int[][] arr = new int[M][N];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int x=x1;x<x2;x++){
                for(int y=y1;y<y2;y++){
                    arr[y][x] = 1;
                }
            }
        }

        /*
        for(int i=M-1;i>=0;i--){
            for(int j=0;j<N;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
         */

        boolean[][] visited = new boolean[M][N];

        int total = 0;
        for(int i=M-1;i>=0;i--){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && arr[i][j] == 0){
                    count=0;
                    dfsRecursive(j,i,visited,arr);
                    countArr.add(count);
                    total++;
                }
            }
        }

        System.out.println(total);
        Collections.sort(countArr);
        for(int i=0;i<total-1;i++){
            System.out.print(countArr.get(i) + " ");
        }
        System.out.print(countArr.get(total-1));
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static void dfsRecursive(int x,int y, boolean[][] visited, int[][] arr){
        visited[y][x] = true; // 현재 노드 방문 처리
        count++;
        // System.out.println("x:"+x+" y:"+y + " ");
        for(int i=0;i<4;i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if((nextX>=0 && nextX<N && nextY>=0 && nextY<M)
                    &&(!visited[nextY][nextX])
                    && (arr[nextY][nextX] == 0)){
                dfsRecursive(nextX,nextY,visited,arr);
            }
        }
    }
}
