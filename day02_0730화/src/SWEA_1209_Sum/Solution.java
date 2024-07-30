package SWEA_1209_Sum;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_1209_Sum/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		// 10개의 테스트 케이스 반복
		for(int test_case = 1; test_case <= 10; test_case++) {
			// 테케 넘버
			int t = sc.nextInt();
			
			// 이차원 배열 생성
			int[][] squareArr = new int[100][100];
			// 이차원 배열 저장
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					squareArr[i][j] = sc.nextInt();
				}
			}
			
			// 행, 열, 대각선 합을 저장할 변수 생성
			int rowSum = 0;
			int colSum = 0;
			int diagSum = 0;
			
			int tmpDiagSum = 0;
			// 각 라인 합 구하기
			for(int i = 0; i < 100; i++) {
				// 우하 방향 대각선은 값이 하나만 존재하므로 
				tmpDiagSum += squareArr[i][i];		
				// 우상->좌하 방향 대각선은 값이 하나만 존재하므로
				diagSum += squareArr[i][99-i];

				// 임시로 저장할 변수 생성
				int tmpRowSum = 0;
				int tmpColSum = 0;
				// 행과 열 합 구하기
				for(int j = 0; j < 100; j++) {
					tmpRowSum += squareArr[i][j];
					tmpColSum += squareArr[j][i];
				}
				
				rowSum = tmpRowSum > rowSum ? tmpRowSum : rowSum;
				colSum = tmpColSum > colSum ? tmpColSum : colSum;		
							
			}
			
			// 대각선 중에 큰 값 넣기
			diagSum = diagSum > tmpDiagSum ? diagSum : tmpDiagSum;
			
			// 삼항연산자로 최대값 찾기
			int compareSum;
			compareSum = rowSum > colSum ? rowSum : colSum;
			int result;
			result = compareSum > diagSum ? compareSum : diagSum;
			
			System.out.printf("#%d %d\n", t, result);
			
		}

	}		
}