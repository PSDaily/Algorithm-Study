package codeTree.hyundai;

import java.util.*;

public class Q3_1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.next();
        String key = sc.next();

        // key -> 표
        Map<Character,int[]> map = new HashMap<>();
        Map<Integer,Character> map2 = new HashMap<>();
        int index = 0;
        for(char k: key.toCharArray()){
            if(!map.containsKey(k)){
                int row = index/5;
                int col = index%5;
                map.put(k,new int[]{row,col});
                map2.put(index,k);
                index++;
            }
        }
        while(index<25){
            for(int i=0;i<26;i++){
                char k = (char) (i+'A');
                if(k == 'J'){
                    continue;
                }
                if(!map.containsKey(k)){
                    int row = index/5;
                    int col = index%5;
                    map.put(k,new int[]{row,col});
                    map2.put(index,k);
                    index++;
                }
            }
        }

/*
        for(Map.Entry<Character,int[]> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue()[0]+" "+ entry.getValue()[1]);
        }
        for(Map.Entry<Integer,Character> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
*/
        // msg -> 2글자씩 바꾸기
        int i=0;
        while(i<msg.length()){
            char c1 = msg.charAt(i);
            char c2;
            if(i+1>=msg.length()){
                c2 = 'X';
                i++;
            }
            else if(c1 == msg.charAt(i+1)){
                c2 = (c1=='X') ? 'Q':'X';
                i++;
            }
            else{
                c2 = msg.charAt(i+1);
                i+=2;
            }

            String str = ""+c1+c2;

            //System.out.println(str);

            // 암호화
            int row1 = map.get(str.charAt(0))[0];
            int col1 = map.get(str.charAt(0))[1];

            int row2 = map.get(str.charAt(1))[0];
            int col2 = map.get(str.charAt(1))[1];

            //System.out.println(row1 +","+col1 +" "+row2+","+col2+" ");
            String newStr = "";

            if(row1 == row2){
                int idx1 = row1*5+(col1+1)%5;
                char char1 = map2.get(idx1);

                int idx2 = row2*5+(col2+1)%5;
                char char2 = map2.get(idx2);

                newStr = ""+char1+char2;
            }

            else if(col1 == col2){
                int idx1 = ((row1+1)%5)*5+col1;
                char char1 = map2.get(idx1);

                int idx2 = ((row2+1)%5)*5+col2;
                char char2 = map2.get(idx2);

                newStr = ""+char1+char2;
            }

            else{
                int idx1 = row1*5+col2;
                char char1 = map2.get(idx1);

                int idx2 = row2*5+col1;
                char char2 = map2.get(idx2);

                newStr = ""+char1+char2;
            }

            System.out.print(newStr);
        }
    }
}