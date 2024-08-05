package flattenPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/flattenPractice/input.txt"));
		/*
		 * t = 100
		 * 1<= n <= 100
		 * 1 <= k <= 1000
		 * 
		 * case 1: 덤프 횟수 이내에 평탄화 완료
		 * case 2: k번 시행
		 * 
		 * result: 최고점 높이 - 최저점 높이
		 */
		Scanner sc = new Scanner(System.in);
		// 테케 개수 T = 10
		int testNum = 10;
		for(int test_case = 1; test_case <= testNum; test_case++) {		
			int t = 100;
			int k = sc.nextInt();
			
			int[] arr = new int[t];
			int max = 0;
			int min = 101;
			// 배열 채우기
			for(int i = 0; i < t; i++) {
				arr[i] = sc.nextInt();
				if(arr[i] > max) max = arr[i];
				if(arr[i] < min) min = arr[i];
			}
			
			// 카운팅 배열 만들기
			int[] cntArr = new int[max+1];
			for(int i = 0; i < t; i++) {
				cntArr[arr[i]]++; 
			}
			
			// 덤핑
			int maxIdx = max;
			int minIdx = min;
			for(int i = 0; i < k; i++) {
				if(maxIdx - minIdx <= 1) break; // 평탄화 끝
				
				// 덤핑 실행
				cntArr[maxIdx]--;
				cntArr[maxIdx-1]++;
				cntArr[minIdx]--;
				cntArr[minIdx+1]++;
				
				// 가장 높은게 없어지면 그 다음 높은 곳으로
				if(cntArr[maxIdx] == 0) maxIdx--;
				if(cntArr[minIdx] == 0) minIdx++;
				
			}
			
			int result = maxIdx - minIdx;
			System.out.printf("#%d %d\n", test_case, result);
		}
	}
}
