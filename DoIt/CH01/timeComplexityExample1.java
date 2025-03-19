public class timeComplexityExample1{
    public static void main(String[] args){
        //choose the random number between 1~100
        int targetNumber = (int)(Math.random()*100);
        for(int i=0 ; i<100 ; i++){
            if(i==targetNumber){
                System.out.println(i);
                break;
            }
        }
    }
}