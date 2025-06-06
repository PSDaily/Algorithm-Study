import java.util.*;
import java.io.*;

class ProblemKakaoWinterInternship2 {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2},
                {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10},
                {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}
        };
        int[] result = solution(edges);
        System.out.println(Arrays.toString(result));

        /*
        * int[][] array = {
    {4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2},
    {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10},
    {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}
};

        * */
    }

    public static int[] solution(int[][] edges) {
         List<List<Integer>> adjList = new ArrayList<>( );
         Set<Integer> vertices = new HashSet<>();

        //given
//        int max=0;

        int[] result=new int[4];

        for(int[] row: edges)
            for (int col : row) {
                vertices.add(col);
            }
        // get numNode
        int N = vertices.size();
        for(int i=0;i<=N;i++)
            adjList.add(new ArrayList<>());
        // init adjList
        List<Integer> temp = new ArrayList<>(vertices);
        temp.add(-1);
        Collections.sort(temp);

        for(int[] row: edges)
        {
            adjList.get(Collections.binarySearch(temp, row[0])).add(Collections.binarySearch(temp, row[1]));
        }



        /*
        타입1
        incoming edge == outgoing edge == 1

        type2
        incoming edge =0 or outgoing edge=0인 node exists

        type3
        incoming edge == outgoing edge == 1초과 node exists

        Gnode
        incoming edge ==0 & outgoing edge의 수가 1이상임
        */

        // calculate incoming, outgoing edge
        int[][] edgeStatus=new int[N+1][2]; //0: incoming, 1: outgoing
        for(int[] row: edges)
        {
            int from = Collections.binarySearch(temp, row[0]);
            int to = Collections.binarySearch(temp, row[1]);

            edgeStatus[from][1]++;
            edgeStatus[to][0]++;
        }
        // find Gnode
        int gnode=0;
        for(int i=1;i<=N;i++)
        {
            if(edgeStatus[i][0]!=0) continue;
            if(edgeStatus[i][1]>1)
            {
                gnode=i;
                break;
            }
      /*      // 해당 노드로부터 탐색시작했을 때 모든 노드가 방문되어야함
            boolean[] visited=new boolean[N+1];
            boolean isGnode=true;
            bfs2(i, visited);
            for(int j=1;j<=N;j++)
            {
                if(!visited[j])
                {
                    isGnode=false;
                    break;
                }
            }
            if(!isGnode)continue;
            gnode=i;*/
        }

        boolean[] isVisited2=new boolean[N+1];
        isVisited2[gnode]=true;

        boolean[] isChild=new boolean[N+1];
        for (int child : adjList.get(gnode)) {
            isChild[child]=true;
        }
        // 1. 막대 그래프 먼저 탐색
        for(int i=1;i<=N;i++)
        {
            if(i==gnode)continue;
            if (edgeStatus[i][0] == 0) {
                bfs(i, isVisited2, result, edgeStatus,adjList);
            } else if (edgeStatus[i][0]==1 && isChild[i]) {
                bfs(i, isVisited2, result, edgeStatus,adjList);
            }
        }
        // 2. 나머지 그래프 탐색
        for(int i=1;i<=N;i++)
        {
               /*
        타입1
        incoming edge == outgoing edge == 1

        type2
        incoming edge =0 or outgoing edge=0인 node exists

        type3
        incoming edge == outgoing edge == 1초과 node exists

        Gnode
        incoming edge ==0 & outgoing edge의 수가 1이상임
        */
            if(i==gnode) continue;
            if(isVisited2[i]) continue;
            bfs(i, isVisited2, result, edgeStatus,adjList);


        }



        //!! 이떄 제출할 gnode는 압축된 gnode를 제공하면 안됨
        int[] answer = {temp.get(gnode), result[1],result[2], result[3]}; // Gnode 번호, 도넛 수, 막대 수 ,8자 수
        return answer;
    }

    public static void bfs(int st, boolean[] isVisited, int[] result,int[][] edgeStatus, List<List<Integer>> adjList ){
        //init
        isVisited[st]=true;
        Queue<Integer> q= new ArrayDeque<>();
        q.offer(st);
        int type=-1;

        while(!q.isEmpty())
        {
            // 방문한 노드의 incoming, outgoing edge의 개수를 비교하여 결정노드라면 타입판별
            int from=q.poll();
            if(edgeStatus[from][1]==0) type=2;
            if(edgeStatus[from][1]>1) type=3;

            //search
            for(int i=0;i<adjList.get(from).size(); i++)
            {
                int target=adjList.get(from).get(i);
                if(!isVisited[target])
                {
                    isVisited[target]=true;
                    q.offer(target);
                }
            }
        }

        if(type==-1) type=1;
        result[type]++;
    }
    public static void bfs2(int st, boolean[] isVisited, List<List<Integer>> adjList){
        //init
        isVisited[st]=true;
        Queue<Integer> q= new LinkedList<>();
        q.offer(st);

        while(!q.isEmpty())
        {
            int from=q.poll();
            //search
            for(int i=0;i<adjList.get(from).size(); i++)
            {
                int target=adjList.get(from).get(i);
                if(!isVisited[target])
                {
                    isVisited[target]=true;
                    q.offer(target);
                }
            }
        }
    }
}