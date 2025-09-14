package Baekjoon.step.step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();

        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A']++;
        }

        int max = Integer.MIN_VALUE;
        char ans = '?';
        for(int i = 0; i < 26; i++) {
            if(arr[i] > max) {
                max = arr[i];
                ans = (char) (i+'A');
            }
            else if(arr[i] == max) {
                ans = '?';
            }
        }

        System.out.print(ans);
    }
}
