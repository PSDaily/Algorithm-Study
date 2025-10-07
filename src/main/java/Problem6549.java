import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // Testcase
        while (true) {
            // given
            StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
            Integer T = Integer.valueOf(tokens.nextToken());
            if(T==0) break;

            // when
            Stack<Pair> stk = new Stack<>();
            Long max = 0L;
            for (int i = 0; i < T; i++) {
                Long num = Long.valueOf(tokens.nextToken());
                if (stk.isEmpty()) {
                    stk.push(new Pair(i, num));
                } else {
                    if (num > stk.peek().value) {
                        stk.push(new Pair(i, num));
                    } else if (num <= stk.peek().value) {
                        while (!(stk.isEmpty() || stk.peek().value < num)) {
                            Pair needToCalculated = stk.pop();
                            int width;
                            if (stk.isEmpty()) {
                                width = i;
                            } else {
                                width = i - 1 - (stk.peek().idx); //
                            }
                            Long area = width * needToCalculated.value;
                            max = max < area ? area : max;
                        }
                        stk.push(new Pair(i, num));
                    }
                }
            }
            while (stk.size() > 0) {
                Pair needToCalculated = stk.pop();
                int width;
                if (stk.isEmpty()) {
                    width = T;
                } else {
                    width = (T - 1) - stk.peek().idx;
                }
                Long area = width * needToCalculated.value;
                max = max < area ? area : max;
            }
            sb.append(max + "\n");
        }
        System.out.println(sb);
    }

    static class Pair {
        int idx;
        Long value;

        Pair(int idx, Long value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
