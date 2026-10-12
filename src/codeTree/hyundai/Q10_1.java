package codeTree.hyundai;

import java.util.Scanner;

public class Q10_1 {
    static int[] positions;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        positions = new int[N];
        for (int i = 0; i < N; i++) {
            positions[i] = scanner.nextInt();
        }

        int left = 1;
        int right = positions[N-1]-positions[0]+1;
        int answer = 0;
        while(left <= right){
            int mid = left + (right-left)/2; // 패치 길이

            // 해당 패치 길이로 수리 가능한지
            if(patch(mid) <= K){
                right = mid-1;
                answer = mid;
            }
            else{
                left = mid+1;
            }

        }

        System.out.println(answer);
    }

    static int patch(int length){
        int count = 1;

        int now = positions[0]+length-1;
        for(int i: positions){
            if(now >= i){
                continue;
            }

            else{
                count++;
                now = i+length-1;
            }
        }

        return count;
    }
}