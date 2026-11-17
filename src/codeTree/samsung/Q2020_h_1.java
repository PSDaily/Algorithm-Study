package codeTree.samsung;

import java.io.*;
import java.util.*;

public class Q2020_h_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] graph = new int[n*2];
        for(int i=0;i<n*2;i++){
            graph[i] = Integer.parseInt(st.nextToken());
        }

        int test = 1;
        int[] people = new int[n*2];
        outer:
        while(true){
            // 1. 무빙워크 1칸 회전(시계방향) + 사람도 회전
            int temp = graph[n*2-1];
            int tempP = people[n*2-1];
            for(int i=n*2-1;i>0;i--){
                graph[i] = graph[i-1];
                people[i] = people[i-1];
            }
            graph[0] = temp;
            people[0] = tempP;
            // n번 칸에 사람 위치 -> 즉시 내림
            if(people[n-1]==1){
                people[n-1]--;
            }


            // 2. 사람 1칸 이동
            for(int i=n-2;i>=0;i--){
                if(people[i]==1){
                    if(people[i+1]==0 && graph[i+1]>0){
                        people[i]--;
                        people[i+1]++;
                        graph[i+1]--;
                    }
                }

                // n번 칸에 사람 위치 -> 즉시 내림
                if(people[n-1]==1){
                    people[n-1]--;
                }
            }

            // 3. 사람 1명 올림
            if(people[0]==0 && graph[0]>0){
                people[0]++;
                graph[0]--;
            }

            // 4. 안정성 0인 칸 k개 이상이면 종료
            int count = 0;
            for(int i=0;i<n*2;i++){
                if(graph[i]==0){
                    count++;
                }
                if(count >= k){
                    break outer;
                }
            }

            test++;
        }

        System.out.println(test);
    }
}