import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Problem2075 {
    static int N;
    static int[] maxIdx;
    static Long[][] darr;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.valueOf(br.readLine());
        darr = new Long[N][N];
        maxIdx = new int[N];
        Arrays.fill(maxIdx, N - 1);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                darr[i][j] = Long.valueOf(st.nextToken());
            }
        }

        //when
        for (int i = 0; i < N; i++) {
            pq.add(new Pair(darr[N-1][i], N-1, i));
        }

        //N번째 큰 수
        Long result = 0L;
        for (int i = 0; i < N; i++) {
            Pair maxElement = pq.poll();
            result = maxElement.value;


            int row = maxElement.row;
            int col = maxElement.col;
            maxIdx[col] = row-1;
            if(row-1<0) break;
            pq.offer(new Pair(darr[row-1][col], row-1, col));
        }

        System.out.println(result);



    }

    static class Pair implements Comparable<Pair> {
        Long value;
        int row;
        int col;

        Pair(Long value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Pair o) {
            return -(int) (this.value - o.value);
        }
    }
}
