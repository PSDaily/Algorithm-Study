package programmers.algorithm.recursion;

class Q150367 {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i=0;i<numbers.length;i++){
            long number = numbers[i];

            // 이진수로 바꾸기
            String twoNum = makeTwo(number,"");

            // 길이가 2^h이 되도록 앞에 0 추가
            int n = 0;
            int length = twoNum.length();
            while((1<<n) -1 < length){
                n++;
            }
            int binTreeSize = (1<<n)-1;

            while(binTreeSize > twoNum.length()){
                twoNum = "0"+twoNum;
            }

            // 가운데를 루트로 잡고 재귀적으로 왼쪽/오른쪽 서브트리 확인
            if(available(twoNum,false)){
                answer[i] = 1;
            }
        }

        return answer;
    }


    static String makeTwo(long number, String twoNumber){
        if(number == 1){
            return "1"+twoNumber;
        }

        twoNumber = number%2 + twoNumber;
        return makeTwo(number/2,twoNumber);
    }

    static boolean available(String str, boolean parentIsDummy){
        char mid = str.charAt(str.length()/2);

        if(parentIsDummy && mid == '1'){
            return false;
        }
        if(str.length() == 1){
            return true;
        }

        String left = str.substring(0,str.length()/2);
        String right = str.substring(str.length()/2+1);

        boolean isDummy = (mid == '0');

        return available(left,isDummy) && available(right,isDummy);
    }
}