import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1158Re {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb=new StringBuilder();

        int N = Integer.valueOf(tokens.nextToken());
        int M = Integer.valueOf(tokens.nextToken());
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<N;i++)
        {
            q.offer(i+1);
        }

        //when
        int ptr = M - 1;
        List<Integer> result = new LinkedList<>();
        sb.append("<");
        while (!q.isEmpty()) {
            for (int i = 1; i <= M - 1; i++) {
                q.offer(q.poll());
            }
            result.add(q.poll());
        }


        for (Integer num : result) {
            if (num == result.get(N - 1)) {
                sb.append(num + ">");
            } else {
                sb.append(num + ", ");
            }
        }

        System.out.println(sb);
    }
}
