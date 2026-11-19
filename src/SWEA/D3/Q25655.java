package SWEA.D3;

import java.io.*;
import java.util.*;

public class Q25655 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int t=0;t<tc;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());

            String answer = "";
            // X=1 -> 0
            if(X==1) {
                answer = "0";
            }

            // X가 짝수 -> 8*(X/2)
            else if(X%2==0) {
                int num = X/2;
                while(num-- > 0) {
                    answer += "8";
                }
            }

            // X가 홀수
            // X=3 -> 48
            // X=5 이상 -> 488
            else {
                answer += "4";
                int num = X/2;
                while(num-- > 0) {
                    answer += "8";
                }
            }

            System.out.println(answer);
        }

    }

}
