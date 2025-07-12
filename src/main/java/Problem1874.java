import java.util.Scanner;
import java.util.Stack;

public class Problem1874 {
    // asc
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = sc.nextInt();

        int max = 0;
        int prev = -1;
        for (int i = 0; i < N; i++) {
            int target = sc.nextInt();

            if (i == 0) { // start
                for (int j = 1; j <= target; j++) {
                    if(max<j) max=j;
                    stack.push(j);
                    sb.append("+\n");
                }
                prev = stack.pop();
                sb.append("-\n");
            } else { // progress
                if (target < prev) {
                    while (stack.peek() != target) {
                        stack.pop();
                        sb.append("-\n");
                    }
                    prev = stack.pop();
                    sb.append("-\n");
                } else {
                    if (max > target) {
                        System.out.println("NO");
                        return;
                    }
                    for (int j = max+1; j <= target; j++) {
                        stack.push(j);
                        sb.append("+\n");
                        max = j;
                    }
                    prev = stack.pop();
                    sb.append("-\n");
                }
            }
        }

        System.out.println(sb);

    }
}
