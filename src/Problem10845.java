import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.StringTokenizer;

public class Problem10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        List<Integer> queue = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String execution = st.nextToken();

            switch (execution) {
                case "push":
                    Integer x = Integer.parseInt(st.nextToken());
                    queue.add(x);
                    break;

                case "pop":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        x = queue.get(0);
                        queue.remove(0);
                        bw.write(sb.append(x).append("\n").toString());
                        sb.setLength(0);
                    }
                    break;

                case "size":
                    bw.write(sb.append(queue.size()).append("\n").toString());
                    sb.setLength(0);
                    break;


                case "empty":
                    if (queue.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (!queue.isEmpty()) {
                        bw.write(sb.append(queue.get(0)).append("\n").toString());
                        sb.setLength(0);
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                default:
                    if (!queue.isEmpty()) {
                        bw.write(sb.append(queue.get(queue.size() - 1)).append("\n").toString());
                        sb.setLength(0);
                    } else {
                        bw.write("-1\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();




    }
}