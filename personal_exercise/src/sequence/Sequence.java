package sequence;

import java.util.Arrays;

public class Sequence {
	static int[] nums;
	static int N;
	static boolean visited[];
	static int[] result;
	
	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		visited = new boolean[N];
		result = new int[N];

		// 1. 반복문 활용(매우 귀찮다!)
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				if(i != j) { // 중복을 없애기 위해
//					for(int k = 0; k < N; k++) {
////						System.out.printf("%d %d %d\n", nums[i], nums[j], nums[k]); // <- 중복 순열
//						if(i != k && j != k) {
//							System.out.printf("%d %d %d\n", nums[i], nums[j], nums[k]);
//						}
//						
//					}
//				}
//			}
//		}
		
		// 2. swap 방식
//		perm(0);
		
		// 3. 방문 체크 방식
//		visit(0);
		
		// 4. bitmasking
		// -> visitBit <- 방문했는지 기록하기 위한 정수
		bitMasking(0, 0);
		
	} //main
	
	// ==== bit masking ====
	static void bitMasking(int idx, int visitBit) {
		// 기저 조건
		if(visitBit == (1<<N) - 1) { // 모든 값이 1로(방문O) 채워져 있는가?
			System.out.println(Arrays.toString(result));
			return;
		}
		
		// 비트마스킹 (1 << i) <- i번째만 1이고 나머지가 0인 수
		for(int i = 0; i < N; i++) {
			if((visitBit & (1 << i)) != 0) continue; // i번째 요소를 방문했다고 체크(&연산하면 하나만 1이면 값을 1로 도출)
			
			result[idx] = nums[i];
			bitMasking(idx+1, visitBit | (1<<i)); // 다음 자리 판단
		}
	}
	
	
	// ==== visit check ====
	// 결과 배열에 저장할 위치(원본 배열 아님)
	static void visit(int idx) {
		// 기저 조건
		if(idx == N) System.out.println(Arrays.toString(result));
		
		// 재귀 부분
		for(int i = 0; i < N; i++) {
			// 사용하지 않은 원소를 가지고 만들어야 한다
			if(visited[i]) continue;
			result[idx] = nums[i];
			visited[i] = true; // i번째 원소 사용 시
			visit(idx+1); // 다음 자리 판단
			visited[i] = false; // result는 덮어써서 초기화 필요 X			
		}
	}
	
	
	// ===== SWAP =====
	static void perm(int idx) {
		// 기저 조건
		if(idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		// 재귀 부분
		for(int i = idx; i < N; i++) {
			swap(i, idx);
			perm(idx+1);
			swap(i, idx); // 롤백(다음 과정을 위해)
		}
	}
	
	static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;		
	}
}
