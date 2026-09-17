package programmers.algorithm.bitmasking;

class Q468377 {
    public int solution(int[][] cost, int[][] hint) {
        int answer = Integer.MAX_VALUE;
        int n = cost.length; // stage 수

        // 모든 경우의 수
        // mask -> 1인 번들을 삼
        for(int mask=0; mask<(1<<n); mask++){
            int total = 0;

            // 각 stage에서 사용할 수 있는 힌트 개수
            int[] hintCount = new int[n];

            // 1. 어떤 번들을 샀는지 확인
            for(int i=0;i<n-1;i++){

                // i번째 번들 샀다면
                if((mask & (1<<i)) != 0){

                    // 번들 구매 비용
                    total += hint[i][0];

                    // 그 번들에 들어있는 힌트권들 추가
                    for(int j=1; j<hint[i].length; j++){
                        int stage = hint[i][j] - 1;

                        // 해당 stage에서 쓸 수 있는 힌트 +1
                        hintCount[stage]++;
                    }

                }
            }

            // 2. 각 stage 해결 비용 더하기
            for(int i=0;i<n;i++){
                int count = hintCount[i];

                // 한 stage에서 최대 n-1개 사용 가능
                count = Math.min(count,n-1); // 힌트권을 샀다면 무조건 쓰는게 이득

                total += cost[i][count];
            }


            // 3. 최소값 갱신
            answer = Math.min(answer,total);
        }

        return answer;
    }
}