import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem5427 {
    static int[] DW = {1, 0, -1, 0}; // x 방향
    static int[] DH = {0, 1, 0, -1}; // y 방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] map = new char[h][w];
            boolean[][] personVisited = new boolean[h][w];
            boolean[][] fireVisited = new boolean[h][w];

            Queue<int[]> fire = new LinkedList<>();
            Queue<int[]> person = new LinkedList<>();

            for (int y = 0; y < h; y++) {
                String line = br.readLine();
                for (int x = 0; x < w; x++) {
                    char ch = line.charAt(x);
                    map[y][x] = ch;
                    if (ch == '#') {
                        personVisited[y][x] = true;
                        fireVisited[y][x] = true;
                    } else if (ch == '*') {
                        fireVisited[y][x] = true;
                        fire.add(new int[]{x, y, 0});
                    } else if (ch == '@') {
                        personVisited[y][x] = true;
                        person.add(new int[]{x, y, 0});
                    }
                }
            }

            String result = "IMPOSSIBLE";

            while (!person.isEmpty()) {
                int[] p = person.poll();

                while (!fire.isEmpty() && fire.peek()[2] <= p[2]) {
                    moveFire(fire.poll(), w, h, fireVisited, fire);
                }

                if (isAtEdge(p[0], p[1], w, h)) {
                    result = String.valueOf(p[2] + 1);
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = p[0] + DW[d];
                    int ny = p[1] + DH[d];

                    if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
                        if (!personVisited[ny][nx] && map[ny][nx] != '#' && !fireVisited[ny][nx]) {
                            personVisited[ny][nx] = true;
                            person.add(new int[]{nx, ny, p[2] + 1});
                        }
                    }
                }
            }

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static void moveFire(int[] target, int w, int h, boolean[][] fireVisited, Queue<int[]> fireQ) {
        int x = target[0];
        int y = target[1];
        int time = target[2];

        for (int i = 0; i < 4; i++) {
            int nx = x + DW[i];
            int ny = y + DH[i];

            if (nx >= 0 && nx < w && ny >= 0 && ny < h && !fireVisited[ny][nx]) {
                fireVisited[ny][nx] = true;
                fireQ.add(new int[]{nx, ny, time + 1});
            }
        }
    }

    static boolean isAtEdge(int x, int y, int w, int h) {
        return (x == 0 || x == w - 1 || y == 0 || y == h - 1);
    }
}

// push
