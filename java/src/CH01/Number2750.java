package CH01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Number2750 {
    static int[] arr, temp;

    public static void main(String[] args) throws IOException {

        //숫자 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //숫자 개수
        arr = new int[n]; //입력받을 배열
        temp = new int[n]; //정렬된 배열

        //입력 받기
        for(int i=0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //병학 정렬
        mergeSort(0, n-1);

        //출력
        StringBuilder sb = new StringBuilder();
        for (int num : arr){
            sb.append(num).append('\n');
        }
        System.out.print(sb);
    }

    //병합 정렬 함수
    static void mergeSort(int left, int right){
        if (left < right){
            int mid = (left + right) / 2;

            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    static void merge(int left, int mid, int right){
        int i = left; //왼쪽 배열 시작
        int j = mid + 1; //오른쪽 배열 시작
        int k = left; //임시 배열 인덱스

        while (i <= mid && j <= right){ //왼쪽, 오른쪽 부분의 배열에 비교할 부분이 남아있는 지 확인
            //arr[i]와 arr[j]의 값을 비교해서 작은거 tmep[k]에 넣기 + 넣은거 다음으로 넘어가기
            if (arr[i] <= arr [j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        //남은 값 복사
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        //정렬된 배열 원본에 복사
        for (int t = left; t<=right; t++) {
            arr[t] = temp[t];
        }
    }

}
