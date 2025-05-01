import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.StringBuilder;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Problem1926 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] array = new int[x][y];

        for (int i = 0 ; i < x ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < y ; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int z;
        int count = 0;
        int extent = 0;
        int max_extent = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] arr = new int[2];

        for (int i = 0 ; i < x ; i++) {
            for (int j = 0 ; j < y ; j++) {
                z = array[i][j];
//                System.out.println("array[" + i + "][" + j + "] = " + z);
//                System.out.println("count: " + count);
                extent = 0;
                if (z  == 1){
                    count++;
                    extent++;
                    queue.add(new int[]{i, j});
                    array[i][j] = 0;
                    while(!queue.isEmpty()){
                        arr = queue.poll();
                        if(arr[0] < x-1 && array[arr[0]+1][arr[1]] == 1){
                            queue.add(new int[]{arr[0]+1, arr[1]});
                            array[arr[0]+1][arr[1]] = 0;
                            extent++;
                        }
                        if(arr[1] < y-1 && array[arr[0]][arr[1]+1] == 1){
                            queue.add(new int[]{arr[0], arr[1]+1});
                            array[arr[0]][arr[1]+1] = 0;
                            extent++;
                        }
                        if(arr[0]-1 >= 0 && array[arr[0]-1][arr[1]] == 1){
                            queue.add(new int[]{arr[0]-1, arr[1]});
                            array[arr[0]-1][arr[1]] = 0;
                            extent++;
                        }
                        if(arr[1]-1 >= 0 && array[arr[0]][arr[1]-1] == 1){
                            queue.add(new int[]{arr[0], arr[1]-1});
                            array[arr[0]][arr[1]-1] = 0;
                            extent++;
                        }
                    }
//                    System.out.println(extent);

                    if(extent > max_extent){
                        max_extent = extent;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        bw.write(sb.append(count).append("\n").append(max_extent).append("\n").toString());
        bw.flush();
        bw.close();




    }
}