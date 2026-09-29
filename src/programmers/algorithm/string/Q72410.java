package programmers.algorithm.string;

class Q72410 {
    public String solution(String new_id) {
        String answer = "";

        // 1
        answer = new_id.toLowerCase();

        // 2
        answer = answer.replaceAll("[^a-z0-9-_.]","");

        // 3
        answer = answer.replaceAll("\\.+",".");

        // 4
        if(!answer.isEmpty() && answer.charAt(answer.length()-1)=='.'){
            answer = answer.substring(0,answer.length()-1);
        }
        if(!answer.isEmpty() && answer.charAt(0)=='.'){
            answer = answer.substring(1,answer.length());
        }

        // 5
        if(answer.isEmpty()){
            answer = "a";
        }

        // 6
        if(answer.length() >= 16){
            answer = answer.substring(0,15);

            if(answer.charAt(14)=='.'){
                answer = answer.substring(0,14);
            }
        }

        // 7
        while(answer.length() < 3){
            answer += answer.charAt(answer.length()-1);
        }


        return answer;
    }
}