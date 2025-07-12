import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine(), ",");
        ArrayList<Object> ls = new ArrayList<>();
        while (tokens.hasMoreTokens()) {
           ls.add(Integer.parseInt(tokens.nextToken()));
        }
        int[] array = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            array[i] = (int)ls.get(i);
        }


    }
    public static int[] solution(int[] array, int[][] commands) {

        int[] results=new int[commands.length];
        for(int a=0;a<commands.length;a++)
        {
            int i,j,k;
            i=commands[a][0];
            j=commands[a][1];
            k=commands[a][2];

            int[] cArray=new int[array.length-(j-i+1)];
            System.arraycopy(array,0,cArray,0,i);
            System.arraycopy(array,j,cArray,i,array.length-j);

            Arrays.sort(cArray);

            results[a]=cArray[k-1];
        }

        int[] answer = results;
        return answer;
    }
}