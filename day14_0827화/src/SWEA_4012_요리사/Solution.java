package SWEA_4012_요리사;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_4012_요리사/input.txt"));		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		//TODO 1 => T로 바꾸기
		for(int test_case = 1; test_case <= 1; test_case++) {
			int N = sc.nextInt(); // 재료 개수
			int[][] synergy = new int[N][N];
			
			// 시너지
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					synergy[i][j] = sc.nextInt();
				}
			}
						
			// 0 1 ... (N/2)-1까지 선택하는 경우의 수부터 시작
			// N/2 ... N-1까지 선택하는 경우의 수로 끝
			int[] memo = new int[N];			
			
		
			
		}
	}

}