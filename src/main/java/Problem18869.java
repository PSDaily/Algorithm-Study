import java.util.*;
import java.io.*;

public class Problem18869{
    static int N, M; //M: 우주개수, N:행성개수
    static Integer[][] darr;
    static Map<String, Integer> map=new HashMap<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens=new StringTokenizer(br.readLine()," ");

        M=Integer.valueOf(tokens.nextToken());
        N=Integer.valueOf(tokens.nextToken());
        darr=new Integer[M][N];

        for(int i=0;i<M;i++)
        {
            tokens=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++)
            {
                darr[i][j]=Integer.valueOf(tokens.nextToken());
            }
        }

        //when
        //좌표압축(랭크 구하기)
        int count=0;
        for(int i=0; i<M;i++)
        {
            getRank(i);
        }

        int result=0;
        for(Integer value:map.values()){
            result+=(value*(value-1))/2;
        }
        System.out.print(result);
    }

    static void getRank(int idx)
    {
        Integer[] arr=darr[idx];
        Integer[] rank=new Integer[N];

        //방법1
        //한 배열의 모든 두 원소의 관계를 조사(N^2) => 2중 for문

        //방법2
        //배열 각 원소의 크기 순서를 조사(NlogN) => sort, binarySearch
        Set<Integer> temp1=new TreeSet<>(Arrays.asList(arr));

        List<Integer> univ=new ArrayList<>(temp1);

        for(int i=0;i<N;i++)
        {
            int target=arr[i];
            rank[i]=Collections.binarySearch(univ, target);
        }

        String key=Arrays.toString(rank);
        map.put(key, map.get(key)==null?1:map.get(key)+1);

    }

}