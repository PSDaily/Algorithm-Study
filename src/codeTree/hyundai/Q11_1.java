package codeTree.hyundai;

import java.util.*;

public class Q11_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        int K = scanner.nextInt();
        int M = scanner.nextInt();
        // Please write your code here.

        Map<Long,Integer> map = new HashMap<>();

        long p = 0;
        for(int i=0;i<K;i++){
            p = p*2 + (S.charAt(i)-'0'); // 해싱
        }
        map.put(p,1);

        for(int i=K;i<S.length();i++){
            int left = S.charAt(i-K)-'0';
            int right = S.charAt(i)-'0';

            p = (p-left*(1<<K-1))*2 + right;

            map.put(p,map.getOrDefault(p,0)+1);
        }

        boolean answer = false;
        for(int value: map.values()){
            if(value >= M){
                answer = true;
                break;
            }
        }

        System.out.println(answer ? 1:0);
    }
}