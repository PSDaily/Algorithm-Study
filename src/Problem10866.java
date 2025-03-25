import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Problem10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();


        StringBuilder sb = new StringBuilder();

        String execution;

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            execution = st.nextToken();

            switch (execution) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(sb.append(deque.removeFirst()).append('\n').toString());
                        sb.setLength(0);
                    }
                    break;

                case "pop_back":
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(sb.append((deque.removeLast())).append('\n').toString());
                        sb.setLength(0);
                    }
                    break;

                case "size":
                    bw.write(sb.append(deque.size()).append("\n").toString());
                    sb.setLength(0);
                    break;

                case "empty":
                    if (deque.isEmpty()) {
                        bw.write("1\n");
                    }
                    else {
                        bw.write("0\n");
                    }
                    break;

                case "front":
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(sb.append(deque.peekFirst()).append("\n").toString());
                        sb.setLength(0);
                    }
                    break;

                default:
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(sb.append(deque.peekLast()).append("\n").toString());
                        sb.setLength(0);
                    }
                    break;
            }

        }
        bw.flush();
        bw.close();
    }
}