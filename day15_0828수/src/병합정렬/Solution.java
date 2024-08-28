package 병합정렬;

import java.util.Arrays;

public class Solution {
	/*
	 * 배열 절반 분할 -> 각 부분을 재귀적으로 정렬 -> 다시 병합해 전체 배열 정렬
	 * mergeSort()와 merge()필요
	 * 
	 * 정렬 배열 sortedArr 필요
	 */
	static int[] arr = { 2, 79, 13, 12, 3, 5, 99, 1, 47, 35 };
	static int N = arr.length; // 배열 크기 -> 정렬된 배열 크기 할당에 필요
	static int[] sortedArr = new int[N];
	
	static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽 배열의 시작점
		int R = mid + 1; // 오른쪽 배열의 시작점
		
		int idx = left; // 정렬 배열의 시작 인덱스
		
		
		while(L <= mid && R <= right) { // 왼쪽 배열의 범위와 오른쪽 배열 범위 탐색
			// 양쪽 배열을 병합할 때 정렬 
			// -> 새로운 배열에 정렬된 형태로 넣고 그걸 다시 원래 배열에 덮어씌우는 방식 
			if(arr[L] <= arr[R]) sortedArr[idx++] = arr[L++]; // 왼쪽 첫 값이 더 작으면 왼쪽부터 넣기
			else sortedArr[idx++] = arr[R++]; // 오른쪽 첫 값이 더 작으면 오른쪽부터 넣기
		}
		
		// 반복이 끝난 후, 왼쪽과 오른쪽 개수가 다를 수 있고, 마지막에 비교된 값은 정렬된 배열에 들어가지 않으므로,
		// ** 더 길다고 항상 남는 것은 아님 **
		// {10, 20, 30, 40 } { 50, 60, 70}
		// -> 왼쪽 배열의 10~40이 다 들어가고 나면, 다음 반복에서 L이 mid를 넘어가게 되므로 while문 종료
		// -> 그러므로 오른쪽 3개가 남는다.
		
		if(L <= mid) { // 왼쪽이 남았다면
			// 남은 값들 다 넣어주기(재귀적 반복에 의해 이미 이전 값들은 정렬 돼 있는 상태)
			for(int i = L; i <= mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		} else { // 오른쪽이 남았다면
			// 남은 값들 다 넣어주기(재귀적 반복에 의해 이미 이전 값들은 정렬 돼 있는 상태)
			for(int j = R; j <= right; j++) {
				sortedArr[idx++] = arr[j];
			}
		}
		
		// 정렬된 배열을 원 배열에 덮어쓰기
		// 재귀적으로 돌아가니까, left(왼쪽 시작점)부터 right(오른쪽 끝점)까지! 
		for(int i = left; i < right; i++) {
			arr[i] = sortedArr[i];
		}
				
	}
	
	static void mergeSort(int left, int right) {
		if(left >= right) return; // 더 이상 분할할 수 없을 때를 위한 범위 체크
		
		// 배열 절반 분할
		int mid = (left + right) / 2; // <- left+right가 int 범위 안 일때만
		// 재귀적 정렬
		mergeSort(left, mid); // 왼쪽 배열
		mergeSort(mid+1, right); // 오른쪽 배열
		
		merge(left, mid, right); // 재귀 끝난 후 다시 병합
	}
	
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(arr));
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}
}