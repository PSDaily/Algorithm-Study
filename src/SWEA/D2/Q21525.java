package SWEA.D2;

import java.io.FileInputStream;
import java.util.Scanner;

import static java.lang.Math.*;

public class Q21525 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int i=1;i<=T;i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int N = sc.nextInt();
            // System.out.println("A="+A+" B="+B+" N="+N);

            int x = min(A,B);
            int y = max(A,B);
            // System.out.println("x="+x+" y="+y);

            int sum = 0;
            int num = 0;
            while(sum <= N){
                x += y;
                sum = x;
                num += 1;
                // System.out.println("sum="+sum+", num="+num);

                if(sum>N){
                    break;
                }
                y += x;
                sum = y;
                num += 1;
                // System.out.println("sum="+sum+", num="+num);
            }

            System.out.println(num);
        }
    }
}
