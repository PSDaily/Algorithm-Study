package Baekjoon.codingdodo.dfs;

import java.util.List;
import java.util.Stack;

public class DFS {
    void dfsStack(int start, boolean[] visited, List<List<Integer>> graph){
        Stack<Integer> stack = new Stack<>();
        stack.push(start); // 시작 노드를 스택에 넣음

        while(!stack.isEmpty()){ // 스택이 비워질 때까지 반복
            int node = stack.pop(); // 스택에서 맨 위 정점 가져오기
            if (!visited[node]){ // 방문하지 않은 정점
                visited[node] = true; // 방문 처리
                System.out.print(node + " "); // 방문 출력

                for(int next: graph.get(node)){
                    if(!visited[next]){
                        stack.push(next); // 나중에 방문할 노드를 스택에 넣기
                    }
                }
            }
        }
    }

    void dfsRecursive(int node, boolean[] visited, List<List<Integer>> graph){
        visited[node] = true; // 현재 노드 방문 처리
        System.out.print(node + " "); // 방문 출력

        for(int next: graph.get(node)){
            if(!visited[next]){
                dfsRecursive(next, visited, graph); // 재귀 호출
            }
        }
    }

}
