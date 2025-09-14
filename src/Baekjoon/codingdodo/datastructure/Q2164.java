package Baekjoon.codingdodo.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q2164 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= N; i++) {
            queue.addLast(i);
        }

        while(queue.size() > 1) {
            int x = queue.removeFirst();
            // System.out.println("remove: " + x);

            int y = queue.removeFirst();
            queue.addLast(y);
            // System.out.println("add: " + y);

            // System.out.println(queue);
        }

        System.out.println(queue.removeFirst());
    }
}
