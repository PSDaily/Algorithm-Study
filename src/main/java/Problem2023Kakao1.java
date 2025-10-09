import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem2023Kakao1 {
	public static void main(String[] args) {
		Solution s = new Solution();
		String today = "2024.01.01";
		String[] terms = {"A 12", "B 20", "C 3"};
		String[] privacies = {"2023.01.01 A", "2023.01.02 B", "2023.12.28 C"};
		System.out.println(Arrays.toString(s.solution(today, terms, privacies)));
	}

	static class Solution {
		public int[] solution(String today, String[] terms, String[] privacies) {

			// parsing today
			StringTokenizer st = new StringTokenizer(today, ".");
			int tyear = Integer.valueOf(st.nextToken());
			int tmonth = Integer.valueOf(st.nextToken());
			int tday = Integer.valueOf(st.nextToken());

			int[] answer = {}; // 1indexed
			List<Integer> answerList = new ArrayList<>();
			// parsing terms
			int numOfTerms = terms.length;
			Map<Character, Integer> termsMap = new HashMap<>();
			parseTerms(terms, numOfTerms, termsMap);

			// when
			for(int i=0; i<privacies.length; i++){
				// 각 프라이버시별 유효날짜 구하기
				StringTokenizer tokens2 = new StringTokenizer(privacies[i], " ");
				String daymonthyear = tokens2.nextToken();
				char term = getTerm(tokens2);

				// from date
				Result fromDate = getResult(daymonthyear);

				// expired date
				int emonth, eday, eyear;
				eday=-1;
				emonth = fromDate.month() + termsMap.get(term);
				if(emonth > 12){
					eyear = fromDate.year() + (emonth - 1)/12;
					emonth = (emonth - 1) % 12 + 1;
				}else{
					eyear= fromDate.year();
				}

				// day -1 하기
				if(fromDate.day() != 1){
					eday = fromDate.day() -1;
				}else if (fromDate.day() == 1){
					eday = 28;
					if(emonth == 1){
						emonth = 12;
						eyear--;
					}else{
						emonth--;
					}
				}

				// 오늘보다 과거인지 validate
				if(eyear < tyear){
					answerList.add(i+1);
					continue;
				}
				else if(eyear > tyear) continue;

				if(emonth < tmonth){
					answerList.add(i+1);
					continue;
				}
				else if(emonth > tmonth) continue;

				if(eday < tday){
					answerList.add(i+1);
					continue;
				}
				else continue;
			}

			answer = new int[answerList.size()];
			for (int i = 0; i < answerList.size(); i++) {
				answer[i] = answerList.get(i);
			}

			return answer;
		}

		private static Result getResult(String daymonthyear) {
			StringTokenizer tokens3=new StringTokenizer(daymonthyear, ".");
			int year = Integer.valueOf(tokens3.nextToken());
			int month = Integer.valueOf(tokens3.nextToken());
			int day = Integer.valueOf(tokens3.nextToken());
			Result result = new Result(year, month, day);
			return result;
		}

		private record Result(int year, int month, int day) {
		}

		private static char getTerm(StringTokenizer tokens) {
			return tokens.nextToken().charAt(0);
		}

		private static void parseTerms(String[] terms, int numOfTerms, Map<Character, Integer> termsMap) {
			for(int i = 0; i< numOfTerms; i++){
				StringTokenizer tokens = new StringTokenizer(terms[i], " ");
				char alphabet = tokens.nextToken().charAt(0);
				int duration = Integer.valueOf(tokens.nextToken());

				termsMap.put(alphabet, duration);
			}
		}
	}
}
