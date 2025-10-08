import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem10866 {
	public static void main(String[] args)throws IOException {
		Deque<Integer> dq = new ArrayDeque<>();
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.valueOf(br.readLine());
		while (N-- > 0) {
			StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
			String op = tokens.nextToken();
			Integer num;
			switch (op) {
				case "push_front":
					num = Integer.valueOf(tokens.nextToken());
					dq.offerFirst(num);
					break;
				case "push_back":
					num = Integer.valueOf(tokens.nextToken());
					dq.offerLast(num);
					break;
				case "pop_front":
					if (dq.isEmpty()) {
						sb.append("-1\n");
					} else {
						sb.append(dq.pollFirst()+"\n");
					}
					break;
				case "pop_back":
					if (dq.isEmpty()) {
						sb.append("-1\n");
					}else {
						sb.append(dq.pollLast()+"\n");
					}
					break;
				case "size":
					sb.append(dq.size()+"\n");
					break;
				case "empty":
					sb.append((dq.isEmpty()?"1":"0")+"\n");
					break;
				case "front":
					if (dq.isEmpty()) {
						sb.append("-1\n");
					}else {
						sb.append(dq.peekFirst()+"\n");
					}
					break;
				case "back":
					if (dq.isEmpty()) {
						sb.append("-1\n");
					}else {
						sb.append(dq.peekLast()+"\n");
					}
					break;
			}
		}
		System.out.println(sb);
	}
}
