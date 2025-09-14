package SWEA.D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q2056 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int i=1;i<=T;i++){
            String s = sc.next();
            int yyyy = Integer.parseInt(s.substring(0,4));
            int mm = Integer.parseInt(s.substring(4,6));
            int dd = Integer.parseInt(s.substring(6,8));

            boolean valid = true;
            int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

            if (mm<1 || mm>12) {
                valid = false;
            }
            else {
                if(dd<1 || dd>days[mm-1]){
                    valid = false;
                }
            }

            if(valid){
                System.out.printf("#%d %04d/%02d/%02d%n", i, yyyy, mm, dd);
            }
            else{
                System.out.printf("#%d -1%n",i);
            }

        }
    }
}

