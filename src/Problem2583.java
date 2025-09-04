import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.*;

public class Problem2583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int DM[] = {-1, 0, 1, 0};
        int DN[] = {0, -1, 0, 1};

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        ArrayList<Integer> q2 = new ArrayList<>();
        int areaCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = true;
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int x = x2 - x1;
            int y = y2 - y1;

            int startX = x1;
            int startY = m - y2;

            for (int a = 0; a < x; a++) {
                for (int b = 0; b < y; b++) {
                    dp[startY + b][startX + a] = false;
                }
            }

        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++){
                if(dp[i][j]) {
                    q.add(new int[]{i, j});
                    dp[i][j] = false;
                    int count = 1;
                    areaCount++;

                    while(!q.isEmpty()) {
                        int[] temp = q.poll();

                        for (int a = 0; a < 4; a++) {
                            int nextM = temp[0] + DM[a];
                            int nextN = temp[1] + DN[a];

                            if (nextM >= 0 && nextM < m && nextN >= 0 && nextN < n && dp[nextM][nextN]) {
                                dp[nextM][nextN] = false;
                                count++;
                                q.add(new int[]{nextM, nextN});
                            }
                        }
                    }

                    q2.add(count);
                }
            }
        }

        bw.write(areaCount + "\n");

        Collections.sort(q2);
        for (int i = 0; i < q2.size(); i++) {
            bw.write(q2.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();


    }
}