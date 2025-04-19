// 6단계 내로 연결된다
//강호 세희 . 민호 - 민호 - 백준 - 선영 - 도현 - 세희 => 인원수 -1: result
// 모든 사람과의 베이컨거리 합의 최소값
//1:10,

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1389 {

    static int N, M; // N: 사람수, M: 엣지 수
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] bacon;
    static int[][] distArr;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine()," ");


        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());
        bacon = new int[N+1];
        visited = new boolean[N+1];
        distArr = new int[N + 1][N + 1];

        for(int i=0;i<N+1;i++)
            adjList.add(new ArrayList<>());

        //edge 중복 제거 필요
        for(int i=0;i<M;i++)
        {
            StringTokenizer tokens2 = new StringTokenizer(br.readLine()," ");
            int v = Integer.valueOf(tokens2.nextToken());
            int u = Integer.valueOf(tokens2.nextToken());

            if(!adjList.get(v).contains(u)) adjList.get(v).add(u);
            if(!adjList.get(u).contains(v)) adjList.get(u).add(v);
        }


        //when
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 1; i <= N; i++) {
            int sum = bfs(i);
            if (min > sum) {
                min = sum;
                idx = i;
            }
        }

        System.out.print(idx);
    }

    static int bfs(int stVertex)
    {
        int bacon = 0;
        // init
        Arrays.fill(visited, false);
        Queue<Integer> q = new LinkedList<>();
        visited[stVertex] = true;
        q.offer(stVertex);

        int[] depth = new int[N + 1];
        depth[stVertex] = 0;
        while(!q.isEmpty())
        {
            // q.poll
            int v = q.poll();
            // 탐색
            for(int u: adjList.get(v))
            {
                if(!visited[u])
                {
                    visited[u] = true;
                    depth[u] = depth[v] + 1;
                    bacon += depth[u];
                    q.offer(u);
                }
            }

        }
        return bacon;
    }


}