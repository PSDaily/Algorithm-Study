package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2047 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                System.out.print((char)(c-32));
            }
            else System.out.print(c);
        }
    }
}
