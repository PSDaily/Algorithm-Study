package SWEA.D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2001 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int i=1;i<=T;i++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] arr = new int[N][N];
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    arr[j][k] = sc.nextInt();
                    // System.out.print(arr[j][k] + " ");
                }
                // System.out.println();
            }

            int[][] sum = new int[N-M+1][N-M+1];

            for(int a=0;a<N-M+1;a++){
                for(int b=0;b<N-M+1;b++){
                    int total = 0;
                    for(int c=a;c<a+M;c++){
                        for(int d=b;d<b+M;d++){
                            total += arr[c][d];
                        }
                    }
                    sum[a][b] = total;
                }
            }

            /*
            for(int j=0;j<N-M+1;j++){
                for(int k=0;k<N-M+1;k++){
                    System.out.print(sum[j][k] + " ");
                }
                System.out.println();

            }
             */

            int max = 0;
            for(int j=0;j<N-M+1;j++){
                for(int k=0;k<N-M+1;k++){
                    if(sum[j][k] > max){
                        max = sum[j][k];
                    }
                }
            }

            System.out.println("#"+i+" "+ max);


        }
    }
}
