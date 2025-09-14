package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2025 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        int sum = 0;
        for(int i=1;i<=T;i++){
            sum = sum + i;
        }
        System.out.println(sum);
    }
}
