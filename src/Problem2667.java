import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] DM = {1, 0, -1, 0};
        int[] DN = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> houseList = new ArrayList<>();

        int m = Integer.parseInt(br.readLine());
        int count;
        int house = 0;
        String line;

        int[][] isVisited = new int[m][m];
        for (int i = 0; i < m; i++) {
            line = br.readLine();

            for(int j = 0; j < m; j++) {
                isVisited[i][j] = Integer.parseInt(line.charAt(j) + "");
            }
        }

        for (int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                if(isVisited[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    isVisited[i][j] = 0;
                    count = 1;
                    house++;

                    while(!queue.isEmpty()) {
                        int[] temp = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = temp[0] + DM[k];
                            int y = temp[1] + DN[k];

                            if (x >= 0 && x < m && y >= 0 && y < m) {
                                if (isVisited[x][y] == 1) {
                                    queue.add(new int[]{x, y});
                                    isVisited[x][y] = 0;
                                    count++;
                                }
                            }
                        }
                    }

                    houseList.add(count);

                }


            }

        }

        bw.write(house+"\n");
        Collections.sort(houseList);

        for(int i : houseList) {
            bw.write(i+"\n");
        }

        bw.flush();
        bw.close();
        br.close();


    }
}