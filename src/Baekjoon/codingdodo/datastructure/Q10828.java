package Baekjoon.codingdodo.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            if(s.equals("push")){
                int a = Integer.parseInt(st.nextToken());
                stack.push(a);
            }
            else if(s.equals("pop")){
                System.out.println((stack.isEmpty()) ? -1 : stack.pop());
            }
            else if(s.equals("size")){
                System.out.println(stack.size());
            }
            else if(s.equals("empty")){
                System.out.println((stack.isEmpty() == true)? 1 :0);
            }
            else if(s.equals("top")){
                System.out.println((stack.peek() == null)? -1 :stack.peek());
            }
        }

    }
}
