import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //첫 줄의 수의 개수를 N에 저장
        int N = input.nextInt();
        //크기가 N인 배열 A 선언
        int[] A = new int[N];
        //배열 A에 입력으로 들어온 정수 삽입
        for (int i = 0; i<N; i++){
            A[i] = input.nextInt();
        }

        //시간 복잡도를 고려하여 병합 정렬 채택
        mergeSort(A, 0, N-1);

        //정렬된 배열 출력
        for (int num : A){
            System.out.println(num);
        }

        input.close();
    }

    //병렬 정렬 함수
    public static void mergeSort(int[] A, int left, int right){
        if (left < right){
            int mid = (left + right)/2;

            //왼쪽 반 정렬
            mergeSort(A, left, mid);
            //오른쪽 반 정렬
            mergeSort(A, mid+1, right);

            //정렬된 두 부분 병합
            merge(A, left, mid, right);
        }
    }

    //두 부분을 병합하는 함수
    public static void merge(int[] A, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //임시 배열 생성
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        //데이터 복사
        for (int i=0; i<n1; i++){
            leftArray[i] = A[left + i];
        }
        for (int j=0; j<n2; j++){
            rightArray[j] = A[mid + 1 + j];
        }

        //병합과정
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                A[k] = leftArray[i];
                i++;
            } else {
                A[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //남은 요소들 복사
        while (i < n1) {
            A[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            A[k] = rightArray[j];
            j++;
            k++;
        }
    }
}