package codeTree.hyundai;

import java.util.Scanner;

public class Q9_1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String S = sc.nextLine();

        // 1. 항상 (가 )보다 크거나 같아야 함. -> )가 더 크면 break
        // 2. 마지막엔 (와 )가 동일해야 함.
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        // 홀수개 나오면 바로 불가능
        if(N%2 != 0){
            System.out.println("No");
            return;
        }
        for(int i=0;i<N;i++){
            // (가 나오면 count
            if(S.charAt(i) == '('){
                count1++;
            }

            // )가 나오면 count
            else if(S.charAt(i) == ')'){
                count2++;
            }

            // ?가 나오면 (랑 ) 비교해서 count
            else{
                count3++;
            }

            if(count1+count3 < count2){
                System.out.println("No");
                return;
            }
        }

        if(N/2 < count1 || N/2 < count2){
            System.out.println("No");
            return;
        }

        count1 = 0;
        count2 = 0;
        count3 = 0;

        for(int i = N - 1; i >= 0; i--){
            if(S.charAt(i) == '('){
                count1++;
            }
            else if(S.charAt(i) == ')'){
                count2++;
            }
            else{
                count3++;
            }

            if(count2 + count3 < count1){
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}