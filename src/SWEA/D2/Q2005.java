package SWEA.D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2005 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=1;i<=T;i++){
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            for(int a=0;a<N;a++){
                for(int b=0;b<N;b++){
                    if(b==0){
                        arr[a][b] = 1;
                    }
                    else if(a==b){
                        arr[a][b] = 1;
                    }
                    else if (a>=b){
                        arr[a][b] = arr[a-1][b-1]+arr[a-1][b];
                    }

                }
            }

            System.out.println("#"+i);
            for(int a=0;a<N;a++){
                for(int b=0;b<N;b++){
                    if(a>=b){
                        System.out.print(arr[a][b]+" ");
                        if (b < a) System.out.print(" "); // 마지막 원소 뒤에는 공백 X
                    }
                }
                System.out.println();
            }
        }
    }
}
