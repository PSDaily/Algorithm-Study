package programmers.algorithm.bruteforce;

class Q60059 {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        int k = key.length;
        int l = lock.length;

        int count = 0;
        for(int i=0;i<l;i++){
            for(int j=0;j<l;j++){
                if(lock[i][j]==0){
                    count++;
                }
            }
        }

        // 회전
        outer:
        for(int t=0;t<4;t++){

            // 이동
            for(int m=0;m<k+l-1;m++){
                for(int m2=0;m2<k+l-1;m2++){
                    int size = l+2*(k-1);
                    int[][] keyMoved = new int[size][size];

                    // 열쇠 이동
                    for(int i=0;i<k;i++){
                        for(int j=0;j<k;j++){
                            keyMoved[m+i][m2+j] = key[i][j];
                        }
                    }

                    int count2 = 0;
                    for(int i=0;i<l;i++){
                        for(int j=0;j<l;j++){
                            if(keyMoved[i+k-1][j+k-1] + lock[i][j] == 1){
                                count2++;
                            }
                            else{
                                break;
                            }
                        }
                    }

                    if(count2 == l*l){
                        answer = true;
                        break outer;
                    }
                }
            }

            int[][] keyTurned = new int[k][k];
            for(int i=0;i<k;i++){
                for(int j=0;j<k;j++){
                    keyTurned[i][j] = key[j][k-i-1];
                }
            }

            key = keyTurned;
        }

        return answer;
    }
}