package SWEA.D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q1926 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int i=1;i<=T;i++) {
            int count = 0;
            String n = String.valueOf(i);
            for (int j = 0; j < n.length(); j++) {
                if (n.charAt(j) == '3' || n.charAt(j) == '6' || n.charAt(j) == '9') {
                    count++;
                }
            }
            if (count == 0) {
                System.out.print(i + " ");
            } else {
                for (int j = 0; j < count; j++) {
                    System.out.print("-");
                }
                System.out.print(" ");
            }
        }
    }
}
