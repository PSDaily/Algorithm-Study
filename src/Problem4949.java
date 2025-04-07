import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Problem4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Stack<Character> stack = new Stack<>();
        boolean flag = false;

        ArrayList<Character> comparison = new ArrayList<>();
        comparison.add('(');
        comparison.add(')');
        comparison.add('[');
        comparison.add(']');

        String sentence;

        while(true) {
            stack.clear();
            sentence = br.readLine();
            if (sentence.equals(".")) break;
            flag = false;
            st = new StringTokenizer(sentence, "()[].", true);
            String word = st.nextToken();
            char ch = word.charAt(0);

            while (ch != '.' && flag == false){
                if (ch == '(' || ch == '['){
                    stack.push(ch);
                }
                else if (ch == ')'){
                    if (!stack.isEmpty() && stack.peek() == '(' ){
                        stack.pop();
                    }
                    else{
                        bw.write("no\n");
                        flag = true;
                        break;
                    }
                }
                else if (ch == ']'){
                    if (!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }
                    else{
                        bw.write("no\n");
                        flag = true;
                        break;
                    }
                }

                word = st.nextToken();
                ch = word.charAt(0);

            }

            if (stack.isEmpty() && !flag){
                bw.write("yes\n");
            }
            else if(!stack.isEmpty() && !flag){
                bw.write("no\n");
            }

        }


        bw.flush();
        bw.close();
    }
}