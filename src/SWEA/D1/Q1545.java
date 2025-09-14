package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q1545 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int i=T;i>=0;i--){
            System.out.print(i+" ");
        }
    }
}
