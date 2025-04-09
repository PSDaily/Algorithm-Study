import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        char ch = ' ';
        int temp = 0;
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        Stack<Integer> num = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            ch = line.charAt(i);

            if (ch == '(' || ch == '[') {
                stack.push(ch);
            }

            else if (ch == ')') {
                if (!stack.isEmpty() || stack.peek() == '(') {
                    stack.pop();
                    if (!stack.isEmpty() && stack.peek() == 'x') {
                        temp = num.pop() + 2;
                        num.push(temp);
                    }

                    else {
                        stack.push('x');
                        num.push(2);
                    }
                }
                else if (!stack.isEmpty() && stack.peek() == 'x') {
                    stack.pop();
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        stack.push('x');
                        temp = num.pop() * 2;
                        num.push(temp);
                    }
                    else {
                        bw.write("0");
                        flag = true;
                        break;
                    }
                }
                else {
                    bw.write("0");
                    flag = true;
                    break;
                }
            }

            else {
                if (!stack.isEmpty() || stack.peek() == '[') {
                    stack.pop();
                    if (!stack.isEmpty() && stack.peek() == 'x') {
                        temp = num.pop() + 3;
                        num.push(temp);
                    }

                    else {
                        stack.push('x');
                        num.push(3);
                    }
                }
                else if (!stack.isEmpty() && stack.peek() == 'x') {
                    stack.pop();
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                        stack.push('x');
                        temp = num.pop() * 3;
                        num.push(temp);
                    }
                    else {
                        bw.write("0");
                        flag = true;
                        break;
                    }
                }
                else {
                    bw.write("0");
                    flag = true;
                    break;
                }
            }
        }
        System.out.println(num);

        if (stack.isEmpty() && !flag) {

        }
        else {
            bw.write("0");
        }

        bw.flush();
        bw.close();

    }
}