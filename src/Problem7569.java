import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Problem7569 {
    static int[] DM = {1, -1, 0, 0, 0, 0};
    static int[] DN = {0, 0, 1, -1, 0, 0};
    static int[] DH = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] box = new int[m][n][h];
        int[][][] day = new int[m][n][h];

        String line;
        Queue<int[]> ripenTomato = new LinkedList<>();

        boolean isAllRipen = true;
        int maxDay = 0;

        // 박수 채우기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[k][j][i] = Integer.parseInt(st.nextToken());
                    day[k][j][i] = 0;
                    if (box[k][j][i] == 1) {
                        ripenTomato.add(new int[]{k, j, i});
                    }
                }
            }
        }

        //익은 토마토 찾기
        while (!ripenTomato.isEmpty()) {
            int[] tomato = ripenTomato.poll();

            ripenTomato(box, tomato, ripenTomato, m, n, h, day);

        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[k][j][i] == 0) {
                        isAllRipen = false;
                        break;
                    }
                    else {
                        if (day[k][j][i] > maxDay) {
                            maxDay = day[k][j][i];
                        }
                    }
                }
            }
        }

        if (isAllRipen) {
            bw.write(String.valueOf(maxDay));
        }
        else {
            bw.write("-1");
        }
        bw.flush();
        bw.close();




    }

    public static void ripenTomato(int[][][] box, int[] tomato, Queue<int[]> q, int m, int n, int h, int[][][] day) {
        boolean[] result = new boolean[6];
        for (int i = 0; i < 6; i++) {
            int x = tomato[0] + DM[i];
            int y = tomato[1] + DN[i];
            int z = tomato[2] + DH[i];
            if (x >= 0 && x < m && y >= 0 && y < n && z >= 0 && z < h) {
                if (box[x][y][z] == 0) {
                    q.add(new int[]{x, y, z});
                    box[x][y][z] = 1;
                    day[x][y][z] = day[tomato[0]][tomato[1]][tomato[2]] + 1;
                }
            }

        }
    }
}