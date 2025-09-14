package SWEA.D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q1989 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int i=1;i<=T;i++){
            String s = sc.next();
            // System.out.println("s.length()="+s.length()+"s.length()/2="+s.length()/2);

            boolean flag = true;

            for(int j=0;j<s.length()/2;j++){
                if(s.charAt(j) != s.charAt(s.length()-j-1)){
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println("#"+i+" "+1);
            }
            else{
                System.out.println("#"+i+" "+0);
            }

        }
    }
}
