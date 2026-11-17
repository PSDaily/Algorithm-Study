package codeTree.samsung;

import java.util.*;
import java.io.*;

public class Q2021_s_a_1 {
    static int[] dRow = {0,-1,-1,-1,0,1,1,1};
    static int[] dCol = {1,1,0,-1,-1,-1,0,1};
    static int n;
    static int[][] graph;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 특수영양제
        boolean[][] visited = new boolean[n][n];
        visited[n-2][0] = true;
        visited[n-2][1] = true;
        visited[n-1][0] = true;
        visited[n-1][1] = true;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int p = Integer.parseInt(st.nextToken());

            boolean[][] visited2 = new boolean[n][n];

            for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                    if(visited[r][c]){
                        visited[r][c] = false;

                        // 1. 특수 영양제를 이동 규칙에 따라 이동
                        int nextRow = ((r + dRow[d]*p)%n+n)%n;
                        int nextCol = ((c + dCol[d]*p)%n+n)%n;

                        // 2. 특수 영양제를 이동 시킨 후 해당 땅에 특수 영양제를 투입
                        visited2[nextRow][nextCol] = true;
                        graph[nextRow][nextCol] += 1;
                    }
                }
            }

            for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                    if(visited2[r][c]){
                        // 3. 대각선으로 인접한 방향에 높이가 1 이상인 리브로수가 있는 만큼 성장
                        graph[r][c] += count(r,c);
                    }
                }
            }

            // 4. 해당 년도에 특수 영양제를 투입한 리브로수를 제외하고 높이가 2 이상인 리브로수
            for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                    if(graph[r][c]>=2 && !visited2[r][c]){
                        graph[r][c] -= 2;
                        visited[r][c] = true;
                    }
                }
            }
        }

        int sum = 0;
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                sum += graph[r][c];
            }
        }

        System.out.println(sum);
    }

    static int count(int r, int c){
        int num = 0;
        // 1,3,5,7 -> 2배+1
        for(int i=0;i<4;i++){
            int nR = r + dRow[i*2+1];
            int nC = c + dCol[i*2+1];

            if(nR>=0 && nR<n && nC>=0 && nC<n
                    && graph[nR][nC]>=1){
                num++;
            }
        }
        return num;
    }
}