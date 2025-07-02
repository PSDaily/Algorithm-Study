import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.StringBuilder;

public class Problem10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] DN = {1, 0, -1, 0};
        int[] DM = {0, 1, 0, -1};

        int[] color = {0, 0, 0};
        int[] noncolor = {0, 0};


        String line;
        char c;
        Queue<int[]> color_q = new LinkedList<int[]>();
        Queue<int[]> noncolor_q = new LinkedList<int[]>();

        int n = Integer.parseInt(br.readLine());

        int[][] color_arr = new int[n][n];
        int[][] noncolor_arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < n; j++) {
                c = line.charAt(j);
                if (c == 'B') {
                    color_arr[i][j] = 3;
                    noncolor_arr[i][j] = 2;
                }
                else if (c == 'R') {
                    color_arr[i][j] = 1;
                    noncolor_arr[i][j] = 1;
                }
                else {
                    color_arr[i][j] = 2;
                    noncolor_arr[i][j] = 1;
                }


            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (color_arr[i][j] != 0) {
                    int k = color_arr[i][j];
                    color_q.add(new int[]{i, j});
                    color_arr[i][j] = 0;
                    // count 올리기
                    color[k-1]++;


                    while (!color_q.isEmpty()) {
                        int[] temp = color_q.poll();
                        for (int l = 0; l < 4; l++) {
                            int x = temp[0] + DN[l];
                            int y = temp[1] + DM[l];
                            if (x >=0 && x <= n-1 && y >=0 && y <= n-1 && color_arr[x][y] == k) {
                                color_q.add(new int[]{x, y});
                                color_arr[x][y] = 0;
                            }
                        }
                    }
                }

                if (noncolor_arr[i][j] != 0) {
                    int k = noncolor_arr[i][j];
                    noncolor_q.add(new int[]{i, j});
                    noncolor_arr[i][j] = 0;
                    // count 올리기
                    noncolor[k-1]++;



                    while (!noncolor_q.isEmpty()) {
                        int[] temp = noncolor_q.poll();
                        for (int l = 0; l < 4; l++) {
                            int x = temp[0] + DN[l];
                            int y = temp[1] + DM[l];
                            if (x >=0 && x <= n-1 && y >=0 && y <= n-1 && noncolor_arr[x][y] == k) {
                                noncolor_q.add(new int[]{x, y});
                                noncolor_arr[x][y] = 0;
                            }
                        }
                    }
                }
            }
        }
        int colorCount = color[0] + color[1] + color[2];
        int noncolorCount = noncolor[0] + noncolor[1];


        sb.append(colorCount).append(" ").append(noncolorCount);
        bw.write(sb.toString());
        bw.flush();
        bw.close();







    }
}