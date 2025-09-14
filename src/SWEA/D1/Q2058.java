package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2058 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        int a = 0;
        for (int i = 3; i >= 0; i--){
            int n = (int) Math.pow(10,i); // 제곱
            a += T/n;
            // System.out.println("a="+a);

            T = T%n;
            // System.out.println("T="+T);
        }

        System.out.println(a);

        /*
        int sum = 0;
        while(T>0){
            sum += T % 10; // 마지막 한 자리
            T /= 10; // 한 자리 줄이기
        }

        System.out.println(sum);
         */
    }
}
