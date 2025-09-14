package Baekjoon.codingdodo.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            Deque<Character> stack = new ArrayDeque<Character>();

            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if(stack.peek() != null && stack.peek() == s.charAt(j)) {
                    stack.pop();
                }
                else {
                    stack.push(s.charAt(j));
                }
            }
            // System.out.println("i:"+ i + " " + stack);

            if(stack.isEmpty()){
                count++;
            }
        }
        System.out.println(count);
    }
}
