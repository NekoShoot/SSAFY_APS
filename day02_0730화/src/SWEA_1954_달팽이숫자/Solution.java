package SWEA_1954_달팽이숫자;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {	
		System.setIn(new FileInputStream("./src/SWEA_1954_달팽이숫자/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		// 테케 수 T 만큼 반복
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			
			// NxN 배열 생성
			int[][] snail = new int[N][N];
			
			// 델타 배열 생성
			int delRow[] = {0, -1, 0, 1}; // 우 하 좌 상
			int delCol[] = {1, 0, -1, 0};
						
			int num = 1; // 각 칸에 넣을 값 생성
			int d = 0; // 델타 배열 index
			
			// 반복을 통해 값 채워주기
			for(int r = 0; r < snail.length; r++) {
				for(int c = 0; c < snail[0].length; c++) {							
					int dr = delRow[d%4] + r;
					int dc = delCol[d%4] + c;
					
					System.out.println(dr + ", " + dc);
					
					// 다음 배열이 경계를 벗어나려 하면 d++로 방향 회전
					if(0 > dr || dr > snail.length - 1) {
						d++;
					} else if(0 > dc || dc > snail[0].length - 1 ) {
						d++;
					} else if(0 < dr && dr < snail.length - 1 && delRow[dr] != 0) { // 다음 배열의 값이 0이 아니라면(이미 채워진 칸이면) d++로 방향 회전
						d++;						
					} else if(0 < dc && dc < snail[0].length - 1 && delCol[dc] != 0) {
						d++;		
					}	
						
					snail[r][c] = num++;				
										
				}
			}
			
			
			System.out.printf("#%s\n", test_case);
		}
			
			
	}
}