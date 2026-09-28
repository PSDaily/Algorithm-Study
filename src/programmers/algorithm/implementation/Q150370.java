package programmers.algorithm.implementation;

import java.util.*;

class Q150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] todays = today.split("\\.");
        // 1년 = 12개월 = 12*28일
        // 1개월 = 28일
        int todayToDay = Integer.parseInt(todays[0])*12*28
                +Integer.parseInt(todays[1])*28
                +Integer.parseInt(todays[2]);

        Map<String,Integer> map = new HashMap<>();
        for(String term: terms){
            String[] tokens = term.split(" ");
            map.put(tokens[0],Integer.parseInt(tokens[1]));
        }

        List<Integer> answers = new ArrayList<>();
        for(int i=0;i<privacies.length;i++){
            String[] tokens = privacies[i].split(" ");
            String[] privacy = tokens[0].split("\\.");

            String term = tokens[1];
            int privacyToDay = Integer.parseInt(privacy[0])*12*28
                    +(Integer.parseInt(privacy[1])+map.get(term))*28
                    +Integer.parseInt(privacy[2])-1;

            if(privacyToDay < todayToDay){
                answers.add(i+1);
            }
        }

        int[] answer = new int[answers.size()];
        for(int i=0;i<answers.size();i++){
            answer[i] = answers.get(i);
        }
        return answer;
    }
}