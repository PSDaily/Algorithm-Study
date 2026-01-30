package programmers.high.score;

public class Network_dfs implements HighScoreKit{
	class Solution {
		boolean[] visited;

		public int solution(int n, int[][] computers) {
			visited = new boolean[computers[0].length];

			int cnt = 0;

			for(int i = 0; i < computers[0].length; i++){
				if(visited[i] == false){
					cnt++;
					dfs(i, computers);
				}
			}


			int answer = cnt;
			return answer;
		}

		// 함수 호출 후 visited
		void dfs(int node, int[][] edges){
			visited[node] = true;

			// 탐색할 곳이 없으면 return
			for(int neighborNode = 0; neighborNode < edges[node].length; neighborNode++){
				if(node == neighborNode || edges[node][neighborNode] == 0){
					continue;
				}

				// 인접 && not visited한 노드 dfs
				if(!visited[neighborNode]){
					dfs(neighborNode, edges);
				}
			}
		}
	}
}
