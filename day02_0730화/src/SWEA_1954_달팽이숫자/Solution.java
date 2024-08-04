package snailNumber;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/snailNumber/input.txt"));
		/*
		 * 반시계 방향으로 출력
		 * 델타 탐색
		 * 하 -> 우 -> 상 -> 좌
		 * case 1: arr.length보다 커지면 d+1;
		 * case 2: 0이 아니면 d+1; 
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t < T; t++) {
			int N = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			// 하 우 상 좌
			int[] dr = { 1, 0, -1, 0 };
			int[] dc = { 0, 1, 0, -1 };
			
			int cnt = 1; // 채워 넣을 숫자
			int d = 0; // dr과 dc의 index
			// 탐색
			int nr = 0;
			int nc = 0;
			for(int r = 0; r < N; r++) { // row
				for(int c = 0; c < N; c++) { // column
					arr[nr][nc] = cnt++;
					// 경계 체크
					if(nr + dr[d%4] > N-1 || nr + dr[d%4] < 0) // 경계를 넘으면 
						d++; // 방향 전환
						else if(nc + dc[d%4] > N-1 || nc + dc[d%4] < 0) 
							d++; 
					
					if(nr + dr[d%4] <= N-1 // 다음 값이 범위 안에 있고,
							&& nr + dr[d%4] >= 0
							&& nc + dc[d%4] <= N-1 							 
							&& nc + dc[d%4] >= 0) { 
						// 다음 값이 0이 아니라면
						if(arr[nr + dr[d%4]][nc + dc[d%4]] != 0) 
							d++;
					}
								
					// 이동
					nr += dr[d%4];
					nc += dc[d%4];
					
				}
			}
			
			//String과 + 연산자를 이용한 출력
			long startPl = System.nanoTime();
			String result = "";
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(j < N-1) { // 한 줄 출력할 때 숫자 사이에 공백
						result += arr[i][j] + " ";
					} else if(j == N-1) {
						result += arr[i][j] + "\n";
					}
				}
			}
			
			long endPl = System.nanoTime();
			System.out.printf(result +"+연산자의 수행시간은: %d\n", endPl-startPl);

			
			// StringBuilder를 이용한 출력
			long startSB = System.nanoTime();
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < N; i++) {				
				for(int j = 0; j < N; j++) {
					if(j < N-1) {
						sb.append(arr[i][j]).append(" ");
					} else if(j == N-1) {
						sb.append(arr[i][j]).append("\n");
					}
				}
			}
			long endSB = System.nanoTime();			
			System.out.printf(sb.toString()+"SB의 수행시간은: %d\n", (endSB-startSB));
		}
		
	}
}
