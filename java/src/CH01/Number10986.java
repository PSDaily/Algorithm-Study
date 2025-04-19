package CH01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number10986 {
    public static void main(String[] args) throws IOException{

        //N과 M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] modCount = new long[M];
        long sum = 0;
        long answer = 0; //정답 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            sum += Integer.parseInt(st.nextToken());
            int mod = (int)(sum % M);
            //나머지가 0이면 그 자체로 정답
            if (mod == 0) answer++;
            //나머지 개수에 따라 증가시키기
            modCount[mod]++;
        }

        //같은 나머지를 가지고 있는 것들 중 2개를 뽑는 경우
        for (int i = 0; i < M; i++){
            if (modCount[i] > 1){
                //nC2 = n(n-1)/2
                answer += (modCount[i] * (modCount[i] - 1)) / 2;
            }
        }
        System.out.println(answer);



    }
}
