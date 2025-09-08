import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String line;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int skip = 1;
        int count = 1;

        int[][] arr = new int[n][m];
        int[] DN = {-1, 1, 0, 0};
        int[] DM = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, skip, count});

        boolean flag = false;

        // 배열 채우기
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(line.charAt(j)+"");
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            skip = cur[2];
            count = cur[3];

            if (x == n-1 && y == m-1) {
                flag = true;
                bw.write(String.valueOf(count));
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + DN[i];
                int nextY = y + DM[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (arr[nextX][nextY] == 0) {
                        if (skip == 1) {
                            arr[nextX][nextY] = 2;
                            q.add(new int[]{nextX, nextY, skip, count+1});
                        }
                        else {
                            arr[nextX][nextY] = 3;
                            q.add(new int[]{nextX, nextY, skip, count+1});
                        }

                    }

                    else if (arr[nextX][nextY] == 1) {
                        if (skip == 1) {
                            q.add(new int[]{nextX, nextY, 0, count+1});
                        }

                    }

                    else if (arr[nextX][nextY] == 3) {
                        if (skip == 1) {
                            arr[nextX][nextY] = 2;
                            q.add(new int[]{nextX, nextY, skip, count+1});
                        }
                    }

                    // skip을 안쓴 건 -> skip을 쓴걸 또 밟을 수 있지만 안쓴건 밟을 수 없음

                    // skip을 쓴 건 ->
//                    if (arr[nextX][nextY] == 0 && skip == 0 && ()) {
//                        arr[nextX][nextY] = ;
//                        q.add(new int[]{nextX, nextY, skip, count+1});
//                    }
//                    else if (arr[nextX][nextY] == 1 && skip == 1 && arr[nextX][nextY]) {
//                        arr[nextX][nextY] = ;
//                        q.add(new int[]{nextX, nextY, 0, count+1});
//                    }
                }
            }


        }

        if (!flag) {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();



    }
}