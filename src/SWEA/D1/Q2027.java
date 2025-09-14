package SWEA.D1;

import java.io.FileInputStream;

public class Q2027 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        for(int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                if(i==j){
                    System.out.printf("%s","#");
                }
                else{
                    System.out.printf("%s","+");
                }
            }
            System.out.println();
        }
    }
}
