package programmers.algorithm.twopointer;

class Q118667_2 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        long sum = 0;
        int[] arr = new int[queue1.length+queue2.length];
        long current = 0;
        for(int i=0;i<queue1.length;i++){
            arr[i] = queue1[i];
            sum += queue1[i];
            current += queue1[i];
        }
        for(int i=queue1.length;i<queue1.length+queue2.length;i++){
            arr[i] = queue2[i-queue1.length];
            sum += queue2[i-queue1.length];
        }

        if(sum%2 != 0){
            return -1;
        }

        int left = 0;
        int right = queue1.length;
        int count = 0;
        while(count <= queue1.length*3){
            if(current == sum/2){
                return count;
            }

            if(current > sum/2){
                current -= arr[left % (queue1.length*2)];
                left++;
            }

            else{
                current += arr[right % (queue1.length*2)];
                right++;
            }

            count++;
        }

        return -1;
    }
}