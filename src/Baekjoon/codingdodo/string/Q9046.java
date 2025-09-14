package Baekjoon.codingdodo.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int[] arr = new int[26];

            String s = br.readLine();
            for(int j=0;j<s.length();j++){
                if(s.charAt(j) != ' '){
                    arr[s.charAt(j) - 'a']++;
                }
            }

            int max = Integer.MIN_VALUE;
            char ans = '0';
            for(int j=0;j<26;j++){
                if(arr[j]>max){
                    max = arr[j];
                    ans = (char) (j+'a');
                }
            }

            int count = 0;
            for(int j=0;j<26;j++){
                if(arr[j] == max){
                    count++;
                }
            }

            if(count > 1){
                System.out.println('?');
            }
            else{
                System.out.println(ans);
            }
        }

    }
}
