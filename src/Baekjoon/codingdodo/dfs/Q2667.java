package Baekjoon.codingdodo.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2667 {
    static int N;
    static int count; // 각 단지내 집의 수 - ⭐전역변수로 놓기⭐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        List<Integer> countArr = new ArrayList<Integer>();

        char[][] arr = new char[N][N];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            arr[i]= s.toCharArray();
        }

        boolean[][] visited = new boolean[N][N];

        int total = 0; // 총 단지수
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && arr[i][j]=='1'){
                    count = 0;
                    dfsRecursive(i,j,visited,arr);
                    countArr.add(count);
                    // System.out.println("count: "+count);
                    total++;
                }
            }
        }

        System.out.println(total);

        Collections.sort(countArr);
        for(int i=0;i<total-1;i++){
            System.out.println(countArr.get(i));
        }
        System.out.print(countArr.get(total-1));
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static void dfsRecursive(int x,int y, boolean[][] visited, char[][] arr){
        visited[x][y] = true; // 현재 노드 방문 처리
        count++;
        // System.out.println("x:"+x+" y:"+y + " "); // 방문 출력

        int nextX;
        int nextY;
        for(int i=0;i<4;i++){
            nextX = x + dx[i];
            nextY = y + dy[i];
            if((nextX>=0 && nextX<N && nextY>=0 && nextY<N)&&(!visited[nextX][nextY]) && (arr[nextX][nextY] == '1')){
                dfsRecursive(nextX,nextY,visited,arr);
            }
        }
    }
}
