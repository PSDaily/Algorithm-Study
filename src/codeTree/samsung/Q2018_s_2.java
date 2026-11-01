package codeTree.samsung;

import java.io.*;
import java.util.*;

public class Q2018_s_2 {
    static int[][] graph;
    static int m;
    static List<int[]> hospitals, people;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        hospitals = new ArrayList<>();
        people = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());

                // 병원
                if(graph[i][j] == 2){
                    hospitals.add(new int[]{i,j});
                }

                // 사람
                else if(graph[i][j] == 1){
                    people.add(new int[]{i,j});
                }
            }
        }

        // m개의 병원에 대한, 가장 가까운 병원까지의 거리들의 총 합이, 최소

        // 어떤 m개를 남길지 선택 -> 그 m개의 병원-사람의 거리 모두 구해서 최소 -> 다 더하기
        min = Integer.MAX_VALUE;
        dfs(0,new ArrayList<>());

        System.out.println(min);
    }

    // 어떤 m개의 병원을 남길지 선택
    static void dfs(int depth, List<int[]> hospital){
        if(hospital.size() == m){
            int sum = 0;
            for(int[] p: people){
                int hDis = Integer.MAX_VALUE;
                for(int[] h: hospital){
                    int dis = Math.abs(h[0]-p[0])+Math.abs(h[1]-p[1]);
                    hDis = Math.min(hDis,dis);
                    //System.out.println("hDis="+hDis);
                }
                sum += hDis;
                //System.out.println("sum="+sum);
            }

            min = Math.min(min,sum);
            return;
        }

        // 모든 병원 확인 완료
        if(depth == hospitals.size()){
            return;
        }

        hospital.add(hospitals.get(depth));
        dfs(depth+1,hospital);

        hospital.remove(hospital.size()-1);
        dfs(depth+1,hospital);
    }
}