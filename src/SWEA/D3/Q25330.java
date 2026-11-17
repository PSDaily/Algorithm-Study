package SWEA.D3;

import java.util.Scanner;
class Q25330
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String s = sc.next();
            boolean isTrue = true;
            for(int i=0;i<=9;i++){
                int cnt = 0;
                int between = 0;
                for(char c:s.toCharArray()){
                    if(i==c-'0'){
                        cnt++;
                    }
                    else{
                        if(cnt==1){
                            between++;
                        }
                    }
                }

                if((cnt == 2 && between==i) || cnt == 0){
                    continue;
                }
                else{
                    isTrue = false;
                }

            }
            if(isTrue){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }
    }
}