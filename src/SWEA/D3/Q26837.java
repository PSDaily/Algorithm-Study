package SWEA.D3;

import java.io.*;
import java.util.*;

public class Q26837 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int t=0;t<tc;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            int count = 0;
            for(int i=0;i<n;i++) {
                int A=0, T=0, C=0, G=0;
                for(int j=i;j<n;j++) {
                    // T 안에서 반전 관계 가능한지
                    // a 개수 = t 개수 && c 개수 = g 개수
                    char c = s.charAt(j);

                    if(c == 'A') {
                        A++;
                    }
                    else if(c=='T') {
                        T++;
                    }
                    else if(c=='C') {
                        C++;
                    }
                    else {
                        G++;
                    }
                    if(A==T && C==G) {
                        count++;
                    }
                }
            }

            System.out.println(count);

        }
    }
}
