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

            if (target > max) {
                for (int j = max + 1; j <= target; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                max = target;
            }

            if (stack.peek() != target) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);

    }
}
