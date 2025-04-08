import java.util.*;
import java.io.*;

public class Problem11279{
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b)->
    {
        return - (a-b);
    });

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N=Integer.valueOf(br.readLine());

        for(int i=0;i<N;i++)
        {
            int num = Integer.valueOf(br.readLine());

            if(num == 0)
            {
                if(pq.size() == 0) sb.append(0+"\n");
                else sb.append(pq.poll()+"\n");
            }
            else pq.offer(num);
        }

        System.out.print(sb.toString());
    }
}
