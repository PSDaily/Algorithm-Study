import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;


public class Problem2468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int max = 1;
        int min = 100;
        int safeArea = 0;
        int count;

        int[] DM = {1, 0, -1, 0};
        int[] DN = {0, 1, 0, -1};

        StringTokenizer st;
        Queue<int[]> q = new LinkedList<>();

        // 배열 채우기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int k = Integer.parseInt(st.nextToken());
                arr[i][j] = k;
                if (k > max){
                    max = k;
                }
                if (k < min){
                    min = k;
                }
            }
        }


        for (int i = min; i < max+1; i++) {

            // 영역 개수 초기화
            count = 0;

            // 방문 배열 초기화
            for (int a = 0 ; a < n ; a++){
                for(int b = 0 ; b < n ; b++){
                    visited[a][b] = false;
                }
            }

            // 배열 돌면서 영역 체크
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < n ; k++){
                    if(arr[j][k] >= i && !visited[j][k]){
                        q.add(new int[]{j, k});
                        visited[j][k] = true;
                        count++; // 안전 영역 발견시 +1


                        while(!q.isEmpty()){
                            int[] temp = q.poll();
                            int m = temp[0];
                            int l = temp[1];

                            for(int a = 0 ; a < 4 ; a++){
                                int nm = m + DM[a];
                                int nl = l + DN[a];

                                if(nm >= 0 && nm < n && nl >= 0 && nl < n && arr[nm][nl] >= i && !visited[nm][nl]){
                                    visited[nm][nl] = true;
                                    q.add(new int[]{nm, nl});
                                }
                            }
                        }



                    }
                }
            }
            safeArea = Math.max(safeArea, count);
        }

        bw.write(String.valueOf(safeArea));
        bw.flush();
        bw.close();
        br.close();






    }
}