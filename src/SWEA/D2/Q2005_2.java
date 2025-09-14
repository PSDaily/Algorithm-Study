package SWEA.D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2005_2 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = sc.nextInt();

        int[] arr = new int[N];

        for(int i=1;i<=T;i++){
            System.out.println("#"+i);
            int temp_1;
            int temp_2;
            for(int a=0;a<N;a++){
                for(int b=0;b<N;b++){
                    if (a>=b){
                        temp_1 = ((b==0)||(a==b)) ? 1 : arr[a-1];
                        temp_2 = (a==b) ? 1 : arr[a];
                        arr[a] = (a==0)? 1 : temp_1+temp_2;

                        System.out.print(arr[a] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
