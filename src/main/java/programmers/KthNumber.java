package programmers;

import java.util.Arrays;

public class KthNumber {
        public int[] solution(int[] array, int[][] commands) {

            int[] results=new int[commands.length];
            for(int a=0;a<commands.length;a++)
            {
                int i,j,k;
                i=commands[a][0];
                j=commands[a][1];
                k=commands[a][2];

                int[] cArray=new int[j-i+1];
                int cnt=0;
                for(int b=i-1;b<j;b++)
                {
                    cArray[cnt++]=array[b];
                }

                Arrays.sort(cArray);

                results[a]=cArray[k-1];
            }

            int[] answer = results;
            return answer;
        }
}
