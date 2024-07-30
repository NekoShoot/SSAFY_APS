package SWEA_1210_ladder1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_1210_ladder1/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		// 테케 10개 반복
		for(int test_case = 1; test_case <= 10; test_case++) {
			// 테케 넘버
			int t = sc.nextInt();
			
			int[][] ladderArr = new int[100][100];
			
			// 2차원 배열 저장 
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					ladderArr[i][j] = sc.nextInt();
				}
			}
			
			// X위치(2인 값) 찾기
			int idx = 99; // 밑에서부터 출발하니까
			int jdx = -1; // X위치의 column 값
			int flagIdx = -1; // 실제 사다리 탈 때 위치를 판별해주기 위한 기준
			for(int i = 0; i < 100; i++) {
				if(ladderArr[idx][i] == 2) {
					jdx = i;
					flagIdx = i;
					break;
				} 
			}
			
			if(jdx == -1 && flagIdx == -1) System.out.println("2가 없습니다!");
						
			int result = -1;		
			
			// 사다리 타고 올라가기
			while(idx != 0) {		
				// 초기값 0이면 배열 끝 쪽에서도 비교 가능!
				int left = 0;
				int right = 0;
				
				// 배열 끝일 때, 그 외일 때 left와 right 값 비교
				if(jdx == 99) {
					left = ladderArr[idx][jdx-1];
					
				} else if(jdx == 0) {
					right = ladderArr[idx][jdx+1];
							
				} else {
					left = ladderArr[idx][jdx-1]; 
					right = ladderArr[idx][jdx+1];
					
				}
				
//				System.out.println("jdx = " + jdx + " flagIdx = " + flagIdx + " idx = " + idx );
				
				// 양쪽이 같을 때
				if(left == right) {
					// 양쪽이 둘 다 0 이면 idx--(세로 사다리 타기)
					if(left == 0) {
						idx--;
						continue;
					} else if(left == 1) { // 가로 사다리 타고 가는 도중에
						if(jdx < flagIdx) {
							jdx--;
							flagIdx--;
						} else if(jdx > flagIdx) {
							jdx++;
							flagIdx++;							
						}
						
					} 
					
				} else {
					// 양쪽이 다를 때 1인쪽으로 이동(가로 사다리 타기)
					if(left == 1) {
						if(jdx-1 == flagIdx) { // 가로 사다리 끝이면
							idx--;
							flagIdx++;
							continue;
						}
						
						jdx--;
						
						
					} else if(right == 1){
						if(jdx+1 == flagIdx) { // 가로 사다리 끝이면
							idx--;
							flagIdx--;
							continue;
						}
						
						jdx++;		
						
					}
					
				}							
				
			}
			
			// 첫 줄에 도착했을 때! => result
			if(idx == 0) {
				result = jdx;
			}
			
			System.out.printf("#%d %d\n", t, result);
		}
		
	}
}