import java.util.*;
import java.io.*;

public class Main{

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

            boolean flag = true;
            for (int j = 0; j < carr1.length; j++) {
                if (j == 0 && carr1.length != carr2.length) {
                    results[i] = "Impossible";
                    flag = false;
                    break;
                }
                int findIdx = Arrays.binarySearch(carr2, carr1[j]);
                if (findIdx < 0) {
                    results[i] = "Impossible";
                    flag = false;
                    break;
                } else {
                    char[] temp = new char[carr2.length-1];
                    System.arraycopy(carr2, 0, temp, 0, findIdx);
                    System.arraycopy(carr2, findIdx + 1, temp, findIdx, carr2.length - findIdx - 1);
                    carr2 = temp;
                }
            }
            if(flag) results[i] = "Possible";
        }
        for(String result:results) System.out.println(result);

    }
}