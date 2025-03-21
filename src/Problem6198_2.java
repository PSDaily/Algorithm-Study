import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem6198_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        long sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            int height = Integer.parseInt(br.readLine());

            // 스택 내림차순으로 만들기
            while (!stack.isEmpty()) {
                if (stack.peek() <= height) {
                    stack.pop();
                }
                else break;
            }


            sum += stack.size();

            stack.push(height);
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}