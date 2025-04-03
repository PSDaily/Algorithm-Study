import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Problem1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int queueSize = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int sum = 0;
        int temp = 0;
        int num = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= queueSize; i++) {
            deque.addLast(i);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < count; i++ ) {
            num = Integer.parseInt(st.nextToken());
            temp = 0;

            while (queueSize - i - 1 != deque.size()){
                if (deque.peekFirst() == num) {
                    temp = temp > deque.size()/2 ? deque.size() - temp : temp;
                    sum += temp;
                    deque.removeFirst();
                } else {
                    deque.addFirst(deque.peekLast());
                    deque.removeLast();
                    temp++;
                }
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}