import java.util.*;
import java.io.*;

public class Problem1919{
    public static void main(String[] args)throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String voca1=br.readLine();
        String voca2=br.readLine();
        char[] v1=voca1.toCharArray();
        char[] v2=voca2.toCharArray();

        if (v1.length > v2.length) {
            char[] temp = v1;
            v1 = v2;
            v2 = temp;
        }



        //when

        int missCount=0;
        int diff = v2.length - v1.length;

        Arrays.sort(v2);

        for (int i = 0; i < v1.length; i++) {

            int idx = Arrays.binarySearch(v2, v1[i]);
            if (idx < 0) {
                missCount++;
                continue;
            }

            char[] temp = new char[voca2.length()];

            System.arraycopy(v2, 0, temp, 0, idx);
            System.arraycopy(v2, idx + 1, temp, idx, v2.length - idx - 1);
            v2 = temp;
        }

        missCount *= 2;
        System.out.println(missCount+diff);

    }
}