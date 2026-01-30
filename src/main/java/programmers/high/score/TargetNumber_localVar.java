package programmers.high.score;

public class TargetNumber_localVar implements HighScoreKit {
	static class Solution {
		int cnt = 0;

		public int solution1(int[] numbers, int target) {
			return dfsMethod1(numbers, target);
		}

		public int solution2(int[] numbers, int target) {
			return dfsMethod2(numbers, target);
		}

		private int dfsMethod2(int[] numbers, int target) {

			return dfs(0, 0, target, numbers);
		}

		/**
		 * @param idx : 현재까지 고려한 index
		 * @return : idx 포함 그 이상을 고려했을 떄의 조건을 만족시키는 경우의 수
		 */
		int dfs(int sum, int idx, int target, int[] numbers){
			if(idx > numbers.length){
				if (sum == target) {
					return 1;
				} else {
					return 0;
				}
			}
			int nextNumber = numbers[idx + 1];

			return dfs(sum + nextNumber, idx + 1, target, numbers) + dfs(sum - nextNumber, idx + 1, target, numbers);
		}

		private int dfsMethod1(int[] numbers, int target) {
			dfs1(numbers[0], 1 , target, numbers);
			dfs1(-numbers[0], 1, target, numbers);
			return cnt;
		}

		// (+,1), (-,1) start
		// 1 indexed
		void dfs1(int sum, int idx, int target, int[] numbers){
			if(idx == numbers.length){
				cnt = sum ==  target ? cnt + 1 : cnt;
				return;
			}
			int nextNumber = numbers[idx + 1  - 1];
			dfs1(sum + nextNumber, idx + 1, target, numbers);
			dfs1(sum - nextNumber, idx + 1, target, numbers);
		}
	}
}
