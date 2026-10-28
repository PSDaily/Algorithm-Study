package codeTree.samsung;

import java.io.*;
import java.util.*;

public class Q2025_h_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] cus = new long[n];
        for(int i=0;i<n;i++){
            cus[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long ldr = Long.parseLong(st.nextToken());
        long mbr = Long.parseLong(st.nextToken());

        long count = 0;
        for(int i=0;i<n;i++){
            count += 1;
            if(cus[i]>ldr){
                count += (cus[i]-ldr)%mbr==0 ? (cus[i]-ldr)/mbr : (cus[i]-ldr)/mbr+1;
            }
        }

        System.out.println(count);
    }
}