package programmers.algorithm.greedy;

import java.util.*;

class Q258707 {
    static int target;
    public int solution(int coin, int[] cards) {
        int answer = 0;

        int n = cards.length;
        Set<Integer> hand = new HashSet<>();
        for(int i=0;i<n/3;i++){
            hand.add(cards[i]);
        }

        Set<Integer> draw = new HashSet<>();
        int index = n/3;
        target = n+1;
        int round = 1;
        while(index < n){
            draw.add(cards[index++]);
            draw.add(cards[index++]);

            // 가진 것 안에서 해결
            if(findPair(hand,hand)){

            }

            // 가진 것 하나+새로운 것
            else if(coin>=1 && findPair(hand,draw)){
                coin--;
            }

            // 새로운 것 안에서 해결
            else if(coin>=2 && findPair(draw,draw)){
                coin -= 2;
            }

            else{
                break;
            }

            round++;
        }

        return round;
    }

    static boolean findPair(Set<Integer> set1, Set<Integer> set2){
        for(int card: set1){
            if(set2.contains(target-card)){
                set1.remove(card);
                set2.remove(target-card);
                return true;
            }
        }
        return false;
    }
}
