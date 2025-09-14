package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2071 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int i=1;i<=T;i++){
            int sum = 0;
            for(int j=0;j<10;j++){
                int num = sc.nextInt();
                sum += num;
            }
            int avg = (int) Math.round(sum/10.0);
            System.out.println("#"+i+" "+ avg);
        }
    }
}
