import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2467 {
    static int N;
    static int[] arr;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.valueOf(br.readLine());
        arr=new int[N];

        StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i]=Integer.valueOf(tokens.nextToken());
        }

        //when
        long min = (long)Integer.MAX_VALUE * 2 - 1L;
        int result1=0, result2=0;

        //방법1: 두 숫자 조합을 모두 탐색(N^2)

        //방법2: 숫자하나만 고르고, 목표 숫자를 이분탐색(NlogN)
        for (int i = 0; i < N; i++) {
            int best = -arr[i];
            int idx = Arrays.binarySearch(arr, best);

            if (idx < 0) { //best가 존재x
                //idx: 들어가게될 위치
                idx=-idx-1;
                int pos1, pos2, pos3;
                pos1=idx-1;
                pos2=idx;
                pos3=idx+1;

                if (pos1 >= 0 && pos1 != i && Math.abs(arr[pos1] + arr[i]) < min) {
                    result1=i;
                    result2=pos1;
                    min = Math.abs(arr[pos1] + arr[i]);
                }

                if (pos2 <N && pos2 != i && Math.abs(arr[pos2] + arr[i]) < min) {
                    result1=i;
                    result2=pos2;
                    min = Math.abs(arr[pos2] + arr[i]);
                }

                if (pos3 < N && pos3 != i && Math.abs(arr[pos3] + arr[i]) < min) {
                    result1=i;
                    result2=pos3;
                    min = Math.abs(arr[pos3] + arr[i]);
                }
            } else { //best가 존재
                if (arr[i] < 0) {
                    System.out.println(arr[i] + " " + -arr[i]);
                } else {
                    System.out.println(-arr[i] + " " + arr[i]);
                }
                return;
            }
        }
        if (result1 > result2) {
            int temp=result1;
            result1=result2;
            result2=temp;
        }

        System.out.println(arr[result1]+" "+arr[result2]);
    }

}
