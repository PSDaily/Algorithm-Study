package SWEA.D3;

import java.util.*;
import java.io.*;

public class Q26389 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int t=0;t<tc;t++) {
            String A = br.readLine();
            int N=0,W=0,S=0,E=0;
            for(char c: A.toCharArray()) {
                if(c=='N') {
                    N++;
                }
                else if(c=='W') {
                    W++;
                }
                else if(c=='S') {
                    S++;
                }
                else {
                    E++;
                }
            }

            if(N>0 && S==0) {
                System.out.println("No");
            }
            else if(N==0 && S>0) {
                System.out.println("No");
            }
            else if(W>0 && E==0) {
                System.out.println("No");
            }
            else if(W==0 && E>0) {
                System.out.println("No");
            }
            else {
                System.out.println("Yes");
            }
        }
    }
}
