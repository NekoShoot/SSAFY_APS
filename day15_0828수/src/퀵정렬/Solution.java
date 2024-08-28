package 퀵정렬;

import java.util.Arrays;

public class Solution {
	/*
	 * Pivot 활용 -> 배열 2개의 부분(pivot보다 작냐 크냐)으로 분할 -> 재귀적으로 정렬
	 * pivot 설정 필요, i와 j의 위치 필요(pivot과 대소비교할 요소를 탐색할 index)
	 * Hoare Partition vs. Lomuto Partition
	 */
	
	static int[] arr1 = { 2, 79, 13, 12, 3, 5, 99, 1, 47, 35 };	
	// 원래 배열에서 swap으로 정렬을 시행하므로 새로운 배열 필요X
	
	// Hoare 파티션
	// int타입 반환 필요(pivot의 idx)
	static int hoare_partition(int left, int right) {
		// pivot -> 가장 첫 값
		int pivot = arr1[left];
		int L = left+1; // pivot을 제외한 배열 중 가장 첫 값
		int R = right; // 피벗을 제외한 배열 중 가장 마지막 값
		
		while(L <= R) { // L은 정방향, R은 역방향으로 탐색하기 때문에
			// 정방향 탐색시
			while(L <= R && arr1[L] <= pivot) L++; // 작은 값들을 만나면 인덱스 증가(큰 값 탐색)
			// 역방향 탐색시
			while(arr1[R] > pivot) R--; // 큰 값들을 만나면 그냥 넘기기(작은 값 탐색)
			
			// 반복이 끝나면 처음 만난 피벗보다 큰 값(정방향)과 작은 값(역방향)의 인덱스가 각각 L, R에 저장돼있음
			
			// L이 R보다 작으면 swap, 같으면 그대로 놔두면 됨!
			if(L < R) {
				int tmp = arr1[L];
				arr1[L] = arr1[R];
				arr1[R] = tmp;
			}
			
		}
		
		// 반복이 끝난 후 피벗(arr[left]와 가장 마지막에 swap된 작은 값을 swap하기!
		// -> 가장 마지막에 swap된 작은 값은 작은 값들과 큰 값들의 경계에 위치하기 때문
		// 반복이 끝나는 지점 -> R < L -> arr[R] 이하는 전부 pivot보다 작은 값
		// arr[L] 이상은 전부 pivot보다 큰 값!
		int tmp = arr1[left];
		arr1[left] = arr1[R];
		arr1[R] = tmp;

		return R;
	}
	
	// 파티션으로 정렬
	static void quickSort_hoarePartition(int left, int right) {
		if(left < right) { // 기저 조건
			int pivot = hoare_partition(left, right); // 논리적으로 분할하기 전 배열의 피벗
			quickSort_hoarePartition(left, pivot-1); // 피벗을 제외한 왼쪽 배열
			quickSort_hoarePartition(pivot+1, right); // 피벗을 제외한 오른쪽 배열
		}
	}
	
	// main
	public static void main(String[] args) {
		System.out.println(Arrays.toString(arr1));
		quickSort_hoarePartition(0, arr1.length-1);
		System.out.println(Arrays.toString(arr1));
					
		System.out.println(Arrays.toString(arr2));
		quickSort_lomutoPartition(0, arr2.length-1);
		System.out.println(Arrays.toString(arr2));
	}
	
	static int[] arr2 = { 2, 79, 13, 12, 3, 5, 99, 1, 47, 35 };
	// Lomuto 파티션
	
	static int lomuto_partition(int left, int right) {
		// 피벗은 가장 마지막 요소
		int pivot = arr2[right];
		int i = left - 1;
		// 정방향 순회로 j를 늘려가면서 요소 값 확인(피벗 제외)
		for(int j = left; j <= right-1; j++) {
		// 그 반복문 안에서 피벗보다 작은 값을 만나면 i++ 후 i와 j 위치를 swap
			if(arr2[j] <= pivot) {
				i++;
				int tmp = arr2[i];
				arr2[i] = arr2[j];
				arr2[j] = tmp;				
			}
		// 시각적으로 생각해 봤을 때, i와 j가 같은 위치면 아무 일도 일어나지 않고 
		// 피벗보다 큰 값을 만나다가 다시 작은 값을 만나는 순간 swap이 일어남
		// 즉, 스왑한 위치중 왼쪽을 기준으로, 그 값을 포함해 왼쪽은 피벗보다 작은 값, 오른쪽은 피벗보다 큰 값들이 정렬됨			
		
		}
		// 반복이 끝난 후, i가 경계에 있음(피벗보다 작은 값들의 경계)
		// 피벗은 가장 마지막 요소이므로, i+1과 swap해서 배열을 두 개로 분할
		int tmp = arr2[i+1];
		arr2[i+1] = arr2[right];
		arr2[right] = tmp;
		
		return i+1;
	}
	
	static void quickSort_lomutoPartition(int left, int right) {
		if(left >= right) return; // 기저조건
		
		// 재귀 부분
		int pivot = lomuto_partition(left, right); // 반환된 피벗 위치
		quickSort_lomutoPartition(left, pivot-1); // 논리적으로 분할 왼쪽 부분
		quickSort_lomutoPartition(pivot+1, right); // 논리적으로 분할된 오른쪽 부분
	}
	
}