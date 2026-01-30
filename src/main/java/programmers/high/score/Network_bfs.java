package programmers.high.score;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Network_bfs implements HighScoreKit{
	class Solution {
		boolean[] visited;

		public int solution(int n, int[][] computers) {
			int cnt = 0;
			visited = new boolean[computers[0].length];

			for (int i = 0; i < computers[0].length; i++) {
				if (visited[i] == false) {
					cnt++;
					bfs(i, computers);
				}
			}

			return cnt;
		}

		void bfs(int node, int[][] edges) {
			// bfs init
			Queue<Integer> q = new ArrayDeque<>();
			visited[node] = true;
			q.offer(node);

			// bfs while
			while (q.isEmpty() == false) {
				node = q.poll();

				// 이웃 노드 탐색
				for (int neighborNode = 0; neighborNode < edges[node].length; neighborNode++) {
					// not visited & not self
					if (neighborNode == node || visited[neighborNode] || edges[node][neighborNode] == 0) {
						continue;
					}

					visited[neighborNode] = true;
					q.offer(neighborNode);
				}
			}


		}
	}
}
