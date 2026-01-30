package boj;// N: 숫자 개수, M: 구간합 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem11659_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
		int n = Integer.valueOf(tokens.nextToken());
		int m = Integer.valueOf(tokens.nextToken());

		// when
		// make number array
		int[] numArr = new int[n + 1];

		StringTokenizer tokens2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < n + 1; i++) {
			numArr[i] = Integer.valueOf(tokens2.nextToken());
		}

		// make 누적합
		List<Integer> prefixSum = new ArrayList<>();
		prefixSum.add(0);
		for(int i = 1; i < n + 1; i++){
			int newPrefix = prefixSum.get(i - 1) + numArr[i];
			prefixSum.add(newPrefix);
		}

		StringBuilder sb = new StringBuilder();
		while(m-- > 0){
			String interval = br.readLine();
			String[] splitInterval = interval.split(" ");
			int start = Integer.valueOf(splitInterval[0]);
			int end = Integer.valueOf(splitInterval[1]);

			int answer = prefixSum.get(end) - prefixSum.get(start - 1);
			sb.append(answer + "\n");
		}



		System.out.println(sb);

	}
}