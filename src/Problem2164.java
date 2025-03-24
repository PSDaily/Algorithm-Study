import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<Integer>();

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            queue.add(i+1);
        }

        while (queue.size() > 1) {
            int a = queue.remove();
            queue.add(queue.remove());
        }
        bw.write(String.valueOf(queue.remove()));
        bw.flush();
        bw.close();
    }
}