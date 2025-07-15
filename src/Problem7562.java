import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.lang.StringBuilder;

public class Problem7562 {
    static int[] DM = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] DN = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int size;
        int[] now = new int[2];
        int[] goal = new int[2];
        Queue<int[]> q = new LinkedList<>();

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        boolean flag = false;

        for (int i = 0; i < count; i++) {
            size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            now[0] = Integer.parseInt(st.nextToken());
            now[1] = Integer.parseInt(st.nextToken());
            q.add(new int[]{now[0], now[1], 0});

            boolean[][] visited = new boolean[size][size];
            for (int k = 0; k < size; k++) {
                for (int j = 0; j < size; j++) {
                    visited[k][j] = false;
                }
            }

            st = new StringTokenizer(br.readLine());
            goal[0] = Integer.parseInt(st.nextToken());
            goal[1] = Integer.parseInt(st.nextToken());
            visited[goal[0]][goal[1]] = true;

            while (!q.isEmpty()) {
                int[] temp = q.poll();
                if (temp[0] == goal[0] && temp[1] == goal[1]) {
                    sb.append("0\n");
                    break;
                }
                flag = moveKnight(size, temp, q, goal, visited);
                if (flag) {
                    sb.append(temp[2]+1).append("\n");
                    q.clear();
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean moveKnight(int size, int[] knight, Queue<int[]> q, int[] goal, boolean[][] visited){
        int m = knight[0];
        int n = knight[1];
        int count = knight[2];

        for (int i = 0; i < 8; i++) {
            int x = m + DM[i];
            int y = n + DN[i];
            if (x >= 0 && x < size && y >= 0 && y < size && !visited[x][y]) {
                q.add(new int[]{x, y, count+1});
                visited[x][y] = true;
            }

            if (x == goal[0] && y == goal[1]) {
                return true;
            }
        }


        return false;
    }
}