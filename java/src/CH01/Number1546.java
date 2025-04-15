package CH01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.IOException;

public class Number1546 {
    public static void main(String[] args) throws IOException{
        //과목의 개수 N개 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] scores = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        //각 과목의 성적 입력받기 -> 1차원 배열로 저장
        for (int i = 0; i < N; i++){
            scores[i] = Double.parseDouble(st.nextToken());
        }

        //최고점, 총합 저장하기 -> 배열 탐색
        double max = scores[0];
        for (int i = 1; i < N; i++){
            if(scores[i] > max){
                max = scores[i];
            }
        }

        //새로운 점수의 평균값 구하기
        double sum = 0;
        for (int i = 0; i < N; i++){
            sum += (scores[i] * max) / 100;
        }

        System.out.println(sum /N);
    }
}
