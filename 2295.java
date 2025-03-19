package org.example;

import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static Integer[] arr;
    static TreeSet<Integer> tempSet=new TreeSet<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.valueOf(br.readLine());
        arr=new Integer[N];

        for(int i=0;i<N;i++)
        {
            arr[i]=Integer.valueOf(br.readLine());
        }

        //when
        //a+b+c=sum => sum-c = a + b

        //1. a + b
        int result=0;
        Arrays.sort(arr, (a, b) -> b - a);
        for (int i = 0; i <= N-1; i++) {
            for (int j = i; j <= N-1; j++) {
                tempSet.add(arr[i] + arr[j]);
            }
        }

        //2.sum - c
        for (int i = 0; i <= N - 1; i++) {
            for (int j = i; j <= N - 1; j++) {
                //i === sum
                int target = arr[i] - arr[j];
                if (tempSet.contains(target)) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }

        System.out.print(result);



    }

}