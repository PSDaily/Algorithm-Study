package boj;// input: string
// output: 가장 많이 사용된 알파벳 대문자(단, 2개 이상일 경우에는 ?)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem1157 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();


		// when
		Map<Character, Integer> fMap = new HashMap<>();

		// calculate frequency
		for(int i = 0; i < s.length(); i++){
			Character c = s.charAt(i);
			if (c > 'Z') {
				c = (char)((int)c - ('a' - 'A'));
			}
			fMap.put(c, fMap.getOrDefault(c, 0) + 1);
		}

		// get Max Frequency
		int max = 0;
		List<Character> resultList = new ArrayList<>();

		for (Map.Entry<Character, Integer> entry : fMap.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				resultList.clear();
				resultList.add(entry.getKey());
			}else if(entry.getValue() == max){
				resultList.add(entry.getKey());
			}
		}

		char result = '0';
		if (resultList.size() > 1) {
			result = '?';
		}else{
			result = resultList.get(0);
		}

		System.out.println(result);
	}
}