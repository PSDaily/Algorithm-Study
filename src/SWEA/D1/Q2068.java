package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2068 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int i=1;i<=T;i++){
            int a = 0;
            for(int j=1;j<=10;j++){
                int b = sc.nextInt();
                if (a < b) a = b;
            }
            System.out.println("#"+i+" "+ a);
        }
    }
}
