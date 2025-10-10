package Baekjoon.codingdodo.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int person1 = Integer.parseInt(st.nextToken());
        int person2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a); // 무방향 그래프일 때 ⭐
        }

        // System.out.println(graph);

        boolean[] visited = new boolean[n+1];

        System.out.println(bfsQueue(person1,person2,visited,graph));
    }

    static int bfsQueue(int start, int end, boolean[] visited, List<List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[visited.length]; // 거리 저장 배열

        queue.add(start); // 시작 노드를 큐에 삽입
        visited[start] = true; // 방문 처리
        distance[start] = 0; // 시작 노드 거리 = 0

        while(!queue.isEmpty()){ // 큐가 빌 때까지 반복
            int node = queue.poll(); // 큐에서 맨 앞 노드 꺼내기
            // System.out.print(node + " "); // 방문 출력

            // 끝점 도달하면 바로 반환
            if (node == end){
                return distance[node];
            }
            for(int next : graph.get(node)){
                if(!visited[next]){ // 아직 방문하지 않은 노드라면
                    visited[next] = true; // 방문 처리
                    distance[next] = distance[node] + 1; // 최단 거리 계산
                    queue.add(next); // 큐에 삽입
                }
            }
        }
        return -1; // 도달할 수 없는 경우
    }
}
