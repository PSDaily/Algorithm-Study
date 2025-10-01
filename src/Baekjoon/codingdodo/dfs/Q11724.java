package Baekjoon.codingdodo.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a); // 무방향 그래프일 때 ⭐⭐🌠🌠🌠
        }

        System.out.println(graph);
        boolean[] visited = new boolean[N+1];

        int connect = 0;
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                // System.out.println(i + "부터 시작한 DFS 탐색 결과: ");
                dfsRecursive(i,visited,graph);
                // System.out.println();
                connect++;
            }
        }

        // System.out.println();
        // System.out.println("연결 노드 수: ");
        System.out.print(connect);
    }

    static void dfsRecursive(int node, boolean[] visited, List<List<Integer>> graph){
        visited[node] = true; // 현재 노드 방문 처리
        // System.out.print(node + " "); // 방문 출력

        for(int next: graph.get(node)){
            if(!visited[next]){
                dfsRecursive(next, visited, graph); // 재귀 호출
            }
        }
    }
}
