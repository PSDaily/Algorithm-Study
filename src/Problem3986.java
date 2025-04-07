import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int sum = 0;
        int index = 0;
        char ch;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            stack.clear();
            index = 0;
            String word = br.readLine();

            while (index < word.length()) {
                ch = word.charAt(index++);

                if (stack.isEmpty() || stack.peek() != ch) {
                    stack.push(ch);
                }
                else {
                    stack.pop();
                }
            }

            if(stack.isEmpty()) {
                sum++;
            }

        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}