// type: back tracking maybe
// Data Structure: array []
// t-complex
// edge case
// (문자열 길이, 알파벳 순서)
// 비연속도 가능
// 방향은 단방향

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String s1 = bufferedReader.readLine();
		String s2 = bufferedReader.readLine();

		int[][] dp = new int[s1.length() + 1][s2.length() + 1]; // 1 indexed

		dp[1][1] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;

		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println(dp[s1.length()][s2.length()]);
	}
}
