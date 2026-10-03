package programmers.algorithm.dfsbfs;

import java.util.*;

class Q258709 {
    static int n;
    static int[][] Dice;

    static List<Integer> group;
    static boolean[] visited;

    static List<Integer> resultA;
    static List<Integer> resultB;

    static int maxWin = 0;
    static int[] answer;
    public int[] solution(int[][] dice) {
        n = dice.length;
        Dice = dice;
        group = new ArrayList<>();
        visited = new boolean[n];

        answer = new int[n/2];

        dfs(0,0);

        return answer;
    }

    // dice 조합 고르기
    static void dfs(int depth, int start){
        if(depth == n/2){

            int[] groupA = new int[n/2];
            int[] groupB = new int[n/2];

            int a=0;
            int b=0;
            for(int i=0;i<n;i++){
                if(visited[i]){
                    groupA[a++] = i;
                }
                else{
                    groupB[b++] = i;
                }
            }

            resultA = new ArrayList<>();
            resultB = new ArrayList<>();

            makeSums(0,0,groupA,resultA);
            makeSums(0,0,groupB,resultB);

            Collections.sort(resultB);

            int win = 0;

            for(int sumA : resultA){
                int left = 0;
                int right = resultB.size();

                while(left < right){
                    int mid = (left + right) / 2;

                    if(resultB.get(mid) < sumA){
                        left = mid + 1;
                    }
                    else{
                        right = mid;
                    }
                }

                win += left;
            }

            if(win > maxWin){
                maxWin = win;
                for(int i=0;i<groupA.length;i++){
                    answer[i] = groupA[i]+1;
                }
            }

            return;
        }

        for(int i=start;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                group.add(i);

                dfs(depth+1,i+1);

                visited[i] = false;
                group.remove(group.size()-1);
            }
        }

    }

    static void makeSums(int depth,int sum, int[] dices, List<Integer> result){
        if(depth == n/2){
            result.add(sum);
            return;
        }

        int diceNumber = dices[depth];

        for(int i=0;i<6;i++){
            makeSums(depth+1,sum+Dice[diceNumber][i],dices,result);
        }
    }
}