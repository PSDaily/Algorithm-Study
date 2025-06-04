import java.util.*;
import java.io.*;

class ProblemKakaoWinterInternship2 {
    public int[] solution(int[][] edges) {
        // List<List<Integer>> adjList = new ArrayList<>( );
        int max=0;

        for(int[] row: edges)
            for(int col: row)
                if(max<col) max=col;

        int N=max;
        boolean[] isTarget=new boolean[N+1]; // 1 indexed, 막대의 루트 OR GNode
        Arrays.fill(isTarget, true);

        int targetCount=0;
        int[] gnode=new int[2];
        for(int[] row: edges)
        {
            int num=row[1];
            isTarget[num]=false;
        }
        for(int i=1;i<=N;i++)
            if(isTarget[i]){
                targetCount++;
                gnode[gnode.length]=i;
            }

        // case1: 막대 그래프 1개만 있었던 경우
        if(targetCount!=1)
        {
            int target1=gnode[0];
            int target2=gnode[1];

        }
        // case2: 그 외(루트가 확정되는 경우)
        else{
            //gnode확정
            boolean[] visited=new boolean[N+1];

            int realGnode=gnode[0];
            int st=0;
            if(st==realGnode) st++;

            for(int i=st;i<=N;i++)
            {
                if(visited[i])continue;
                bfs(i);
            }
        }



        List<Integer> targets=new ArrayList<>();




        int[] answer = {}; // Gnode 번호, 도넛 수 막대 수 ,8자 수
        return answer;
    }

    public void bfs(int node){
        //노드 완전탐색
        // 그래프 타입 분류
        // 그래프 타입 카운트+1
    }
}