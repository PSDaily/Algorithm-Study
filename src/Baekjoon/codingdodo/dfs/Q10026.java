package Baekjoon.codingdodo.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10026 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        char[][] arr = new char[N][N];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            arr[i] = s.toCharArray();
        }

        // normal
        boolean[][] visited = new boolean[N][N];
        int total = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    dfsRecursive(i,j,visited,arr,false);
                    total++;
                }
            }
        }

        // blind
        boolean[][] visitedblindness = new boolean[N][N];
        int totalblindess = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visitedblindness[i][j]){
                    dfsRecursive(i,j,visitedblindness,arr,true);
                    totalblindess++;
                }
            }
        }

        System.out.print(total + " " + totalblindess);
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static void dfsRecursive(int x, int y, boolean[][] visited, char[][] arr, boolean isBlind){
        visited[x][y] = true; // 현재 노드 방문 처리
        // System.out.println("x:"+x+" y:"+y + " "); // 방문 출력

        int nextX;
        int nextY;
        for(int i=0;i<4;i++){
            nextX = x + dx[i];
            nextY = y + dy[i];
            if((nextX>=0 && nextX<N && nextY>=0 && nextY<N)
                    &&(!visited[nextX][nextY])
                    &&(isSameColor(arr[x][y],arr[nextX][nextY],isBlind))){
                dfsRecursive(nextX,nextY,visited,arr,isBlind);
            }
        }
    }

    /*
    static void dfsblindness(int x, int y, boolean[][] visited, char[][] arr){
        visited[x][y] = true; // 현재 노드 방문 처리
        // System.out.println("x:"+x+" y:"+y + " "); // 방문 출력

        int nextX;
        int nextY;
        for(int i=0;i<4;i++){
            nextX = x + dx[i];
            nextY = y + dy[i];

            if((nextX>=0 && nextX<N && nextY>=0 && nextY<N)&&(!visited[nextX][nextY])){
                if(arr[x][y] == 'R' ||arr[x][y] == 'G') {
                    if(arr[nextX][nextY] == 'R' || arr[nextX][nextY] == 'G') {
                        dfsblindness(nextX, nextY, visited, arr);
                    }
                }
                else{
                    if(arr[x][y] == arr[nextX][nextY]){
                        dfsblindness(nextX,nextY,visited,arr);
                    }
                }
            }
        }
    }
     */

    static boolean isSameColor(char color1, char color2, boolean isBlind){
        if(isBlind){
            if((color1 == 'R' || color1 == 'G') && (color2 == 'R' || color2 == 'G')) {
                return true;
            }
        }
        return color1 == color2;
    }
}
