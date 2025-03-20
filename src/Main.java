import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
    int index;
    int num;

    Top(int index, int num) {
        this.index = index;
        this.num = num;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Top> stack = new Stack<>();

        int num = 0;

        for (int i = 1; i <= count; i++) {
            num = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                bw.write("0 ");
                stack.push(new Top(i, num));
            }
            else {
                while (true) {
                    if (stack.isEmpty()) {
                        bw.write("0 ");
                        stack.push(new Top(i, num));
                        break;
                    }

                    Top top = stack.peek();

                    if (top.num > num) {
                        bw.write(top.index + " ");
                        stack.push(new Top(i, num));
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
            }
        }

        bw.flush();
        bw.flush();
    }
}

