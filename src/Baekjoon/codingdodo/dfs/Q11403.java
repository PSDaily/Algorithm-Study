package Baekjoon.codingdodo.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    graph.get(i).add(j);
                }
            }
        }

        // System.out.println(graph);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                boolean[] visited = new boolean[N];
                System.out.print((dfsRecursive(i,j,visited,graph) ? 1 : 0) + " ");
            }
            if(i!=N-1){
                System.out.println();
            }
        }
    }

    static boolean dfsRecursive(int node,int destination, boolean[] visited, List<List<Integer>> graph){
        visited[node] = true; // 현재 노드 방문 처리
        // System.out.print("'"+node +"'"+ " "); // 방문 출력

        for(int next: graph.get(node)){
            if(next==destination){ // 양수인 경로여야 함 -> 간선 하나 이상은 거쳐야 함.
                return true;
            }
            if(!visited[next]){
                if (dfsRecursive(next, destination, visited, graph)) {
                    return true; // 목적지까지 갔다와서 true 반환 ⭐⭐⭐
                }
            }
        }
        return false;
    }
}
