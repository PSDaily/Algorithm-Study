package main.java;

import java.util.*;
import java.io.*;

public class Problem11286 {

    static int N;
    static int[] arr;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> {
                if(Math.abs(a) == Math.abs(b)) return a-b;
                else  return Math.abs(a) - Math.abs(b);
            }
    );

    public static void main(String[] args)throws IOException{
        //0=> 절대값중 최소값을 출력 후 재거
        //그외 => 삽입

        //매번 최소값의 갱신이 필요함
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        N=Integer.valueOf(br.readLine());
        arr=new int[N];

        int n=N;
        while(n-- > 0)
        {
            int num = Integer.valueOf(br.readLine());

            if(num==0)
            {
                int value = pq.size()==0?0:pq.poll();
                sb.append(value+"\n");
            }else{
                pq.offer(num);
            }
        }

        System.out.print(sb.toString());

    }

}