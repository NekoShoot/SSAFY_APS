package counting_sort;

import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		// 랜덤 숫자를 넣을 배열 생성
		int[] arr = {0, 4, 1, 3, 1, 2, 4, 1};
		
		// 배열 숫자 채우기
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = (int) (Math.random() * 100);
//		}
		
		int max = -1;
		// counts와 acculmul배열 길이를 위해 최대값 찾기
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		// counts arr 
		int[] cntArr = new int[max+1];

		// cnt 값 채우기
		for(int i = 0; i < arr.length; i++) {
			cntArr[arr[i]]++;
		}
		
		// cnt를 acc로 만들기
		// 기존 cnt를 바꿔주는거라 cnt[0]은 개수가 곧 몇 번째 위치까지 등장하는가를 나타내줌
		for(int i = 1; i < cntArr.length; i++) {
			cntArr[i] += cntArr[i-1]; 
		}
		
		// 정렬된 배열
		int[] sortedArr = new int[arr.length];
	
		// 역방향 순회하면서 원소 정렬
		// 안정 정렬을 위해
		// 1. 원본 arr의 값을 인덱스로 가지는 곳(acc)으로 간다
		// 2. 그 값은 arr의 값이 쓰일 수 있는 자리인데, 인덱스화 하기 위해 1을 뺀다
		// 3. 그 자리를 썼기 때문에, 그 자리 값을 1개 빼준다
		for(int i = arr.length-1; i >= 0; i--) {
			sortedArr[cntArr[arr[i]] - 1] = arr[i];
			cntArr[arr[i]]--;
		}	
		
	}
}
