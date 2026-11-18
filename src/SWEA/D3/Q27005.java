package SWEA.D3;

import java.io.*;

public class Q27005 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        int[] A = new int[1001];
        A[0] = 1;
        A[1] = 1;
        for(int i=2;i<1001;i++) {
            int num = 1;

            while(true) {
                boolean isValid = true;

                for(int k=1;k<=i/2;k++) {
                    if((num-A[i-k])==(A[i-k]-A[i-2*k])) {
                        isValid = false;
                        break;
                    }
                }

                if(isValid) {
                    A[i] = num;
                    break;
                }

                num++;
            }

        }

        for(int t=0;t<tc;t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(A[n]);
        }
    }
}
