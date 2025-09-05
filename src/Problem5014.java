import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());
        int now = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken()) * -1;

        int[] DF = {up, down};
        boolean[] visited = new boolean[total];
        for (int i = 0; i < total; i++) {
            visited[i] = false;
        }
        visited[now-1] = true;
        int count = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{now, count});

        if (now == goal) {
            bw.write("0");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            count = cur[1] + 1;

            if(cur[0] == goal) {
                visited[cur[0]-1] = true;
                bw.write(Integer.toString(cur[1]));
                break;
            }



            for (int i = 0; i < 2; i++) {
                if (cur[0] + DF[i] <= total && cur[0] + DF[i] > 0 && !visited[cur[0] + DF[i] - 1]) {
                    visited[cur[0] + DF[i] - 1] = true;
                    q.add(new int[]{cur[0] + DF[i], count});

                }
            }
        }

        if(!visited[goal-1]) {
            bw.write("use the stairs");
        }

        bw.flush();
        bw.close();
        br.close();






    }
}