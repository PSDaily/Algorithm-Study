// 1~6학년
// 남/녀
// 같은 학년(1명도 가능)
// 방의 최소 개수
// K: 한방 최대 인원수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13300 {
    static int N, K;
    static int[][] darr;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens2 = new StringTokenizer(br.readLine(), " ");

        N = Integer.valueOf(tokens2.nextToken());
        K = Integer.valueOf(tokens2.nextToken());
        darr = new int[7][2];

        for(int i=0;i<N;i++)
        {
            StringTokenizer tokens = new StringTokenizer(br.readLine()," ");

            int s=Integer.valueOf(tokens.nextToken());
            int g = Integer.valueOf(tokens.nextToken());

            darr[g][s]++;
        }

        //when

        int result=0;

        for(int i=1;i<=6;i++)
        {
            int man = darr[i][0];
            int woman = darr[i][1];

            // man
            int p1 = man/K;
            int q1 = man%K;

            result += p1;
            if(q1 != 0) result++;


            //woman
            int p2 = woman/K;
            int q2 = woman%K;

            result += p2;
            if(q2 != 0) result++;
        }

        System.out.print(result);
    }
}