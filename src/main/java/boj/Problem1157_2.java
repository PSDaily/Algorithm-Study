package boj;// input: string
// output: 가장 많이 사용된 알파벳 대문자(단, 2개 이상일 경우에는 ?)

import java.util.Scanner;

public class Problem1157_2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next().toUpperCase();


		// when
		// alphabet 개수: 26개
		int[] count = new int['z' - 'a' + 1];

		// calculate frequency
		for(int i = 0; i < s.length(); i++){
			Character c = s.charAt(i);
			count[c - 'A']++;
		}

		// get Max Frequency
		int max = 0;
		char result = '0';
		for (int i = 0; i < count.length; i++) {
			if (max < count[i]) {
				max = count[i];
				result = (char)('A' + i);
			} else if (max == count[i]) {
				result = '?';
			}
		}

		System.out.println(result);

	}
}