// type: greedy + sort
// data structure: List
// t-complexity: NlogN + N
// edge case
// 가장 작은 수의 개수가 1
// 					-> 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());
		String[] strArr = br.readLine().split(" ");
		List<Integer> numbers = new ArrayList<>();

		for(int i = 0; i < strArr.length; i++){
			numbers.add(Integer.valueOf(strArr[i]));
		}

		// when
		numbers.sort(Comparator.comparingInt(k -> k));

		int[] prefixSum = new int[numbers.size() + 1];	// 1 indexed
		int result = 0;
		prefixSum[0] = 0;
		for(int i = 0; i < numbers.size(); i++){
			prefixSum[i + 1] = numbers.get(i) + prefixSum[i];
			result += prefixSum[i+1];
		}

		System.out.print(result);

	}
}