package programmers.high.score;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * type: 가장 짧은 경로 - 완전 탐색[BFS]
 * DS: queue
 *
 */
public class VocaTransformation implements HighScoreKit{

	class Solution {

		public int solution(String begin, String target, String[] words) {
			int answer = bfs(begin, target, words);
			return answer;
		}

		int bfs(String startNode, String target, String[] words){
			Set<String> visited = new HashSet<>();
			visited.add(startNode);

			Queue<Node> q = new ArrayDeque<>();
			q.offer(new Node(startNode, 0));

			while(q.isEmpty() == false){
				Node node = q.poll();

				// optional cond
				if(node.value.equals(target)){
					return node.dist;
				}

				// 탐색
				for(String word: words){
					if(visited.contains(word) == false && isOneDiff(node.value, word)){
						visited.add(word);
						q.offer(new Node(word, node.dist + 1));
					}
				}
			}

			return 0;
		}

		static class Node{
			String value;
			int dist;

			public Node(String v, int d){
				this.value = v;
				this.dist = d;
			}
		}

		boolean isOneDiff(String s1, String s2){
			// one alphabet 차이면 true

			int diffCnt = 0;

			for(int i = 0; i < s1.length(); i++){
				char c1 = s1.charAt(i);
				char c2 = s2.charAt(i);

				if(c1 != c2){
					diffCnt++;
				}
			}
			System.out.print(String.format("String s1: %s String s2: %s difference Count: %d", s1, s2, diffCnt));
			return diffCnt == 1 ? true : false;

		}
	}
}
