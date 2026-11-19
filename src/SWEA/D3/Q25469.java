package SWEA.D3;

import java.io.*;
import java.util.*;

public class Q25469 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t=0;t<tc;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] graph = new char[H][W];
            for(int r=0;r<H;r++) {
                graph[r]=br.readLine().toCharArray();
            }

            int count = 0;
            for(int r=0;r<H;r++) {
                boolean all = true;
                for(int c=0;c<W;c++) {
                    if(graph[r][c] == '.') {
                        all = false;
                        break;
                    }
                }
                if(all) {
                    count++;
                }
            }
            if(count == H) {
                System.out.println(Math.min(H, W));
                continue;
            }

            for(int c=0;c<W;c++) {
                boolean all = true;
                for(int r=0;r<H;r++) {
                    if(graph[r][c] == '.') {
                        all = false;
                        break;
                    }
                }
                if(all) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
