package Baekjoon.codingdodo.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    void bfsQueue(int start, boolean[] visited, List<List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[visited.length]; // 거리 저장 배열
        queue.add(start); // 시작 노드를 큐에 삽입
        visited[start] = true; // 방문 처리
        distance[start] = 0; // 시작 노드 거리 = 0

        while(!queue.isEmpty()){ // 큐가 빌 때까지 반복
            int node = queue.poll(); // 큐에서 맨 앞 노드 꺼내기
            System.out.print(node + " "); // 방문 출력

            for(int next : graph.get(node)){
                if(!visited[next]){ // 아직 방문하지 않은 노드라면
                    visited[next] = true; // 방문 처리
                    distance[next] = distance[node] + 1; // 최단 거리 계산
                    queue.add(next); // 큐에 삽입
                }
            }
        }
    }
}
