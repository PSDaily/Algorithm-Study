package SWEA.D3;

import java.io.*;
import java.util.*;

public class Q26009 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        long MOD = 998244353L;
        for(int t=0;t<tc;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            long A = (a % 2 == 0)
                    ? ((a / 2) % MOD) * ((a + 1) % MOD) % MOD
                    : (a % MOD) * ((a / 2 + 1) % MOD) % MOD;

            long B = (b % 2 == 0)
                    ? ((b / 2) % MOD) * ((b + 1) % MOD) % MOD
                    : (b % MOD) * ((b / 2 + 1) % MOD) % MOD;

            long C = (c % 2 == 0)
                    ? ((c / 2) % MOD) * ((c + 1) % MOD) % MOD
                    : (c % MOD) * ((c / 2 + 1) % MOD) % MOD;

            long sum = ((A * B) % MOD * C) % MOD;

            System.out.println(sum);

        }

    }

}

/*
1 12 123
111 112 113 121 122 123
1 2 3 2 4 6

12 12 12
111 112 121 122 211 212 221 222
(1+2)*(1+2)*(1+2)
1 2 2 4 2 4 4 8
27
*/

