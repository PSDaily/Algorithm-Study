package codeTree.hyundai;

import java.util.*;

public class Q3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] times = new int[N];
        char[] roads = new char[N];

        for (int i = 0; i < N; i++) {
            times[i] = sc.nextInt();
            roads[i] = sc.next().charAt(0);
        }

        int[] answer = new int[N];
        Arrays.fill(answer,-1);

        Queue<Integer>[] wait = new LinkedList[4];
        for(int i=0;i<4;i++){
            wait[i] = new LinkedList<>();
        }

        int time = 0;
        int index = 0;
        while(index<N || !wait[0].isEmpty() || !wait[1].isEmpty() || !wait[2].isEmpty() || !wait[3].isEmpty()){

            // time보다 작을 때까지 input
            while(index<N && times[index]<=time){

                // A,B,C,D에 저장
                wait[roads[index]-'A'].offer(index);

                // index 업데이트
                index++;
            }

            // deadlock 처리
            boolean deadlock = true;
            for(int i=0;i<4;i++){
                if(wait[i].isEmpty()){
                    deadlock = false;
                    break;
                }
            }
            if(deadlock){
                break;
            }

            // 순서대로 교차로 통과 처리  & time 업데이트
            boolean[] canGo = new boolean[4];
            for(int i=0;i<4;i++){
                if(!wait[i].isEmpty() && wait[(i+3)%4].isEmpty()){
                    canGo[i] = true;
                }
            }

            for(int i=0;i<4;i++){
                if(canGo[i]){
                    int car = wait[i].poll();
                    answer[car] = time;
                }
            }

            boolean empty = true;

            for (int i = 0; i < 4; i++) {
                if (!wait[i].isEmpty()) {
                    empty = false;
                    break;
                }
            }

            if (empty && index < N) {
                time = Math.max(time + 1, times[index]);
            } else {
                time++;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(answer[i]);
        }
    }
}