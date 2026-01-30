package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem10809 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String voca = br.readLine();

        //toMap
        Map<Character, Integer> mapByAlphabet = toMap(voca);

        StringBuilder sb = new StringBuilder();
        for(Character i = 'a'; i <= 'z'; i++){
            int position = mapByAlphabet.getOrDefault(i, -1);
            sb.append(position + " ");
        }

        System.out.println(sb);
    }

    static Map<Character, Integer> toMap(String voca){
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < voca.length(); i++){
            Character alphabet = voca.charAt(i);
            // map에 해당 키값이 있으면 바로 넣고 없으면 엔트리 생성해서 넣어라
            map.putIfAbsent(alphabet, i);
        }

        return map;
    }
}

