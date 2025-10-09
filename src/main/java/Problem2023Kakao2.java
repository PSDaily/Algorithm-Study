import java.util.*;
public class Problem2023Kakao2 {


	static class Solution {
		public long solution(int cap, int n, int[] deliveries, int[] pickups) {
			long answer = 0;
			int dFin = n;
			int pFin = n;
			boolean dFindPositiveFirst = true;
			boolean pFindPositiveFirst = true;

			while(true){
				dFindPositiveFirst = true;
				pFindPositiveFirst = true;

				int dCap = 0;
				int i = n-1;
				// delivery의 fin 값 구하기
				while(canDeliveryOrPickupAndInTheRange(cap, dCap, i)){
					int num = deliveries[i];
					if (num == 0) {
						i--;
						continue;
					} else if (dFindPositiveFirst) {
						dFin = i;
						dFindPositiveFirst = false;
					}
					int couldPut = cap - dCap;
					// 남은 용량이 더 크면 모든 값을 넣고 다음으로 넘긴다
					dCap = putNum(deliveries, couldPut, num, dCap, i);
					i--;
				}
				// pickup의 fin값 구하기
				int pCap = 0;
				int j = n-1;
				// delivery의 fin 값 구하기
				while(canDeliveryOrPickupAndInTheRange(cap, pCap, j)){
					int num = pickups[j];
					if( num == 0){
						j--;
						continue;
					}else if(pFindPositiveFirst){
						pFin = j;
						pFindPositiveFirst=false;
					}
					int couldPut = cap - pCap;
					// 남은 용량이 더 크면 모든 값을 넣고 다음으로 넘긴다
					pCap = putNum(pickups, couldPut, num, pCap, j);
					j--;
				}
				if(deliveryAndPickupFinished(dFindPositiveFirst, pFindPositiveFirst)){
					break;
				}
				answer+= (2 * Math.max(dFindPositiveFirst? -1 : dFin + 1 , pFindPositiveFirst? -1 : pFin + 1));
			}
			return answer;
		}

		private static boolean deliveryAndPickupFinished(boolean dFindPositiveFirst, boolean pFindPositiveFirst) {
			return dFindPositiveFirst && pFindPositiveFirst;
		}

		private static int putNum(int[] pickupsOrDeliveries, int couldPut, int num, int pCap, int j) {
			if(couldPut > num){
				pCap += num;
				pickupsOrDeliveries[j] = 0;
			}else if(couldPut <= num){
				pCap += couldPut;
				pickupsOrDeliveries[j] = num - couldPut;
			}
			return pCap;
		}

		private static boolean canDeliveryOrPickupAndInTheRange(int cap, int dCap, int i) {
			return dCap < cap && i >= 0;
		}
	}
}
