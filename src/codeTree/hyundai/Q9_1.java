package codeTree.hyundai;

import java.util.Scanner;

public class Q9_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String S = sc.nextLine();

        if (N % 2 != 0) {
            System.out.println("No");
            return;
        }

        int min = 0;
        int max = 0;
        for(char c: S.toCharArray()){
            if(c=='('){
                min++;
                max++;
            }
            else if(c==')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }

            if(max < 0){
                System.out.println("No");
                return;
            }

            min = Math.max(min,0);
        }

        System.out.println(min==0 ? "Yes":"No");

    }
}