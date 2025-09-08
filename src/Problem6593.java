import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.StringBuilder;

public class Problem6593 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        StringBuilder sb = new StringBuilder();

        int l;
        int r;
        int c;

        int[] DL = {1, -1, 0, 0, 0, 0};
        int[] DR = {0, 0, 1, -1, 0, 0};
        int[] DC = {0, 0, 0, 0, 1, -1};
        boolean[][][] building;
        int[] goal = {0, 0, 0};
        int count;

        Queue<int[]> q = new LinkedList<>();

        while(!line.equals("0 0 0")) {
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            building = new boolean[l][r][c];
            boolean flag = false;
            count = 0;

            // 빌딩 초기 설정
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    line = br.readLine();
                    for (int k = 0; k < c; k++) {
                        switch (line.charAt(k)) {
                            case 'S':
                                building[i][j][k] = false;
                                q.add(new int[]{i, j, k, count});
                                break;
                            case 'E':
                                building[i][j][k] = true;
                                goal = new int[] {i, j, k};
                                break;
                            case '#':
                                building[i][j][k] = false;
                                break;
                            default:
                                building[i][j][k] = true;
                                break;
                        }

                    }

                }
                br.readLine();
            }

            // 빌딩 탐색
            while (!q.isEmpty()) {
                int[] cur = q.poll();

                if (cur[0] == goal[0] && cur[1] == goal[1] && cur[2] == goal[2]) {
                    flag = true;
                    count = cur[3];
                    break;
                }

                for (int k = 0; k < 6; k++) {
                    int nextL = cur[0] + DL[k];
                    int nextR = cur[1] + DR[k];
                    int nextC = cur[2] + DC[k];
                    count = cur[3];

                    if (nextL >= 0 && nextL < l
                            && nextR >= 0 && nextR < r
                            && nextC >= 0 && nextC < c
                            && building[nextL][nextR][nextC]) {
                        q.add(new int[]{nextL, nextR, nextC, ++count});
                        building[nextL][nextR][nextC] = false;
                    }
                }
            }

            if(flag) {
                sb.append("Escaped in ").append(String.valueOf(count)).append(" minute(s).\n");
                bw.write(sb.toString());
                sb.setLength(0);
            } else {
                bw.write("Trapped!\n");
            }

            q.clear();

            line = br.readLine();
            st = new StringTokenizer(line);

        }

        bw.flush();
        bw.close();
        br.close();

    }
}