package SWEA_2930_힙;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {	
	static int heapSize = 0;	
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_2930_힙/input.txt"));
		// 최대 힙 구현
		/*
		 * 첫 줄 테케 개수 T
		 * 각 테케 첫 줄 수행해야하는 연산 수 1<= N <= 10^5
		 * 둘째 줄부터 N개의 줄 -> 수행해야하는 연산 정보
		 * 연산 1: 자연수 x 삽입이면 2개의 자연수 '1, x' input
		 * 	-> x(1 <= x <= 10^9)를 최대 힙에 추가
		 * 연산 2: 최대 힙의 루트 노드 키 값 출력 후 해당 노드 삭제 -> '2' input
		 * -> 출력해야 할 값이 없다면 -1 출력 (size == 0)
		 * 
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt(); // 테케 개수
		for(int test_case = 1; test_case <= T; test_case++) {			
			int N = sc.nextInt(); // 연산 개수
			int[] heap = new int[N+1];
			
			// N개의 연산 수행
			for(int i = 0; i < N; i++) {
				int cal = sc.nextInt();
				switch(cal) {
					case 1: 
						int input = sc.nextInt();
						offer(heap, input);
						break;
					case 2:
						int output = poll(heap);
						sb.append(output + " ");
				}
				
			}			
			
			sb.deleteCharAt(sb.length()-1); // 마지막 공백 삭제			
			String result = sb.toString();			
			System.out.printf("#%d %s\n", test_case, result);
			
			heapSize = 0; // 힙 사이즈 초기화
			sb.delete(0, sb.length());
		}		
			
	}
	
	// 자리 변경
	static void swop(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	// 삽입	
	// 가장 마지막에 값을 넣은 후 부모와의 대소 비교를 통해 swop 반복해서 정위치 찾기	
	static void offer(int[] heap, int data) {
		// 1. 0번째 인덱스는 사용하지 않기 때문에 i == heapSize인 곳에 넣으면 됨 
		heap[++heapSize] = data;
		// 2. 부모의 값이 자기보다 작으면 swop
		// 부모 인덱스는 child/2
		int parent = heapSize / 2;
		int child = heapSize; // 왼쪽 자식 노드
		
		// 자식 노드가 루트 노드가 되면 스왑 더 이상 불가능 
		while(heap[parent] < heap[child] && child != 1) {
			swop(heap, parent, child); // 스왑
			
			// 3. 재귀식으로 모든 노드가 정위치를 찾도록
			// child부터 올라가는 과정
			child = parent;
			parent = child / 2;
		}		
		
	}
	
	// 삭제 및 반환
	// 루트의 노드 삭제 후 완전 이진 트리와 힙 구성 유지
	static int poll(int[] heap) {
		// 원소가 없을 경우 -1 출력
		if(heapSize == 0) return -1;
		
		// 1. 루트의 원소 저장
		int item = heap[1];
		
		// 2. 마지막 노드를 루트로 옮기고 사이즈 줄여서 노드 삭제
		heap[1] = heap[heapSize--];
		
		// 3. 루트부터 시작해 부모가 자식보다 작으면 swop
		int parent = 1; // root
		int child = parent * 2; // 왼쪽 자식 노드 
		
		// 3-1. 자식 노드 중 더 큰 값 탐색
		if(child+1 <= heapSize && heap[child] < heap[child+1]) child++;
		
		while(child <= heapSize && heap[parent] < heap[child]) {
			swop(heap, parent, child);
			
			// 3-2. 재귀식으로 모든 노드가 정위치를 찾도록
			// parent부터 내려가는 과정
			parent = child;
			child = parent * 2;
			if(child+1 <= heapSize && heap[child] < heap[child+1]) child++;			
		}
		
		return item;
	}
	
}