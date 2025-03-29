import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem12738 {

    static int N;
    static int[] arr;
    static int[] LIS;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        arr = new int[N];
        LIS = new int[N];

        StringTokenizer tokens = new StringTokenizer(br.readLine()," ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(tokens.nextToken());
        }

        //when
        Arrays.fill(LIS,Integer.MAX_VALUE);
        LIS[0] = arr[0];

        for (int i = 1; i < N; i++) {
            int num=arr[i];
            int idx = Arrays.binarySearch(LIS, 0, i, num);
            if(idx>0) continue;
            if(idx<0) idx = -idx - 1;
            LIS[idx]=num;
        }

        int result=0;
        while (result < N && LIS[result] != Integer.MAX_VALUE) {
            result++;
        }
        System.out.println(result);

    }

}
