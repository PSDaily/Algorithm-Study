package codeTree.hyundai;

import java.util.*;

public class Q6_2 {
    static boolean[] visited,visited2,visited3,visited4;
    static List<Integer>[] graph,reverseGraph;
    static int S,T;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList[n+1];
        reverseGraph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            reverseGraph[y].add(x);
        }
        S = sc.nextInt();
        T = sc.nextInt();

        visited = new boolean[n+1];
        visited2 = new boolean[n+1];
        visited3 = new boolean[n+1];
        visited4 = new boolean[n+1];

        bfs(S,T,graph,visited);
        bfs(T,-1,reverseGraph,visited2);
        bfs(T,S,graph,visited3);
        bfs(S,-1,reverseGraph,visited4);

        int count = 0;
        for(int i=0;i<=n;i++){
            if(i==S || i==T){
                continue;
            }

            if(visited[i] && visited2[i] && visited3[i] && visited4[i]){
                count++;
            }
        }

        System.out.println(count);
    }

    static void bfs(int start, int end, List<Integer>[] graph, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next: graph[cur]){
                if(!visited[next]){
                    visited[next] = true;

                    if(next != end){
                        q.offer(next);
                    }
                }
            }
        }
    }
}