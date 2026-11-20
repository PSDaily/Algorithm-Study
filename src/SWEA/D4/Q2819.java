package SWEA.D4;

import java.util.*;
import java.io.*;

public class Q2819 {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static String[][] graph;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t=0;t<tc;t++) {
            graph = new String[4][4];
            for(int r=0;r<4;r++) {
                graph[r] = br.readLine().split(" ");
            }

            set = new HashSet<>();
            for(int r=0;r<4;r++) {
                for(int c=0;c<4;c++) {
                    dfs(r,c,graph[r][c]);
                }
            }

            System.out.println("#"+(t+1)+" "+set.size());
        }


    }

    static void dfs(int r, int c, String s) {
        if(s.length()==7) {
            set.add(s);
            return;
        }

        for(int i=0;i<4;i++) {
            int nextR = r+dRow[i];
            int nextC = c+dCol[i];

            if(nextR>=0 && nextR<4 && nextC>=0 && nextC<4) {
                dfs(nextR, nextC, s+graph[nextR][nextC]);
            }
        }
    }
}
