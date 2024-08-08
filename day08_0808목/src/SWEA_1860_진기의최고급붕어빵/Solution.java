package SWEA_1860_진기의최고급붕어빵;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	// 우선순위 큐
	static List<Integer> pq = new LinkedList<>(); // Priority Queue
	static int front = -1;
	static int rear = -1;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_1860_진기의최고급붕어빵/input.txt"));
		/*
			1. T 받기
			2. N, M, K 받기
			3. List만들고 N번 순회해서 각 손님들이 오는 시간을 해당 인덱스에 삽입(3초면 i==3인 곳에)
				- 이 때 s의 최대값 구하기
			4. sMax 만큼 순회해서 누적합 구하기, 이 때 M 배수에는 K를 먼저 더하고 조회.
			5. 4. 순회 동안 누적합이 음수가 되면 Impossible 아니면 Possible 
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케 개수
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 사람 수
			int M = sc.nextInt(); // 붕어빵을 만들 수 있는 시간
			int K = sc.nextInt(); // 붕어빵 개수
			String result = "";
								
//			for(int i = 0; i < N; i++) {
//				int s = sc.nextInt(); // 사람이 오는 시간(초)
//				list.add(s, -1); // 그 시간에 붕어빵 개수 -1
//				if(s > sMax) sMax = s; // s 최대값 저장(순회 길이)
//			}
			// 아무리 동적 자료구조인 list라고 해도, 0부터 차례대로 크기가 커지는 것이지, 
			// 앞 인덱스에 아무것도 없는데 특정 인덱스부터 값을 삽입할 수는 없구나! 
			
			int sMax = 0;
			// 삽입 정렬
			for(int i = 0; i < N; i++) { // 사람 수 만큼 반복
				int data = sc.nextInt(); // 사람이 방문하는 시간
				pq.add(data); // pq에 추가
				if(data > sMax) sMax = data; // 최대값 저장
				
				if(i > 0) { // 2명째부터 삽입 정렬
					offer(data); 
				}
			}
					
			
			// 대기줄 + 붕어빵 납품 어레이
			int[] line = new int[sMax+1];			

			int sum = 0;
			// 어레이 채우기
			for(int i = 0; i < line.length; i++) {				
				if(i < N) {
					line[pq.get(i)]--; // 손님이 오는 시간에 -1개씩
				}
				
			}
			
			for(int i = 0; i < line.length; i++) {
				if(i % M == 0 && i != 0) line[i] += K; // 0이 아닌 M의 배수 시간에 K개의 붕어빵 더하기
				
				sum += line[i]; // 이미 pq는 정렬돼있으므로 이 순환 안에서 체크 가능 
				
				if(sum < 0) {
					result = "Impossible";
					break;
				}
			}
			
			while(!pq.isEmpty()) pq.remove(0);
			front = -1;
			rear = -1;

			if(sum >= 0) result = "Possible";
//			
			System.out.printf("#%d %s\n", test_case, result);
//			
//			// queue 비우기
//			while(!isEmpty()) {				
//				remove();
//			}
//			
		}
//		
	}
	
	static boolean isEmpty() {
		return front == rear;
	}
	
	// enQueue
	static void offer(int data) {
		int u = ++rear; // u == unsorted, 데이터가 새로 들어오면 일단 한 칸 늘림!
		// s == sorted
		for(int s = u - 1; s >= 0; s--) { // 역방향 순회			
			if(pq.get(s) > data) { // 앞 값이 지금 값보다 크면  
				pq.set(s+1, pq.get(s)); // 한 칸 뒤로 땡김!(아직 data를 queue에 저장하지 않았음)
				
			} else { // 앞 값이 지금 값 보다 작으면 data가 들어갈 자리!
				pq.set(s+1, data); // 이전에 밀어서 비워뒀으니 거기에 슉~
				break; // break 안 걸어줘서 반복문이 계속 돌아서 덮어쓰기를 해버렸네 
			}
		}
				
	}
	
	static void remove() {
		pq.get(++front);
	}
}
