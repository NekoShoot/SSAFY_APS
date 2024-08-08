package queue;

import java.util.Arrays;

public class InsertionSort {
	static int[] queue = new int[100];
	static int front = -1, rear = -1;
	

	public static void main(String[] args) {
		int[] arr = new int[] {69, 10, 30, 2, 16, 8, 31, 22};
		
		// 삽입 정렬
		// u: Unsorted 집합의 원소
		for(int u = 1; u < arr.length; u++) { // 첫번째 원소는 자동으로 정렬된 상태이므로
			int data= arr[u];
					
			int s;
			for(s = u-1; s >= 0 && arr[s] > data; s--) { // 내 바로 앞까지가 정렬된 곳이고, 그걸 역방향으로 순회
				arr[s + 1] = arr[s]; 
				// 순회를 돌면서 data(지금 내 값)보다 내 바로 앞 값이 크면 자리 교체
				// data를 tmp라고 봐도 무방!
			}
			arr[s + 1] = data;
			// 반복문 안에서 if문으로 해결하는 것이 아니라 반복문 조건을 추가로 설정하는 방법
			System.out.println(Arrays.toString(arr));
		}

	}
	
	
	static void enQueue(int data) {
		queue[++rear] = data;
		int i = rear;
		int j;
		for(j = i-1; j >= 0 && queue[j] > data; j--) {
			queue[j + 1] = queue[j];
		}
		
		queue[j + 1] = data;
	}
	
	static int deQueue() {
		return queue[++front];
	}

}
