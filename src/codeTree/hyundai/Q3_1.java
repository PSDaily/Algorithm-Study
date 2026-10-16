package codeTree.hyundai;

import java.util.*;

public class Q3_1 {
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
        int count = 0;
        for(int i=0;i<msg.length()-1;i+=2){
            String str = msg.substring(i,i+2);

            if(str.charAt(0) == str.charAt(1)){
                if(str.charAt(0) == 'X'){
                    str = ""+str.charAt(0)+'Q';
                }
                else{
                    str = ""+str.charAt(0)+'X';
                }
                count++;
                i--;
            }

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
                char c1 = map2.get(idx1);

                int idx2 = row2*5+(col2+1)%5;
                char c2 = map2.get(idx2);

                newStr = ""+c1+c2;
            }

            else if(col1 == col2){
                int idx1 = ((row1+1)%5)*5+col1;
                char c1 = map2.get(idx1);

                int idx2 = ((row2+1)%5)*5+col2;
                char c2 = map2.get(idx2);

                newStr = ""+c1+c2;
            }

            else{
                int idx1 = row1*5+col2;
                char c1 = map2.get(idx1);

                int idx2 = row2*5+col1;
                char c2 = map2.get(idx2);

                newStr = ""+c1+c2;
            }

            System.out.print(newStr);
        }

        if((count+msg.length())%2!=0){
            String str = ""+msg.charAt(msg.length()-1)+'X';

            // 암호화
            int row1 = map.get(str.charAt(0))[0];
            int col1 = map.get(str.charAt(0))[1];

            int row2 = map.get(str.charAt(1))[0];
            int col2 = map.get(str.charAt(1))[1];

            //System.out.println(row1 +","+col1 +" "+row2+","+col2+" ");
            String newStr = "";

            if(row1 == row2){
                int idx1 = row1*5+(col1+1)%5;
                char c1 = map2.get(idx1);

                int idx2 = row2*5+(col2+1)%5;
                char c2 = map2.get(idx2);

                newStr = ""+c1+c2;
            }

            else if(col1 == col2){
                int idx1 = ((row1+1)%5)*5+col1;
                char c1 = map2.get(idx1);

                int idx2 = ((row2+1)%5)*5+col2;
                char c2 = map2.get(idx2);

                newStr = ""+c1+c2;
            }

            else{
                int idx1 = row1*5+col2;
                char c1 = map2.get(idx1);

                int idx2 = row2*5+col1;
                char c2 = map2.get(idx2);

                newStr = ""+c1+c2;
            }

            System.out.print(newStr);
        }
    }
}