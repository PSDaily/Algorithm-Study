import java.io.IOException;
import java.util.HashMap;

public class Problem_kakao_intern1 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        // 두 사람 사이에서 선물 적게 받은 사람이 받는다
// 수가 같거나 기록이 없다면 -> 선물 지수가 큰 사람이 받음
// 선물지수 = 남에게 준 선물 개수 - 내가 받은 선물 개수
// 선물 지수가 같다면 안받음
        String[] param1 = new String[]{"joy", "brad", "alessandro", "conan", "david"};
        String[] param2 = new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};

        int result = solution(param1, param2);
        System.out.println(result);

    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int numOfPerson = friends.length;
        int[][] darr = new int[numOfPerson][numOfPerson];   // darr[a][b]:a가 b에게 준 선물 수
        int[] result=new int[numOfPerson];
        int[] present = new int[numOfPerson];

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<numOfPerson;i++)
        {
            map.put(friends[i],i);
        }

        // calculate darr & present
        for(int i=0;i<gifts.length;i++)
        {
            String s=gifts[i];
//            StringTokenizer tokens=new StringTokenizer(s, " ");
//            String from=tokens.nextToken();
//            String to=tokens.nextToken();
            String[] cur = s.split(" ");
            int fromIdx = map.get(cur[0]);
            int toIdx = map.get(cur[1]);

            present[fromIdx]++;
            present[toIdx]--;
            darr[fromIdx][toIdx]++;
        }

        // calculate future
        for(int i=0;i<numOfPerson-1;i++)
        {
            for(int j=i+1;j<=numOfPerson-1;j++)
            {
                int numI=darr[i][j];
                int numJ=darr[j][i];

                if(numI==numJ)
                {
                    //선물 지수 계산
                    int coinI = present[i];
                    int coinJ = present[j];

                    if(coinI==coinJ) continue;
                    else{
                        result[coinI>coinJ?i:j]++;
                    }
                }else {
                    result[numI>numJ?i:j]++;
                }
            }
        }

        int max=0;
        for(int i=0;i<numOfPerson;i++)
        {
            if(result[i]>max)
                max=result[i];
        }

        answer=max;
        return answer;
    }


}
