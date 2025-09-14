package Baekjoon.step.step4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q10807 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int v = sc.nextInt();

        int n = 0;
        for(int i = 0; i < N; i++) {
            if(arr[i] == v) {
                n++;
            }
        }

        System.out.println(n);
    }
}
