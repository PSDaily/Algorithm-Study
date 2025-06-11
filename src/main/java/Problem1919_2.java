import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1919_2 {
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
        int[] a1=new int[26];
        int[] a2=new int[26];

        for (char c : v1) {
            a1[c-'a']++;
        }
        for (char c : v2) {
            a2[c-'a']++;
        }

        int missCount=0;
        for (int i = 0; i < 26; i++) {
            missCount += Math.abs(a1[i] - a2[i]);
        }

        System.out.println(missCount);


    }
}