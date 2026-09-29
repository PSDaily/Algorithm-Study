package programmers.algorithm.dijkstra;

import java.util.*;

class Q118669 {
    static PriorityQueue<int[]> pq;
    static List<int[]>[] graph;
    static int minIntensity,minSummit;
    static boolean[] isSummit;
    static int[] dist;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];

        graph = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] path: paths){
            graph[path[0]].add(new int[]{path[1],path[2]});
            graph[path[1]].add(new int[]{path[0],path[2]});
        }

        isSummit = new boolean[n+1];
        for(int summit: summits){
            isSummit[summit] = true;
        }

        pq = new PriorityQueue<>((a,b) -> a[1]-b[1]); // intensity 작은 거부터

        minSummit = Integer.MAX_VALUE;
        minIntensity = Integer.MAX_VALUE;
        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        for(int gate: gates){
            dist[gate] = 0;
            pq.offer(new int[]{gate,0});
        }

        dijkstra();

        answer[0] = minSummit;
        answer[1] = minIntensity;

        return answer;
    }

    static void dijkstra(){
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int intensity = cur[1];

            if (dist[node] < intensity) {
                continue;
            }

            if(isSummit[node] == true){
                if(minIntensity > intensity){
                    minIntensity = intensity;
                    minSummit = node;
                }
                else if(minIntensity == intensity){
                    if(minSummit > node){
                        minSummit = node;
                    }
                }
                continue;
            }

            for(int[] next: graph[node]){
                int nextNode = next[0];
                int nextIntensity = Math.max(intensity,next[1]);

                if(dist[nextNode] > nextIntensity){
                    dist[nextNode] = nextIntensity;
                    pq.offer(new int[]{nextNode,nextIntensity});
                }

            }

        }
    }
}