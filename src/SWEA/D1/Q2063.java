package SWEA.D1;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Q2063 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        int[] arr = new int[T];
        for(int i=1;i<=T;i++){
            arr[i-1] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(arr[T/2]);

    }
}
