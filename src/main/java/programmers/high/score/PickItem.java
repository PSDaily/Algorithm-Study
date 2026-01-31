package programmers.high.score;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class PickItem implements HighScoreKit{

	class Solution {
		public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {



			int answer = bfs(characterX, characterY, itemX, itemY, rectangle);
			return answer;
		}

		// 반환: 최소거리
		int bfs(int x, int y, int targetX, int targetY, int[][] rectangle){
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
					return node.dist;
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
					if(couldMove(neighbor, rectangle, node)){
						visitedSet.add(neighbor);
						q.offer(neighbor);
					}
				}

			}

			return -1;
		}

		// x, y 좌표가 모든 직사각형 중에서 경계에 있는게 존재 && 다른 직사각형 내부에 없다.
		// && 두 좌표간 중점이 소속된 직사각형의 경계에 있는게 존재
		boolean couldMove(Node neighbor, int[][] rectangles, Node from){
			// 직사각형 순회
			boolean isOutside = false;
			boolean isInside = false;
			boolean isLineOutside = false;
			boolean isMidInside = false;
			double midX = (neighbor.x + from.x)/2.0;
			double midY = (neighbor.y + from.y)/2.0;
			for(int[] rectangle : rectangles){
				int x1 = rectangle[0];
				int x2 = rectangle[2];
				int y1 = rectangle[1];
				int y2 = rectangle[3];


				if(
					(neighbor.x == x1 && neighbor.y >= y1 && neighbor.y <= y2) ||
						(neighbor.x == x2 && neighbor.y >= y1 && neighbor.y <= y2) ||
						(neighbor.y == y1 && neighbor.x >= x1 && neighbor.x <= x2) ||
						(neighbor.y == y2 && neighbor.x >= x1 && neighbor.x <= x2)
				){
					isOutside = true;
					if(neighbor.x == from.x && (neighbor.x == x1 || neighbor.x == x2)){
						isLineOutside = true;
					}else if(neighbor.y == from.y && (neighbor.y == y1 || neighbor.y == y2)){
						isLineOutside = true;
					}
				}

				//-------------------

				if((neighbor.x > x1 && neighbor.x < x2 )&& (neighbor.y > y1 && neighbor.y < y2))
				{
					isInside = true;
				}

				if((midX > (double)x1 && midX < (double)x2 )&& (midY > (double)y1 && midY < (double)y2))
				{
					isMidInside = true;
				}


			}

			if(isOutside && isLineOutside && !isInside && !isMidInside){
				return true;
			}else {
				return false;
			}

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
