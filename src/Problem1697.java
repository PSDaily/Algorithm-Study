import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Place {
    int p;
    int stage;

    public Place(int p, int stage) {
        this.p = p;
        this.stage = stage;
    }
}

public class Problem1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int stage = 0;
        boolean[] visited = new boolean[100001];


        Queue<Place> q = new LinkedList<>();
        q.add(new Place(n, 0));
        visited[n] = true;

        Place p;

        while (!q.isEmpty()) {
            p = q.remove();
            if(p.p == k){
                bw.write(String.valueOf(p.stage));
                break;
            }

            if(p.p-1 >= 0 && !visited[p.p-1]){
                q.add(new Place(p.p - 1, p.stage + 1));
                visited[p.p-1] = true;
            }
            if(p.p+1 <= 100000 && !visited[p.p+1]){
                q.add(new Place(p.p + 1, p.stage + 1));
                visited[p.p+1] = true;
            }
            if(p.p*2 <= 100000 && !visited[p.p*2]){
                q.add(new Place(p.p * 2, p.stage + 1));
                visited[p.p*2] = true;
            }

        }

        bw.flush();
        bw.close();
    }
}