package SWEA.D4;

import java.io.*;
import java.util.*;

public class Q27006 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t=0;t<tc;t++) {
            int N = Integer.parseInt(br.readLine());

            char[][] graph = new char[N][N];
            for(int r=0;r<N;r++) {
                graph[r] = br.readLine().toCharArray();
            }

            int count = 0;

            for(int d=0;d<N;d++) {
                boolean isSym = true;

                outer:
                for(int i=0;i<N-1;i++) {
                    for(int j=i+1;j<N;j++) {

                        int c1 = (j+d)%N;
                        int c2 = (i+d)%N;
                        if(graph[i][c1]!=graph[j][c2]) {
                            isSym = false;
                            break outer;
                        }
                    }
                }

                if(isSym) {
                    count += N;
                }

            }

            System.out.println(count);
        }

    }

}
