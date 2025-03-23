import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class NumberStack {
    int number;
    int index;

    NumberStack(int n, int i) {
        this.number = n;
        this.index = i;
    }
}


public class Problem17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        int [] seq = new int[count];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        Stack<NumberStack> stack = new Stack<>();
        NumberStack temp = new NumberStack(num, 0);
        stack.push(temp);

        for (int i = 1; i < count; i++) {
            num = Integer.parseInt(st.nextToken());
            temp = new NumberStack(num, i);
            while (!stack.isEmpty()) {
                if (stack.peek().number < num) {
                    NumberStack ans = stack.pop();
                    seq[ans.index] = num;
                    sb.setLength(0);
                }

                else {
                    break;
                }
            }

            stack.push(temp);


        }

        while (!stack.isEmpty()) {
            NumberStack ans = stack.pop();
            seq[ans.index] = -1;
        }

        for (int seq1 : seq) {
            bw.write(sb.append(seq1).append(" ").toString());
            sb.setLength(0);
        }

        bw.flush();
        bw.close();
    }
}