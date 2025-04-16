package CH01;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number11659 {
    public static void main(String[] args) throws IOException{
        //숫자 개수(inputNum)와 질의 개수(quizNum) 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int inputNum = Integer.parseInt(st.nextToken());
        int quizNum = Integer.parseInt(st.nextToken());

        long[] sumArray = new long[inputNum + 1];
        st = new StringTokenizer(br.readLine()); //두 번째 줄(배열에 들어갈 요소들)

        //합 배열 생성
        for (int i = 1; i <= inputNum; i++){
            sumArray[i] = sumArray[i-1] + Integer.parseInt(st.nextToken());
            //System.out.println(sumArray[i]);
        }

        //질의 개수만큼 반복
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < quizNum; q++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(sumArray[j] - sumArray[i-1]).append("\n");
        }

        System.out.println(sb);

    }
}
