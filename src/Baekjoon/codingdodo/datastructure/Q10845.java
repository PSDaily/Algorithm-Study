package Baekjoon.codingdodo.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("push")){
                int a = Integer.parseInt(st.nextToken());
                queue.offer(a);
            }
            else if(s.equals("pop")){
                System.out.println((queue.isEmpty()) ? -1 : queue.poll());
            }
            else if(s.equals("size")){
                System.out.println(queue.size());
            }
            else if(s.equals("empty")){
                System.out.println((queue.isEmpty() == true)? 1 :0);
            }
            else if(s.equals("front")){
                System.out.println((queue.peekFirst() == null)? -1 :queue.peekFirst());
            }
            else if(s.equals("back")){
                System.out.println((queue.peekLast() == null)? -1 :queue.peekLast());
            }
        }
    }
}
