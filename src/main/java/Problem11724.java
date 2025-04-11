import java.util.*;
import java.io.*;

public class Problem11724 {
    static int N, M;
    //무방향 그래프
    static List<Integer>[] adjList;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited;


    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens1=new StringTokenizer(br.readLine(), " ");
        N=Integer.valueOf(tokens1.nextToken());
        M=Integer.valueOf(tokens1.nextToken());
        adjList = new ArrayList[N+1];	//1-indexed
        visited = new boolean[N+1];

        for(int i=0;i<N+1;i++)
        {
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++)
        {
            StringTokenizer tokens2=new StringTokenizer(br.readLine(), " ");
            int v = Integer.valueOf(tokens2.nextToken());
            int u = Integer.valueOf(tokens2.nextToken());

            adjList[v].add(u);
            adjList[u].add(v);
        }

        //when
        int result=0;

        while(true)
        {
            boolean left=false;
            int stVertex=0;
            for(int i=1;i<N+1;i++)
            {
                if (!visited[i]) {
                    left = true;
                    stVertex=i;
                    break;
                }
            }
            if(!left) break;

            //bfs
            //initialize
            result++;
            bfs(stVertex);

        }

        System.out.print(result);

    }

    private static void bfs(int stVertex) {
        q.offer(stVertex);
        visited[stVertex]=true;

        while(!q.isEmpty())
        {
            //q.poll()
            int v1 = q.poll();

            //탐색
            for(Integer v2: adjList[v1])
            {
                //q.push
                if(!visited[v2])
                {
                    q.offer(v2);
                    visited[v2]=true;
                }
            }
        }
    }
}