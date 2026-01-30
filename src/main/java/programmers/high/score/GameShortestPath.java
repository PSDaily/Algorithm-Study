package programmers.high.score;

import java.util.ArrayDeque;
import java.util.Queue;

public class GameShortestPath implements HighScoreKit{
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

		System.out.println(solution.solution(maps));
	}
	static class Solution {
		boolean[][] visited;
		public int solution(int[][] maps) {

			visited = new boolean[maps.length][maps[0].length];
			return bfs(0, 0, maps);
		}

		// 최소거리 반환
		int bfs(int row, int col, int[][] maps){
			int targetRow = maps.length - 1;
			int targetCol = maps[0].length - 1;

			// init
			visited[row][col] = true;
			Queue<Node> q = new ArrayDeque<>();
			q.offer(new Node(row, col, 0));

			// 탐색
			while(q.isEmpty() == false){
				Node node = q.poll();

				// 추가조건: 최종 목적지이면 break;
				if(node.row == targetRow && node.col == targetCol){
					return node.dist;

				}

				// 탐색 대상 좌표 구하기
				// 상하좌우
				int[] dcol = {0, 0, -1, 1};
				int[] drow = {1, -1, 0, 0};

				for(int i = 0; i < 4; i++){
					int newrow = node.row + drow[i];
					int newcol = node.col + dcol[i];

					if(!inRange(newrow, maps.length) || !inRange(newcol, maps[0].length)){
						continue;
					}

					if(maps[newrow][newcol] == 1 && !visited[newrow][newcol]){
						visited[newrow][newcol] = true;
						q.offer(new Node(newrow, newcol, node.dist + 1));
					}
				}
			}

			return -1;

		}

		static class Node{
			int row;
			int col;
			int dist;

			public Node(int a, int b, int dist){
				row = a;
				col = b;
				this.dist = dist;
			}
		}

		boolean inRange(int value, int length){
			if(value < 0 || value >= length){
				return false;
			}

			return true;
		}
	}
}
