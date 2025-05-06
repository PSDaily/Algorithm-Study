import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem11725 {

    static int N;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        for(int i=0;i<N+1;i++)
        {
            adjList.add(new ArrayList<>());
        }
        parent = new int[N+1];

        for(int i=0;i<N-1;i++)
        {

            StringTokenizer tokens = new StringTokenizer(br.readLine()," ");
            int u, v;
            u = Integer.valueOf(tokens.nextToken());
            v = Integer.valueOf(tokens.nextToken());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        //when
        bfs(1);

        //then
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=N;i++)
        {
            sb.append(parent[i]+"\n");
        }

        System.out.print(sb.toString());

    }

    static void bfs(int stVertex){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        // init
        q.offer(stVertex);
        visited[stVertex] = true;

        //탐색
        while(!q.isEmpty())
        {
            int u = q.poll();

            for(int v : adjList.get(u))
            {
                if(!visited[v])
                {
                    visited[v]=true;
                    q.offer(v);
                    parent[v] = u;
                }
            }
        }


    }
}