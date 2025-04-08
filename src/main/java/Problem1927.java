import java.util.*;
import java.io.*;

public class Problem1927 {

    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        N=Integer.valueOf(br.readLine());

        for(int i=0;i<N;i++)
        {
            int x = Integer.valueOf(br.readLine());

            if(x==0) // x =0 : 최소값 출력후 제거
            {
                sb.append((pq.size()==0?0:pq.poll())+"\n");
            }
            else{ //if x = 자연수: 넣기
                pq.offer(x);
            }


        }

        System.out.print(sb.toString());


    }

}
