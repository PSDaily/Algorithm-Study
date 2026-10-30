package codeTree.samsung;

import java.util.*;
import java.io.*;

public class Q2021_s_1 {
    static int n;
    static int[][] graph;
    // 위, 왼, 오, 아래
    static int[] dRow = {-1,0,0,1};
    static int[] dCol = {0,-1,1,0};
    static int[][] friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n*n][5];
        friends = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(friends[i],-1);
        }
        for(int i=0;i<n*n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken())-1;
            for(int j=0;j<4;j++){
                graph[number][j] = Integer.parseInt(st.nextToken())-1;
            }

            // 4방향 인접한 칸 중 좋아하는 친구가 가장 많은 위치
            int student = number;
            int max = Integer.MIN_VALUE;
            int maxEmpty = Integer.MIN_VALUE;
            int maxR = 0;
            int maxC = 0;
            for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                    if(friends[r][c]!=-1){
                        continue;
                    }

                    int count = 0;
                    int empty = 0;
                    for(int d=3;d>=0;d--){
                        int nextR = r+dRow[d];
                        int nextC = c+dCol[d];

                        if(nextR>=0 && nextR<n && nextC>=0 && nextC<n){
                            if(friends[nextR][nextC] == -1){
                                empty++;
                                continue;
                            }

                            for(int f=0;f<4;f++){
                                if(friends[nextR][nextC] == graph[number][f]){
                                    count++;
                                }
                            }
                        }
                    }

                    if(max <= count){
                        if(max == count){
                            if(maxEmpty<empty){
                                maxR = r;
                                maxC = c;
                                maxEmpty = empty;
                            }
                        }
                        else{
                            maxR = r;
                            maxC = c;
                            maxEmpty = empty;
                        }
                        max = count;
                    }
                }
            }
            friends[maxR][maxC] = student;
        }

        /*
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                System.out.print(friends[r][c]+" ");
            }
            System.out.println();
        }
        */

        int grade = 0;
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                int number = friends[r][c];
                // 4방향으로 좋아하는 친구 수 합
                int count = 0;
                for(int d=3;d>=0;d--){
                    int nextR = r+dRow[d];
                    int nextC = c+dCol[d];

                    if(nextR>=0 && nextR<n && nextC>=0 && nextC<n){
                        for(int f=0;f<4;f++){
                            if(friends[nextR][nextC] == graph[number][f]){
                                count++;
                            }
                        }
                    }
                }

                if(count > 0){
                    grade += Math.pow(10,(count-1));
                }

            }
        }

        System.out.println(grade);
    }
}