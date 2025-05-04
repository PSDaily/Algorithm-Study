import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    int stage;

    public Node(int x, int y, int stage) {
        this.x = x;
        this.y = y;
        this.stage = stage;
    }


}


public class Problem2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int [][] maze = new int[x][y];

        for (int i = 0; i < x; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < y; j++) {
                maze[i][j] = Integer.parseInt(line[j]);
            }
        }

        int count = 1;
        int stage = 1;
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0,stage));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.stage > stage) {
                count++;
                stage = cur.stage;
            }

            if (cur.x == x-1 && cur.y == y-1) {
                bw.write(String.valueOf(count));
                break;
            }

            if (cur.x >= 1 && maze[cur.x-1][cur.y] == 1) {
                q.add(new Node(cur.x-1, cur.y, cur.stage+1));
                maze[cur.x-1][cur.y] = 0;
            }

            if (cur.y >= 1 && maze[cur.x][cur.y-1] == 1) {
                q.add(new Node(cur.x, cur.y-1, cur.stage+1));
                maze[cur.x][cur.y-1] = 0;
            }

            if (cur.x+1 < x && maze[cur.x+1][cur.y] == 1) {
                q.add(new Node(cur.x+1, cur.y, cur.stage+1));
                maze[cur.x+1][cur.y] = 0;
            }

            if (cur.y+1 < y && maze[cur.x][cur.y+1] == 1) {
                q.add(new Node(cur.x, cur.y+1, cur.stage+1));
                maze[cur.x][cur.y+1] = 0;
            }
        }

        bw.flush();
        bw.close();

    }
}