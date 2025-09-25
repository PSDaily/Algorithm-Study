package CH01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number11660 {
    public static void main(String[] args) throws IOException{
        //배열 크기(N), 질의 수(M) 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //배열들 선언
        int[][] arr = new int[n+1][n+1]; //얘는 크기 n x n으로 해도 되는데 보기 좋게 sumArr랑 크기 맞춤
        int[][] sumArr = new int[n+1][n+1];

        //배열 저장하기(이중 for문)
        for (int i = 1; i <=n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] + arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        //질의 계산 및 출력
        for (int q = 0; q < m; q++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = sumArr[x2][y2] - sumArr[x1-1][y2] - sumArr[x2][y1-1] + sumArr[x1-1][y1-1];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);

    }
}
