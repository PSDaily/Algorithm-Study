package programmers.high.score;

/**
 * 클래스변수를 두고 dfs가 참조하는 방식
 * 문제점
 * - dfs 재사용 불가
 * - dfs만 테스트 어려움
 * - 실제 운영에선 클래스변수니까 사이드 이펙트 가능
 *
 * 장점
 * - 공간 복잡도 이득본다.
 */
public class TargetNumber implements HighScoreKit {
	static class Solution {
		int cnt = 0;
		int length;
		int gTarget;
		int[] gNumbers;

		public int solution(int[] numbers, int target) {
			gTarget = target;
			gNumbers = numbers;
			length = numbers.length;

			dfs(numbers[0], 1);
			dfs(-numbers[0], 1);


			int answer = cnt;
			return answer;
		}

		// (+,1), (-,1) start
		// 1 indexed
		void dfs(int value, int idx){
			if(idx == length){
				cnt = value ==  gTarget ? cnt + 1 : cnt;
				return;
			}
			int nextNumber = gNumbers[idx + 1  - 1];
			dfs(value + nextNumber, idx + 1);
			dfs(value - nextNumber, idx + 1);
		}
	}
}
