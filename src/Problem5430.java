import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.StringBuilder;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Problem5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int dequeSize = 0;
        boolean is_reverse;
        boolean is_error;
        String executions = "";
        char execution = ' ';
        String input = "";
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {
            is_reverse = false;
            is_error = false;
            executions = br.readLine();
            dequeSize = Integer.parseInt(br.readLine());

            input = br.readLine();
            st = new StringTokenizer(input.substring(1, input.length() - 1), ",");

            for (int j = 0; j < dequeSize; j++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < executions.length(); j++) {
                execution = executions.charAt(j);

                if (execution == 'R'){
                    is_reverse = !is_reverse;
                }

                else {
                    if (deque.isEmpty()) {
                        is_error = true;
                        break;
                    }

                    if (is_reverse) {
                        deque.removeLast();
                    }
                    else {
                        deque.removeFirst();
                    }
                }
            }

            if (is_error) {
                bw.write("error\n");
            }

            else if (deque.isEmpty()) {
                bw.write("[]\n");
            }

            else {
                if (is_reverse) {
                    sb.append("[");
                    while (deque.size() > 1) {
                        sb.append(deque.removeLast()).append(",");
                    }
                    sb.append(deque.removeLast()).append("]").append("\n");
                    bw.write(sb.toString());
                    sb.setLength(0);
                }
                else {
                    sb.append("[");
                    while (deque.size() > 1) {
                        sb.append(deque.removeFirst()).append(",");
                    }
                    sb.append(deque.removeFirst()).append("]").append("\n");
                    bw.write(sb.toString());
                    sb.setLength(0);
                }

            }

            deque.clear();
        }

        bw.flush();
        bw.close();

    }
}