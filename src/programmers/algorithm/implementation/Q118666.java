package programmers.algorithm.implementation;

import java.util.*;

class Q118666 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<Character,Integer> map = new HashMap<>();
        // 비동의: 1~3, 동의: 5~7
        // 점수: 3,2,1 -> 4-번호 / 1,2,3 -> 번호-4
        for(int i=0;i<choices.length;i++){
            if(choices[i]<4){
                int point = 4-choices[i];
                map.put(survey[i].charAt(0),map.getOrDefault(survey[i].charAt(0),0)+point);
            }
            else if(choices[i]>4){
                int point = choices[i]-4;
                map.put(survey[i].charAt(1),map.getOrDefault(survey[i].charAt(1),0)+point);
            }
        }

        answer += map.getOrDefault('R',0)>=map.getOrDefault('T',0) ? 'R':'T';
        answer += map.getOrDefault('C',0)>=map.getOrDefault('F',0) ? 'C':'F';
        answer += map.getOrDefault('J',0)>=map.getOrDefault('M',0) ? 'J':'M';
        answer += map.getOrDefault('A',0)>=map.getOrDefault('N',0) ? 'A':'N';




        return answer;
    }
}