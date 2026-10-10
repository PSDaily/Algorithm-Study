package codeTree.hyundai;

import java.util.*;

public class Q8_1 {
    static int max;
    static Queue<int[]> q;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[] maxDistance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        int[] startPoints = new int[k];
        for (int i = 0; i < k; i++) {
            startPoints[i] = sc.nextInt();
        }

        // edges -> graph로 바꾸기
        graph = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
        }

        maxDistance = new int[n+1];

        for(int s : startPoints){
            //System.out.println("s="+s);
            q = new LinkedList<>();
            visited = new boolean[n+1];
            visited[s] = true;
            q.offer(new int[]{s,0});

            bfs();
        }

        int min = Integer.MAX_VALUE;
        for(int f=1;f<=n;f++){
            if(maxDistance[f] != -1){
                min = Math.min(min,maxDistance[f]);
            }
        }

        if(min == Integer.MAX_VALUE){
            min = -1;
        }

        System.out.println(min);
    }

    static void bfs(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int node = cur[0];
            int dis = cur[1];

            // 해당 전시장까지 최대 최단거리 갱신
            if (maxDistance[node] != -1) {
                maxDistance[node] = Math.max(maxDistance[node], dis);
            }

            for(int next: graph[node]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,dis+1});
                }
            }
        }

        // 도달하지 못한 전시장 제외
        for (int i = 1; i < maxDistance.length; i++) {
            if (!visited[i]) {
                maxDistance[i] = -1;
            }
        }
    }
}