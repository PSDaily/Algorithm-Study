import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem11328 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
            char[] voca1 = tokens.nextToken().toCharArray();
            char[] voca2 = tokens.nextToken().toCharArray();

            int[] arr1 = new int[26];
            int[] arr2 = new int[26];

            parseAlphabet(voca1, arr1);
            parseAlphabet(voca2, arr2);

            checkAnagram(arr1, arr2);
        }
    }

    private static void checkAnagram(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }

    private static void parseAlphabet(char[] voca, int[] arr) {
        for (int i = 0; i < voca.length; i++) {
            arr[voca[i] - 'a']++;
        }
    }
}
