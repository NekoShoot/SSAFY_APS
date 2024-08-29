package SWEA_2806_N_Queen;

import java.io.*;
import java.util.*;

public class Solution_failed {	
	static int[][] chessBoard;
	static int N;
	static int cnt; // 정답을 저장할 변수

	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_2806_N_Queen/input.txt"));
		// queen의 경우 3가지를 체크해야 됨
		// 1. 같은 행에 있는가? r check
		// 2. 같은 열에 있는가? c check
		// 3. 같은 대각선에 있는가? r+n c+n || r-n c-n check
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케 개수
		for(int tc = 1; tc <= T; tc++) {
			cnt = 0;
			N = sc.nextInt(); // 보드 한 줄의 개수, 퀸의 개수
			chessBoard = new int[N][N];
						
			putQ(0, 0, 0);
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
	
	// Q를 놓는 경우 체크할 메소드
	// r <- Q를 놓을 row, c <- Q를 놓을 column
	static void putQ(int r, int visitedR ,int visitedC) {
		// 기저 조건
		// 모두다 방문 했으면
		if((visitedC == (1 << N) - 1) && (visitedR == (1 << N) - 1)) {
			cnt++;
			return;
		} else if(r > N-1) return; // 퀸을 놓을 조건을 만족 못하고 범위 밖으로 갈 때
		
		// 재귀 부분
		// 0부터 N-1까지
		// 가로는 다 다름
out:	for(int c = 0; c < N; c++) {
			// 가지 치기
			// 1. 가로 세로 체크
			if((visitedC & (1 << c)) != 0 || (visitedR & (1 << r)) != 0) continue; // 이미 방문한 r이거나 c면 
			// 2. 대각선 체크
			for(int d = 1; d < N; d++ ) {
				// 왼쪽 위 -> r, c 둘 다 -
				if(r - d >= 0 && c - d >= 0 // 범위 내에서 대각선 탐색을 하는데, 
				&& (visitedR & (1 << r - d)) != 0 // 만약 이미 퀸이 있다면 불가능 
				&& (visitedC & (1 << c - d)) != 0) // 퀸이 없으면 & 연산이 0으로 나옴
					continue out;
				// 오른쪽 위 -> r -, c +
				if(r - d >= 0 && c + d >= 0  
				&& (visitedR & (1 << r - d)) != 0 
				&& (visitedC & (1 << c + d)) != 0)
					continue out;
				// 왼쪽 아래 -> r +, c -
				if(r + d >= 0 && c - d >= 0  
				&& (visitedR & (1 << r + d)) != 0 
				&& (visitedC & (1 << c - d)) != 0)
					continue out;
				// 오른쪽 아래 -> r +, c+
				if(r + d >= 0 && c + d >= 0  
				&& (visitedR & (1 << r + d)) != 0 
				&& (visitedC & (1 << c + d)) != 0)
					continue out;				
			}
			
			// r,c 자리에 놓는다
			putQ(r+1, visitedR | (1 << r), visitedC | (1 << c)); // 다음 칸 판단
			
			// r,c 자리에 놓지 않는다
			putQ(r+1, visitedR, visitedC);
		}
		
		
	}
}