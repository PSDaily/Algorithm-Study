package programmers.algorithm.twopointer;

// 틀린 답안 -> 배열 고정되면 안됨
class Q118667 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        // queue1, queue2를 잇고, 누적합 구하기
        long[] sum = new long[queue1.length+queue2.length];
        sum[0] = queue1[0];
        for(int i=1;i<queue1.length;i++){
            sum[i] = sum[i-1]+queue1[i];
        }
        for(int i=queue1.length;i<queue1.length+queue2.length;i++){
            sum[i] = sum[i-1]+queue2[i-queue1.length];
        }

        for(long i:sum){
            System.out.print(i+" ");
        }
        System.out.println();

        // queue2, queue1를 잇고, 누적합 구하기
        long[] sum2 = new long[queue1.length+queue2.length];
        sum2[0] = queue2[0];
        for(int i=1;i<queue2.length;i++){
            sum2[i] = sum2[i-1]+queue2[i];
        }
        for(int i=queue2.length;i<queue1.length+queue2.length;i++){
            sum2[i] = sum2[i-1]+queue1[i-queue2.length];
        }

        for(long i:sum2){
            System.out.print(i+" ");
        }
        System.out.println();

        if(sum[queue1.length+queue2.length-1]%2==0){
            long finish = sum[queue1.length+queue2.length-1]/2;
            System.out.println("finish = "+finish);

            int min = Integer.MAX_VALUE;
            for(int i=1;i<sum.length-queue2.length;i++){
                // queue2 구간만큼
                if(sum[i+queue2.length-1]-sum[i-1] == finish){
                    int count = 0;
                    count += i; // queue1 pop횟수
                    count += queue2.length-(queue1.length-i);// queue2 pop횟수

                    System.out.println("queue1 = "+i);
                    System.out.println("queue2 = "+(queue2.length-(queue1.length-i)));
                    System.out.println("count = "+count);

                    min = Math.min(count,min);
                }
            }

            for(int i=1;i<sum2.length-queue1.length;i++){
                // queue1 구간만큼
                System.out.println(sum2[i+queue1.length-1]-sum2[i-1]);
                if(sum2[i+queue1.length-1]-sum2[i-1] == finish){
                    int count = 0;
                    count += i; // queue2 pop횟수
                    count += queue1.length-(queue2.length-i);// queue1 pop횟수

                    System.out.println("queue2 = "+i);
                    System.out.println("queue1 = "+(queue1.length-(queue2.length-i)));
                    System.out.println("count = "+count);

                    min = Math.min(count,min);
                }
            }

            if(min == Integer.MAX_VALUE){
                answer = -1;
            }
            else{
                answer = min;
            }
        }
        else{
            answer = -1;
        }

        return answer;
    }
}