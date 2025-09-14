package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2043 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(a-b+1);
    }
}

