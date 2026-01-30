package boj;// type: back tracking maybe
// Data Structure: array []
// t-complex
// edge case
// ( )
// 비연속도 가능
// 방향은 단방향

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem9251 {
	static List<Character> sub = new ArrayList<>();
	static int[] s2AlphabetArr = new int['z' - 'a' + 1];
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();

		dfs(s1, s2);

		System.out.println(max);
	}

	/**
	 * GBHAIG
	 * DJBAFK
	 */
	static void dfs(String s1, String s2) {
		char alphabet = s1.charAt(0);

		int s2Idx = s2.indexOf(alphabet);
		if (s2Idx < 0) { // s2 not contained
			if (s1.length() == 1) {
				return;
			}
			dfs(s1.substring(1), s2);
			return;
		} else {            // s2 contained
			sub.add(alphabet);
			max = max < sub.size() ? sub.size() : max;

			for (int i = 1; i < s1.length(); i++) {
				if (s1.length() - 1 - i < 0 || s2.length() - 1 - (s2Idx + 1) < 0) {
					continue;
				} else {
					dfs(s1.substring(i), s2.substring(s2Idx + 1));
				}

			}
			sub.remove(sub.size() - 1);
		}

	}

}
