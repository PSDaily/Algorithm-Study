package Baekjoon.codingdodo.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7562 {
    static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy = {2,1,-1,-2,-2,-1,1,2};
    static int I;
    static boolean[][] visited;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            I = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            visited = new boolean[I][I];
            distance = new int[I][I];

            System.out.println(bfsQueue(startX,startY,endX,endY));
        }
    }

    static int bfsQueue(int startX,int startY,int endX,int endY){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY});
        visited[startY][startX] = true;
        distance[startY][startX] = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            // System.out.print(cur[0]+","+cur[1]+"  ");

            if(cur[0] == endX && cur[1] == endY){
                return distance[cur[1]][cur[0]];
            }

            int nx,ny;
            for(int i = 0; i < dx.length; i++){
                nx = cur[0] + dx[i];
                ny = cur[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < I && ny < I &&
                        (!visited[ny][nx])){
                    queue.add(new int[]{nx, ny});
                    visited[ny][nx] = true;
                    distance[ny][nx] = distance[cur[1]][cur[0]]+1;
                }
            }
        }
        return -1;
    }
}
