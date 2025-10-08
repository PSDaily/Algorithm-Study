import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem11003 {
	public static void main(String[] args)throws IOException {
		Deque<Pair> dq = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N, L;
		N = Integer.valueOf(tokens.nextToken());
		L = Integer.valueOf(tokens.nextToken());

		StringTokenizer tokens2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			Integer num = Integer.valueOf(tokens2.nextToken());
			if (i >= L) {
				// poll expired elements
				pollExpiredElement(dq, i, L);
			}
			// poll smallerThan elements & offer new element
			offerNewElement(dq, num, i);
			sb.append(dq.peekFirst().value + " ");
		}
		System.out.println(sb);

	}

	private static void pollExpiredElement(Deque<Pair> dq, int i, int L) {
		while (!dq.isEmpty() && dq.peekFirst().idx <= i - L) {
			dq.pollFirst();
		}
	}

	private static void offerNewElement(Deque<Pair> dq, Integer num, int i) {
		while (!dq.isEmpty() && dq.peekLast().value >= num) {
			dq.pollLast();
		}
		dq.offerLast(new Pair(i, num));
	}

	// priority queue -> 시간초과
	public static void solution2(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N, L;
		N = Integer.valueOf(tokens.nextToken());
		L = Integer.valueOf(tokens.nextToken());

		tokens = new StringTokenizer(br.readLine(), " ");

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			Integer num = Integer.valueOf(tokens.nextToken());
			pq.add(new Pair(i, num));
			if (i >= L) {
				while (pq.peek().idx <= i - L) {
					pq.poll();
				}
			}
			sb.append(pq.peek().value + " ");
		}
		System.out.println(sb);
	}

	public static class Pair implements Comparable<Pair> {
		int idx;
		int value;

		public Pair(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}

		@Override
		public int compareTo(Pair o) {
			if(this.value == o.value) return this.idx - o.idx; //ascend
			return this.value - o.value; // ascend
		}
	}
}
