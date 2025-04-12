import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1260 {
    static int N, M, V;
    static List<Set<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
        N=Integer.valueOf(tokens.nextToken()); // vertex 수
        M=Integer.valueOf(tokens.nextToken()); // edge 수
        V=Integer.valueOf(tokens.nextToken()); // 시작 vertex

        // init adjList
        for(int i=0;i<N+1;i++)
        {
            adjList.add(new TreeSet<>());
        }
        visited=new boolean[N+1];

        // add edge
        for(int i=0;i<M;i++)
        {
            StringTokenizer tokens2 = new StringTokenizer(br.readLine()," ");
            int v, u;
            v=Integer.valueOf(tokens2.nextToken());
            u=Integer.valueOf(tokens2.nextToken());

            if(!adjList.get(v).contains(u))	adjList.get(v).add(u);
            if(!adjList.get(u).contains(v))	adjList.get(u).add(v);
        }


        //when
        StringBuilder sb = new StringBuilder();
        dfs(V, sb);

        Arrays.fill(visited, false);
        sb.append("\n");

        bfs(V, sb);

        // then
        System.out.print(sb.toString());
    }

    static void dfs(int stVertex, StringBuilder sb)
    {
        visited[stVertex]=true;
        sb.append(stVertex+" ");

        // 탐색
        for(int v : adjList.get(stVertex))
            if(!visited[v])	dfs(v, sb);

        return;
    }

    static void bfs(int stVertex, StringBuilder sb)
    {
        Queue<Integer> q = new LinkedList<>();

        // init
        q.offer(stVertex);
        visited[stVertex]=true;

        while(!q.isEmpty())
        {
            //poll
            int v = q.poll();
            sb.append(v+" ");

            // 탐색
            for(int u: adjList.get(v))
            {
                if(!visited[u])
                {
                    visited[u]=true;
                    q.offer(u);
                }
            }
        }

    }
}