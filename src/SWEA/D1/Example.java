package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Example {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int i=1;i<=T;i++){


            System.out.println("#"+i+" "+ "");
        }
    }
}
