package CH01;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Number2018 {
    public static void main(String[] args) throws IOException{

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int start = 1, end =1, sum = 1, count = 1;

        while (end < N) {

            //end 한 칸 이동해서 더해주기
            if (sum < N){
                end ++;
                sum += end;
            }
            //start 한 칸 이동하기
            else if (sum > N){
                sum -= start;
                start++;
            }
            //해당 경우 count,
            else {
                count++;
                end++;
                sum += end;
            }
        }

        System.out.println(count);
    }
}
