import java.util.*;
import java.io.*;

public class Problem1707 {
    static int K;
    static int V, E;
    static int[] team; // 0 or 1
    static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        K = Integer.valueOf(br.readLine());
        int k = K;
        // TestCase 반복
        while (k-- > 0) {
            StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
            V = Integer.valueOf(tokens.nextToken());
            E = Integer.valueOf(tokens.nextToken());

            adjList = new ArrayList<>();
            for (int i = 0; i < V + 1; i++) {
                adjList.add(new ArrayList<>());
            }
            team = new int[V + 1];
            visited = new boolean[V + 1];
            Arrays.fill(team, -1);

            // get edge
            for (int i = 0; i < E; i++) {
                StringTokenizer tokens2 = new StringTokenizer(br.readLine(), " ");
                int u = Integer.valueOf(tokens2.nextToken());
                int v = Integer.valueOf(tokens2.nextToken());

                adjList.get(u).add(v);
                adjList.get(v).add(u);
//                if(!adjList.get(u).contains(v)) adjList.get(u).add(v);
//                if(!adjList.get(v).contains(u)) adjList.get(v).add(u);

            }


            //when
            // graph의 모든 컴포넌트 조사
            boolean isBipartite = true;
            for (int i = 1; i <= V; i++) {
                if (!visited[i] && !componentBfsIsBipartite(i, sb)) {
                    sb.append("NO\n");
                    isBipartite = false;
                    break;
                }
            }
            if(isBipartite) sb.append("YES\n");
        }
        System.out.print(sb.toString());

    }

    //시간복잡도
    // 모든 각 정점에 대해서, 인접한 정점들을 모두 조사
    // 인접 리스트: V+2E
    static boolean componentBfsIsBipartite(int stVertex, StringBuilder sb) {

        Queue<Integer> q = new LinkedList<>();

        // init
        q.offer(stVertex);
        visited[stVertex] = true;
        team[stVertex] = 0;

        // 탐색
        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adjList.get(u)) {
                // v가 팀이 무소속인경우
                if (!visited[v]) {
                    team[v] = getOppositeTeam(team[u]);
                    visited[v]=true;
                    q.offer(v);
                } else {
                    if (team[u] == team[v]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static int getOppositeTeam(int team) {
        return team == 0 ? 1 : 0;
    }
}
