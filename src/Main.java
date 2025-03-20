import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int maxNum = Integer.parseInt(br.readLine());
        int index = 0;
        int count = 0;
        Stack<Integer> stack = new Stack<Integer>();
        List<String> results = new ArrayList<String>();

        while (count < maxNum) {
            int inputNum = Integer.parseInt(br.readLine());
            count++;


            if (inputNum > index) {
                for (int i = index+1; i <= inputNum; i++) {
                    stack.push(i);
                    results.add("+\n");
                }

                index = inputNum;
                stack.pop();
                results.add("-\n");
            }

            else {
                if(stack.contains(inputNum)) {
                    int temp;
                    do{
                        temp = stack.pop();
                        results.add("-\n");
                    } while(temp != inputNum);
                }

                else {
                    bw.write("NO\n");
                    results.removeAll(results);
                    break;
                }
            }




        }

        for (String result : results) {
            bw.write(result);
        }


        bw.flush();
        bw.close();
    }
}

