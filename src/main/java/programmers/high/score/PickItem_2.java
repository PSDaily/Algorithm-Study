package programmers.high.score;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class PickItem_2 implements HighScoreKit{

	class Solution {
		public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

			int answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2, rectangle);
			return answer;
		}

		// 반환: 최소거리
		int bfs(int x, int y, int targetX, int targetY, int[][] rectangle){
			int[][] map = new int[102][102];

			for (int[] rect : rectangle) {
				int x1 = rect[0]*2;
				int x2 = rect[2]*2;
				int y1 = rect[1]*2;
				int y2 = rect[3]*2;

				for(int i = x1; i <= x2; i++){
					for(int j = y1; j <= y2; j++){
						// 다른 직사각형의 내부는 그냥 내비둠
						if(map[i][j] == 2){
							continue;
						}

						// 경계는 1
						if(i == x1 || i == x2 || j == y1 || j == y2){
							map[i][j] = 1;
						}
						// 내부는 0
						else {
							map[i][j] = 2;
						}
					}
				}
			}

			Set<Node> visitedSet = new HashSet<>();

			// init
			Queue<Node> q = new ArrayDeque<>();
			Node start = new Node(x, y, 0);
			visitedSet.add(start);
			q.offer(start);

			// 탐색
			while(q.isEmpty() == false){
				Node node = q.poll();
				// 목표 좌표면 return;
				if(node.x == targetX && node.y == targetY){
					return node.dist / 2;
				}

				int[] dx = {0, 0, -1, 1};
				int[] dy = {1, -1, 0, 0};

				for(int i = 0; i < 4; i++){
					Node neighbor = new Node(node.x + dx[i], node.y + dy[i], node.dist + 1);

					// 방문 안했고
					if(visitedSet.contains(neighbor)){
						continue;
					}

					// && 이동 가능 좌표면 방문: x, y 좌표가 모든 직사각형 중에서 외부에 있고 && 다른 직사각형 내부에 없다.
					if (map[neighbor.x][neighbor.y] == 1) {
						visitedSet.add(neighbor);
						q.offer(neighbor);
					}
				}

			}

			return -1;
		}

		static class Node{
			int x;
			int y;
			int dist;

			public Node(int x, int y, int dist){
				this.x = x;
				this.y = y;
				this.dist = dist;
			}

			public boolean equals(Object o){
				if(this == o) return true;
				if(!(o instanceof Node)) return false;
				Node node = (Node)o;

				return this.x == node.x && this.y == node.y;
			}

			public int hashCode(){
				return Objects.hash(x, y);
			}

		}
	}
}
