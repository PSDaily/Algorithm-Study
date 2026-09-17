package programmers.algorithm.simulation;

class Q468371 {
    public int solution(int[][] signals) {

        int limit = 1;
        for(int[] signal: signals){
            int period = signal[0] + signal[1] + signal[2];
            limit = lcm(limit,period);
        }

        for(int j=1;j<limit;j++){
            boolean yellow = true;
            for(int i=0;i<signals.length;i++){
                int g = signals[i][0];
                int y = signals[i][1];
                int r = signals[i][2];

                if(!(j%(g+y+r)>=(g+1) && j%(g+y+r)<=(g+y))){
                    yellow = false;
                    break;
                }
            }
            if(yellow){
                return j;
            }
        }

        return -1;
    }

    static int gcd(int a, int b){
        while(b!=0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }

    static int lcm(int a, int b){
        return a/gcd(a,b)*b;
    }
}