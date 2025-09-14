package SWEA.D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q1859 {
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

            long total_sum = 0;
            while(true){
                // max와 그 index 찾기
                int max = 0;
                int index = 0;
                for(int j=0;j<N;j++){
                    if(arr[j]>max){
                        max = arr[j];
                        index = j;
                    }
                }

                int sum = 0;
                for(int j=0;j<=index;j++){
                    sum += max - arr[j];
                }

                if(sum<0){
                    System.out.println("#"+i+" "+ total_sum);
                    break;
                }
                else{
                    total_sum += sum;
                }

                N = N-index-1;

                // 남은 배열로 새 배열 만들기
                for(int j=0;j<N;j++){
                    arr[j] = arr[j+index+1];
                }
            }

        }
    }
}
