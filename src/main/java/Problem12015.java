package main.java;

import java.util.*;
import java.io.*;

public class Problem12015{
    static int N;
    static int[] arr;
    static int[] LIS; //LIS[i]=== min(길이 i인 가장 긴 증가부분수열의 끝 값)
    static int count=0;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.valueOf(br.readLine());
        LIS=new int[N];
        arr=new int[N];

        StringTokenizer tokens=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)
        {
            arr[i]=Integer.valueOf(tokens.nextToken());
        }

        //when
        LIS[0]=arr[0];
        count++;

        for(int i=1;i<N;i++)
        {
            int target=arr[i];
            int idx=Arrays.binarySearch(LIS,0,count,target);

            if(idx<0){
                idx=-idx-1;
                //case2: 추가 끝 인덱스
                if(idx==count){
                    LIS[count++]=target;
                }
                //case1: 기존 인덱스 범위 안
                else{
                    LIS[idx]=target;
                }
            }
        }

        System.out.print(count);

    }

}