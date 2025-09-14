package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2019 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        int a = 1;
        System.out.print(a+" ");
        for(int i = 0; i < T; i++){
            a = a*2;
            System.out.print(a+" ");
        }
    }
}
