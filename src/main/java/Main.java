import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        char[] carr = {'a', 'b', 'c'};
        char[] carr2 = {'a', 'b', 'c'};


        System.out.println(Arrays.binarySearch(carr, carr[0]));
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
