import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int n;
    int m;

    public Node(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }
}

public class Problem1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int sum = 0;
        int maxSum = 0;
        int count = 0;

        int nodeN = 0;
        int nodeM = 0;

        Queue<Node> queue = new LinkedList<>();
        Node node = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum  = 0;
                if (arr[i][j] == 1 && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    queue.add(new Node(i, j));
                    while (!queue.isEmpty()) {
                        node = queue.remove();
                        sum++;
                        nodeN = node.getN();
                        nodeM = node.getM();

                        sum++;
                        if (nodeN < n-1 && arr[nodeN+1][nodeM] == 1 && !visited[nodeN+1][nodeM] ) {
                            queue.add(new Node(i+1, j));
                        }

                        if (nodeM < m-1 &&arr[nodeN][nodeM+1] ==1 && !visited[nodeN][nodeM+1] ) {
                            queue.add(new Node(nodeN, nodeM+1));
                        }
                    }
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }
        bw.write(String.valueOf(count)+"\n");
        bw.write(String.valueOf(maxSum));
        bw.flush();
        bw.close();
    }

}
