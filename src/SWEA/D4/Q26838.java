package SWEA.D4;

import java.util.*;
import java.io.*;

public class Q26838 {
    static int[] color;
    static List<Integer>[] graph;
    static int K;
    static long[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t=0;t<tc;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            color = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int n=0;n<N;n++) {
                color[n] = Integer.parseInt(st.nextToken());
            }

            graph = new ArrayList[N];
            for(int n=0;n<N;n++) {
                graph[n] = new ArrayList<>();
            }
            for(int m=0;m<M;m++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;

                graph[x].add(y);
                graph[y].add(x);
            }

            dp = new long[N][32];

            for (int n = 0; n < N; n++) {
                Arrays.fill(dp[n], -1);
            }

            long answer = 0;
            for(int n=0;n<N;n++) {
                Set<Integer> colors = new HashSet<>();
                colors.add(color[n]);

                answer += dfs(n,colors) -1;
            }
            System.out.println(answer);
        }
    }

    static long dfs(int n, Set<Integer> colors) {
        int key = getKey(colors);

        if (dp[n][key] != -1) {
            return dp[n][key];
        }

        long count = 1;

        for(int next: graph[n]) {
            if(!colors.contains(color[next])) {
                colors.add(color[next]);
                count += dfs(next,colors);
                colors.remove(color[next]);
            }
        }

        dp[n][key] = count;

        return count;
    }

    static int getKey(Set<Integer> colors) {
        int key = 0;

        for (int c = 1; c <= K; c++) {
            key = key * 2 + (colors.contains(c) ? 1 : 0);
        }

        return key;
    }
}
