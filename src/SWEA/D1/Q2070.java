package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2070 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int i=1;i<=T;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                char c = a < b ? '<' : ( a == b ? '=' : '>');
                System.out.println("#"+i+" "+ c);
        }
    }
}
