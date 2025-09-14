package Baekjoon.codingdodo.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] intToStr = new String[N];
        Map<String, Integer> strToInt = new HashMap<>();

        for(int i=0;i<N;i++){
            String monster = br.readLine();
            intToStr[i] = monster;
            strToInt.put(monster, i);
        }

        for(int i=0;i<M;i++){
            String question = br.readLine();
            if(Character.isDigit(question.charAt(0))){
                int number = Integer.parseInt(question);
                System.out.println(intToStr[number-1]);

            }
            else {
                System.out.println(strToInt.get(question)+1);
            }
        }
    }
}
