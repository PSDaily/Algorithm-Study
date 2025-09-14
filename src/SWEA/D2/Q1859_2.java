package SWEA.D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q1859_2 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        // System.out.println("T = "+T);

        for(int i=1;i<=T;i++){
            int N = sc.nextInt();
            // System.out.println("N = "+N);
            int[] arr = new int[N];

            // 배열에 넣기
            for(int j=0;j<N;j++){
                arr[j] = sc.nextInt();
                // System.out.print(arr[j]+" ");
            }
            // System.out.println("\n");

            int max = 0;
            int sum = 0;
            for(int j=N-1;j>=0;j--){
                if(arr[j]>max){
                    max = arr[j];
                }
                else{
                    sum += max-arr[j];
                }
            }

            System.out.println("#"+i+" "+ sum);
        }
    }
}
