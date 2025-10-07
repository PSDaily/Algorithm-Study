package Baekjoon.codingdodo.dfs;

import java.util.ArrayList;
import java.util.List;

public class dfsPractice {
    public static void main(String[] args) {
        // 그래프 크기(정점 개수)
        int n = 5;

        // 인접 리스트 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 추가(양방향 그래프)
        graph.get(1).add(2);
        graph.get(1).add(4);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);
        graph.get(4).add(1);
        graph.get(4).add(5);
        graph.get(5).add(4);

        // 방문 배열
        boolean[] visited = new boolean[n+1];

        // DFS 실행
        DFS dfs = new DFS();
        System.out.println("DFS 탐색 결과: ");
        //dfs.dfsStack(1,visited,graph);
        dfs.dfsStack(1,visited,graph);
        // dfs.dfsRecursive(1,visited,graph);
    }
}
