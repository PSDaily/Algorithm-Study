package SWEA.D3;

import java.io.*;
import java.util.*;

public class Q25695 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int t=0;t<tc;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Z = Integer.parseInt(st.nextToken());

            int A=-1,B=-1,C=-1;
            // 3개가 같을 경우
            if(X==Y && Y==Z && X==Z) {
                A=X;
                B=X;
                C=X;
            }

            // 2개가 같을 경우
            // 작은거 1개, 큰거 2개
            else {
                int min = Integer.MAX_VALUE;
                char alpha = 'a';
                if(X<min) {
                    min = X;
                    alpha = 'C';
                }
                if(Y<=min) {
                    min = Y;
                    alpha = 'A';
                }
                if(Z<=min) {
                    min = Z;
                    alpha = 'B';
                }

                System.out.println("min="+min);
                int count=0;
                if(min==X) {
                    count++;
                }
                if(min==Y) {
                    count++;
                }
                if(min==Z) {
                    count++;
                }
                System.out.println("count="+count);
                if(count==1) {
                    if(alpha=='C' && Y==Z) {
                        A=min;
                        B=min;
                        C=Y;
                    }
                    else if(alpha=='A' && X==Z) {
                        A=X;
                        B=min;
                        C=min;
                    }
                    else if(alpha=='B' && X==Y) {
                        A=min;
                        B=X;
                        C=min;
                    }
                }
            }

            System.out.println(A+" "+B+" "+C);
        }
    }
}
