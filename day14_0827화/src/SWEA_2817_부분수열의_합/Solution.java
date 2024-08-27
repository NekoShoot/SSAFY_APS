package SWEA_2817_부분수열의_합;

import java.io.*;
import java.util.*;

public class Solution {
	static int[] sequence; // 수열 저장할 배열
	static int N; // 수열 안에 들어가는 자연수 개수
	static int K; // 합으로 맞춰야할 타겟
	static int cnt; // 가능한 경우의 수
	
	static void recursive(int idx, int sum) {
		if(sum == K) { // K가 되는 경우
			cnt++;
			sum = 0;
			return;
		} else if(sum > K) { // K가 될 수 없는 경우
			sum = 0;
			return;
		}
		
		if(idx > N-1) return;
		
		// idx번째 숫자를 선택한다 
		sum += sequence[idx];
		recursive(idx+1, sum);
		
		// idx번째 숫자를 선택하지 않는다
		sum -= sequence[idx]; // 위에서 이미 더했기 때문에 롤백
		recursive(idx+1, sum);
		
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_2817_부분수열의_합/input.txt"));
		/*
		 * 수열 A에 대해 최소 1개 이상의 수를 선택해 그 합이 K가 되는 경우의 수를 구하라
		 * 
		 * 첫 줄에 테케 T
		 * 각 테케 첫 줄 N, K 
		 * 1 <= N <= 20
		 * 1 <= K <= 1,000
		 * 둘째 줄 N개의 자연수 수열 A(공백 사이에 두고 주어짐)
		 * 수열의 각 자연수는 1이상 100이하
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케 개수
		for(int test_case = 1; test_case <= T; test_case++) {
			cnt = 0;
			N = sc.nextInt(); // 수열 A에 있는 자연수 개수
			K = sc.nextInt(); // 합이 되어야하는 타겟
			
			// 수열 받기
			sequence = new int[N];
			for(int i = 0; i < N; i++) {
				sequence[i] = sc.nextInt();
			}
			
			// 재귀 반복으로 0부터 N-1까지 모든 경우의 수 탐색			
			recursive(0, 0);
			
			System.out.printf("#%d %d\n", test_case, cnt);
		}
		
		
	}
}