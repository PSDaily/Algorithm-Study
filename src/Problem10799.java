import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        char ch;
        Character temp = null;
        int sum = 0;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            }
            else {
                if (stack.peek() == '(' && temp != ')') {
                    stack.pop();
                    sum += stack.size();
                }
                else {
                    stack.pop();
                    sum++;
                }
            }

            temp = ch;


        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();

    }
}