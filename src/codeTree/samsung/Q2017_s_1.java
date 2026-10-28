package codeTree.samsung;

import java.io.*;
import java.util.*;

public class Q2017_s_1 {
    static int n;
    static int[][] graph;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,new ArrayList<>());

        System.out.println(min);
    }

    // 일 나누기
    static void dfs(int now, List<Integer> list){
        if(now == n){
            if(list.size()==n/2){
                // 업무 강도 구하기
                List<Integer> work = list;
                int works = 0;
                for(int i=0;i<n/2;i++){
                    for(int j=i+1;j<n/2;j++){
                        works += graph[work.get(i)][work.get(j)];
                        works += graph[work.get(j)][work.get(i)];
                    }
                }

                List<Integer> work2 = new ArrayList<>();
                for(int i=0;i<n;i++){
                    if(!work.contains(i)){
                        work2.add(i);
                    }
                }
                int works2 = 0;
                for(int i=0;i<n/2;i++){
                    for(int j=i+1;j<n/2;j++){
                        works2 += graph[work2.get(i)][work2.get(j)];
                        works2 += graph[work2.get(j)][work2.get(i)];
                    }
                }

                min = Math.min(min,Math.abs(works-works2));
            }

            return;
        }

        list.add(now);
        dfs(now+1,list);

        list.remove(list.size()-1);
        dfs(now+1,list);

    }

}