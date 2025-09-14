package SWEA.D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2007 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int i=1;i<=T;i++){
            String s = sc.next();
            char[] arr = new char[30];
            for(int j=0;j<30;j++){
                arr[j] = s.charAt(j);
                // System.out.print(arr[j]);
            }

            int n = 1;
            int a = 0;
            while(a<10){
                if(arr[a]!=arr[a+n]){
                    n++;
                    // System.out.println("n="+n);
                }
                else{
                    for(int b=1;b<n;b++){
                        if(arr[b]!=arr[b+n]){
                            n++;
                            break;
                        }
                        else{
                            a++;
                        }
                    }
                }
            }
            System.out.println("#"+i+" "+ n);
        }
    }
}
