package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q1936 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if ((a==1 && b==3) || (a==2 && b==1) || (a==3 && b==2)) {
                System.out.print("A");
        }
        else {
            System.out.print("B");
        }
    }
}
