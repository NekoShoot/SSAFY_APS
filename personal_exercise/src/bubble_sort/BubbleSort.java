package bubble_sort;

import java.util.Arrays;

// 버블 정렬
public class BubbleSort {
	public static void main(String[] args) {
		// 버블 정렬을 실행할 배열 생성
		int[] arr = new int[10];
		
		// 배열에 랜덤한 숫자 채우기
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		
		System.out.println(Arrays.toString(arr));
		
		// 첫 원소부터 자리 교환해가면서 이동
		// 가장 큰 원소가 마지막으로
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp;
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				} else {
					continue;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}
}
