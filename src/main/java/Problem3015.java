import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem3015 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N= Integer.valueOf(br.readLine());
        arr = new int[N];

        for(int i=0;i<N;i++)
        {
            arr[i]=Integer.valueOf(br.readLine());
        }

        //when
        Stack<Pair> stk = new Stack<>();
        long result = 0;
        for(int i=0;i<N;i++)
        {
            int num = arr[i];
            int count = 1;

            // 자기보다 작은 값들 == 뒤를 더 이상 못봄
            while(!stk.isEmpty() && stk.peek().height < num)
            {
                Pair p = stk.pop();
                result += p.count;
            }

            if(!stk.isEmpty() && stk.peek().height == num)
            {
                Pair  p = stk.pop();
                result += p.count;
                count += p.count;
            }

            if(!stk.isEmpty()) result += 1;

            stk.push(new Pair(num, count));
        }

        System.out.print(result);

    }

    private static class Pair{
        int height;
        int count;

        Pair(int h, int c){
            height=h;
            count=c;
        }
    }
}
