import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1158Re {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb=new StringBuilder();

        int N = Integer.valueOf(tokens.nextToken());
        int M = Integer.valueOf(tokens.nextToken());
        List<Integer> ls = new LinkedList<>();
        for(int i=0;i<N;i++)
        {
            ls.add(i+1);
        }

        //when
        int ptr = M - 1;
        List<Integer> result = new LinkedList<>();
        sb.append("<");
        while (!ls.isEmpty()) {
            result.add(ls.remove(ptr));
            ptr += M - 1;
            if (ptr >= ls.size() && !ls.isEmpty()) {
                ptr = ptr % ls.size();
            }
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
