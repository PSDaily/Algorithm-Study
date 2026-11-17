package codeTree.samsung;

import java.util.*;
import java.io.*;

public class Q2017_h_1 {
    static char[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new char[4][8];
        for(int i=0;i<4;i++){
            String s = br.readLine();
            for(int j=0;j<8;j++){
                graph[i][j] = s.charAt(j);
            }
        }

        int k = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken());

            turn(n,d);
        }

        // 0 -> graph[0][2] - graph[1][6]
        // 1 -> graph[0][2] - graph[1][6], graph[1][2] - graph[2][6]
        // 2 -> graph[1][2] - graph[2][6], graph[2][2] - graph[3][6]
        // 3 -> graph[2][2] - graph[3][6]

        // 시계방향 회전 = graph[i][j]->graph[i][j+1]
        // 반시계방향 회전 = graph[i][j]->graph[i][j-1]

        // 12시 방향 = graph[i][0]
        int answer = 0;
        for(int i=0;i<4;i++){
            answer += Math.pow(2,i) * (graph[i][0]-'0');
        }

        System.out.println(answer);
    }

    static void turn(int n, int d){
        int[] direction = new int[4];
        direction[n] = d;

        // 왼쪽 전파
        for(int i=n-1; i>=0; i--){
            if(graph[i][2] != graph[i+1][6]){
                direction[i] = -direction[i+1];
            }
            else{
                break;
            }
        }

        // 오른쪽 전파
        for(int i=n+1; i<4; i++){
            if(graph[i][6] != graph[i-1][2]){
                direction[i] = -direction[i-1];
            }
            else{
                break;
            }
        }

        for(int i=0;i<4;i++){
            if(direction[i] != 0){
                rotate(i,direction[i]);
            }
        }

    }

    static void rotate(int n, int d){
        // 회전
        if(d == 1){
            char temp = graph[n][7];
            for(int j=7;j>0;j--){
                graph[n][j] = graph[n][j-1];
            }
            graph[n][0] = temp;
        }

        else if(d == -1){
            char temp = graph[n][0];
            graph[n][0] = graph[n][1];
            for(int j=0;j<7;j++){
                graph[n][j] = graph[n][j+1];
            }
            graph[n][7] = temp;
        }
    }
}