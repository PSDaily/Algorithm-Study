package CH01;

import java.util.Scanner;

public class Number11720 {
    public static void main(String[] args) {
        //N값 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //sNum 값을 String형으로 저장
        String sNum = sc.next();

        //sNum을 char[]형 변수 cNum에 저장
        char[] cNum = sNum.toCharArray();

        //int형 변수 sum 선언
        int sum = 0;

        //for(cNum 길이만큼 반복){ 배열의 각 자릿값을 정수형으로 변환하여 sum에 더해 누적하기 }
        for(int i = 0; i < cNum.length; i++){
            //sum = sum + cNum[i]; -> cNum을 그대로 더하면 안되고, 정수형으로 변환해서 넣어야됨
            sum += cNum[i] - '0';
        }

        //sum 출력
        System.out.println(sum);

    }
}
