package Baekjoon.codingdodo.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] price = new int[14];
        for(int i = 0; i < 14; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        // 준현
        int j_money = money;
        int j_stock = 0;
        int j_num = 0;
        for(int i = 0; i < 14; i++){
            j_num = j_money/price[i]; // 현재 살 수 있는 주식 수
            j_money -= j_num*price[i]; // 남은 돈
            j_stock += j_num; // 사고나서 변한 주식 수
        }

        // 성민
        int[] plus = new int[14];
        plus[0] = 0;
        for(int i = 0; i < 13; i++){
            if(price[i] < price[i+1]){
                plus[i+1] = plus[i]+1;
            }
            else{
                plus[i+1] = 0;
            }
        }

        int[] minus = new int[14];
        minus[0] = 0;
        for(int i = 0; i < 13; i++){
            if(price[i] > price[i+1]){
                minus[i+1] = minus[i]+1;
            }
            else{
                minus[i+1] = 0;
            }
        }

        /*
        for(int i = 0; i < 14; i++){
            System.out.print(price[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < 14; i++){
            System.out.print(plus[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < 14; i++){
            System.out.print(minus[i] + " ");
        }
        System.out.println();

        System.out.println("현재 돈 : " + money);
         */

        int stock = 0;
        int num = 0;
        for(int i=0;i<14;i++){
            // 매수
            if(minus[i]>=3){
                // System.out.println("i : " + i + ", price : " + price[i]);
                num = money/price[i]; // 현재 살 수 있는 주식 수
                // System.out.println("현재 살 수 있는 주식 수 : " + num);
                money -= num*price[i]; // 남은 돈
                // System.out.println("남은 돈 : " + money);
                stock += num; // 사고나서 변한 주식 수
                // System.out.println("사고나서 변한 주식 수 : " + stock);
            }
            // 매도
            if(plus[i]>=3){
                // System.out.println("i : " + i + ", price : " + price[i]);
                money += stock*price[i]; // 팔고나서 변한 돈
                // System.out.println("팔고나서 변한 돈 : " + money);
                stock = 0; // 팔고나서 변한 주식 수 = 0 (전량 매도)
                // System.out.println("팔고나서 변한 주식 수 : " + stock);
            }
        }

        j_money = j_money + price[13]*j_stock;
        // System.out.println(j_money);

        money = money + price[13]*stock;
        // System.out.println(money);

        if(j_money > money){
            System.out.print("BNP");
        }
        else if (j_money < money) {
            System.out.print("TIMING");
        }
        else{
            System.out.print("SAMESAME");
        }
    }
}
