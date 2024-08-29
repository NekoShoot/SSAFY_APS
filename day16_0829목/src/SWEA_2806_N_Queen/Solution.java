package SWEA_2806_N_Queen;

import java.io.*;
import java.util.*;

public class Solution {	
	static int[] occupied;
	static int N;
	static int cnt; // 정답을 저장할 변수
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_2806_N_Queen/input.txt"));
		/*
		 * <<< 서현이 풀이 참조 >>>
		 * r이나 c중 하나를 고정해 node의 유망성(promising)판단
			r을 선택했다고 한다면,
			r = 0부터 시작해서 재귀 시작
			c가 0~N인 구간 안에서 놓을 수 있는 경우 탐색 -> 놓을 수 있는 경우 놓기
				1. row는 어차피 중복 없음(무조건 증가하는 방향으로 가기 때문에)
				2. column 중에서 놓은 곳을 저장하는 배열을 이전 row들에 대해서 탐색, 같은 값이 있다면 불가능
				3. 대각선은 행과 열의 차의 절대값이 같음. 만약 퀸 끼리의 행과 열의 차가 같다면 있다는 뜻이므로 불가능
				4. 값 도출		 
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케 개수
		for(int tc = 1; tc <= T; tc++) {
			cnt = 0;
			N = sc.nextInt(); // 보드 한 줄의 개수, 퀸의 개수			
			occupied = new int[N];
			
			putQ(0);
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
		
	}
	
	// idx => 퀸을 두는 row 좌표
	static void putQ(int idx) {
		// 기저 조건
		if(idx == N) { // 마지막까지 퀸을 두었다면
			cnt++;
			return;
		}
		
		// 재귀 부분
		for(int c = 0; c < N; c++) {
		// 놓을 수 있는 경우에만 놓으면 가지 치기 가능
			if(canPut(idx, c)) {
				occupied[idx] = c; 
				putQ(idx+1);
			}
		}
	}
	
	// 두려는 column에 해당 row 이전에 퀸을 두었었는지, 대각선에는 없는지 체크
	static boolean canPut(int idx, int c) {
		for(int r = 0; r < idx; r++) {
			if(occupied[r] == c) return false; // column check
			else if((Math.abs(r - idx)) == (Math.abs(occupied[r] - c))) return false; // 퀸 사이의 행과 열의 차의 절대값이 같으면
		}
				
		return true;
	}
	
}
