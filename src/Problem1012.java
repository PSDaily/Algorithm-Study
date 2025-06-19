import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Problem1012 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int count = Integer.parseInt(br.readLine());

        int m;
        int n;
        int k;

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());


            int c = countBug(m, n , k, br, st);

            sb.setLength(0);

            sb.append(c).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }

    public static int countBug(int m, int n, int k, BufferedReader br, StringTokenizer st) throws IOException {
        boolean[][] visited = new boolean[m][n];
        int x, y, count;
        int[] DM = {1, 0, -1, 0};
        int[] DN = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();

        count = 0;

        for (int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                visited[i][j] = true;
            }
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            visited[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = false;
        }

        for (int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if (!visited[i][j]) {
                    count++;
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cur = q.remove();

                        for (int l = 0; l < 4 ; l++){
                            if (cur[0]-DM[l]<m && cur[0]-DM[l] >= 0 && cur[1]-DN[l] <n && cur[1]-DN[l] >=0 && !visited[cur[0]-DM[l]][cur[1]-DN[l]]) {
                                q.add(new int[]{cur[0]-DM[l], cur[1]-DN[l]});
                                visited[cur[0]-DM[l]][cur[1]-DN[l]] = true;

                            }
                        }
                    }
                }
            }
        }


        return count;
    }

}