package SWEA.D3;

import java.io.*;
import java.util.*;

public class Q26502 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int t=0;t<tc;t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for(int n=0;n<N;n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[n][0] = x;
                arr[n][1] = y;
            }


            long max = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    for(int k=0;k<N;k++) {
                        if(i==j || j==k || i==k) continue;

                        if(arr[i][0]==arr[j][0] && arr[i][1]==arr[k][1]) {

                            long X = Math.abs((long)arr[i][0]-arr[k][0]);
                            long Y = Math.abs((long)arr[i][1]-arr[j][1]);

                            max = Math.max(max, X*Y);
                        }
                    }
                }
            }

            System.out.println(max);
        }
    }

}
