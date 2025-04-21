/**
 아이디어
 중간 구슬이 불가능한 구슬 === 1. 자기보다 큰 구슬이 ((N+1)/2개 이상)
 2. 자기보다 작은 구슬이 ((N+1)/2개 이상)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2617 {
    static int N, M;
    static List<List<Integer>> biggerAdjList = new ArrayList<>();
    static List<List<Integer>> smallerAdjList = new ArrayList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens2 = new StringTokenizer(br.readLine(), " ");
        N = Integer.valueOf(tokens2.nextToken());
        M = Integer.valueOf(tokens2.nextToken());
        for(int i=0;i<N+1;i++)
        {
            biggerAdjList.add(new ArrayList<>());
            smallerAdjList.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++)
        {
            int big, small;
            StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
            big = Integer.valueOf(tokens.nextToken());
            small = Integer.valueOf(tokens.nextToken());

            biggerAdjList.get(small).add(big);
            smallerAdjList.get(big).add(small);

        }

        //when
        int result = 0;

        //각 구슬별 탐색
        int criteria = (N+1)/2;
        for(int i=1;i<=N;i++)
        {
            if(biggerAdjList.get(i).size() >= criteria || smallerAdjList.get(i).size() >= criteria){
                result++;
                continue;
            }

            int biggerBall = bfs(i, true);
            int smallerBall = bfs(i, false);

            if(biggerBall >= criteria || smallerBall >= criteria)
                result++;
        }

        System.out.print(result);

    }

    static int bfs(int stVertex, boolean isBigger){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int count = 0;

        //init
        q.offer(stVertex);
        visited[stVertex] = true;

        if(isBigger)	//biggerAdjList 사용
        {
            while(!q.isEmpty())
            {
                int u = q.poll();

                for(int v: biggerAdjList.get(u))
                {
                    if(!visited[v])
                    {
                        q.offer(v);
                        visited[v] = true;
                        count++;
                    }
                }
            }
        } else{			//smallerAdjList 사용
            while(!q.isEmpty())
            {
                int u = q.poll();

                for(int v: smallerAdjList.get(u))
                {
                    if(!visited[v])
                    {
                        q.offer(v);
                        visited[v] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
