import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11328 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.valueOf(br.readLine());
        String[] results = new String[N];

        for(int i=0;i<N;i++)
        {
            StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
            String s1 = tokens.nextToken();
            String s2 = tokens.nextToken();

            char[] carr1 = s1.toCharArray();
            char[] carr2 = s2.toCharArray();

            Arrays.sort(carr2);
            Arrays.sort(carr1);

            // case1: diff length
            if(carr1.length!=carr2.length) results[i] = "Impossible";

            // case2: same length
            boolean flag = true;

            // validate same character or not
            for (int j = 0; j < carr1.length; j++) {
                if (carr1[j] != carr2[j]) {
                    results[i] = "Impossible";
                    flag = false;
                    break;
                }
            }

            if(flag) results[i] = "Possible";

        }



        for(String result:results) System.out.println(result);

    }
}