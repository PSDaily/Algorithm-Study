package boj;// type: 괄호쌍
// data structure: stack
// t-complexity: O(N)
// edge case
// (순서, 개수)
// 개수 맞는 경우
// 순서 다른경우
// )(
// 순서 맞는 경우

// 개수 다른 경우
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Problem9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());

		StringBuilder sb = new StringBuilder();
		while(t-- > 0){
			String str = br.readLine();
			Deque<Character> stack = new ArrayDeque<Character>();

			boolean isValid = true;
			for(int i = 0; i < str.length(); i++) {
				char p = str.charAt(i);

				if(p == '('){
					stack.push(p);
				}else if (p == ')'){

					if(!stack.isEmpty() && stack.peek() == '('){
						stack.pop();
					} else {
						isValid = false;
						break;
					}

				}
			}
			if(stack.size() != 0) isValid = false;

			if(isValid){
				sb.append("YES\n");
			} else{
				sb.append("NO\n");
			}


		}

		System.out.print(sb);
	}
}