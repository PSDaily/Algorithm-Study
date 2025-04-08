package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1654 {
    static int K, N;
    static int[] arr;
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens=new StringTokenizer(br.readLine()," ");
        long result=0;

        K=Integer.valueOf(tokens.nextToken());
        N=Integer.valueOf(tokens.nextToken());
        arr=new int[K];

        long max=0L;
        for(int i=0;i<K;i++)
        {
            arr[i]=Integer.valueOf(br.readLine());
            if(arr[i]>max) max = (long)arr[i];
        }

        //when
        //initialize(st, fin, pos)
        long st=1L, fin=max;
        long pos=(st+fin)/2;

        while(st<=fin)
        {
            int count = calculate(pos);
            if(count>=N && pos>result){
                result=pos;	//N보다  많은 막대기를 만듦 & 긴 길이
                //st=pos+1
                st=pos+1;
            } else if(count<N){
                fin=pos-1;
            }
            pos=(st+fin)/2;

        }

        System.out.print(result);

    }

    static int calculate(long length){
        int count=0;
        for(int i=0;i<K;i++)
        {
            count+=arr[i]/(int)length;
        }

        return count;
    }
}