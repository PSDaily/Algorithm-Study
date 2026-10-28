package codeTree.hyundai;

import java.util.Scanner;

public class Q4_1 {
    static int n;
    static long B;
    static int[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        B = sc.nextLong();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // B이하의 예산을 사용해서 최저 성능을 최대로 올리기
        // 1->4 : 비용 9
        // 1->3 : 비용 4

        // 이 최저 성능이 가능한지?
        long answer = 0;
        long left,right,mid;
        left = 1;
        right = 2000000000; // 최대 성능: a=10^9 + B=10^18=(10^9)^2 -> 10^9에서 10^9 증가 = 2*(10^9)
        while(left<=right){
            mid = left+(right-left)/2;

            if(available(mid)){
                answer = mid;
                left = mid+1; // 늘리기
            }
            else{
                right = mid-1;
            }
        }

        System.out.println(answer);
    }

    static boolean available(long ability){
        long cost = 0;
        for (int i = 0; i < n; i++) {
            if(ability > a[i]){
                cost += (ability-a[i])*(ability-a[i]);
            }
            if(cost > B){
                return false;
            }
        }
        return true;
    }
}