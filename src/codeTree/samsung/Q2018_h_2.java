package codeTree.samsung;

import java.util.*;
import java.io.*;

public class Q2018_h_2 {
    static int[][] graph;
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static int n, L, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int total = 0;
        while(true){
            boolean[][] visited = new boolean[n][n];
            boolean moved = false;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    // 이동이 필요한 위치 찾기
                    if(!visited[i][j]){
                        // bfs 여러번 -> 한번의 이동
                        if(bfs(i,j,visited)){
                            moved = true;
                        }
                    }
                }
            }

            if(!moved){
                break;
            }

            total++;
        }

        System.out.println(total);
    }

    static boolean bfs(int row, int col, boolean[][] visited){
        int sum = 0;
        int count = 0;
        List<int[]> union = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});
        visited[row][col] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            // next -> 차이가 L 이상 R 이하인 애들 표시, 총합, 개수 구하기
            sum += graph[r][c];
            count++;
            union.add(new int[]{r,c});
            for(int i=0;i<4;i++){
                int nextR = r+dRow[i];
                int nextC = c+dCol[i];

                if(nextR>=0 && nextR<n && nextC>=0 && nextC<n
                        && !visited[nextR][nextC]){

                    int diff = Math.abs(graph[nextR][nextC]-graph[r][c]);

                    if(diff>=L && diff<=R){
                        visited[nextR][nextC] = true;
                        q.offer(new int[]{nextR,nextC});
                    }
                }
            }
        }

        if(count == 1){
            return false;
        }

        int avg = sum/count;

        for(int[] position: union){
            graph[position[0]][position[1]] = avg;
        }

        return true;
    }
}