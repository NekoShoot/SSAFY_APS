package SWEA_1208_flatten;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_1208_flatten/input.txt"));
		// flatten문제를 카운팅 정렬을 응용해 풀기
		Scanner sc = new Scanner(System.in);
		
		// 테케 10개 반복
		for(int test_case = 1; test_case <= 10; test_case++) {
			//덤프 횟수 k
			int k = sc.nextInt();
			
			int[] boxArr = new int[100];
			// 가로 길이 항상 100, 상자 높이 채우기
			// count Arr를 위해 최대값 구하기
			int max = 0;
			for(int i = 0; i < 100; i++) {
				boxArr[i] = sc.nextInt();
				if(boxArr[i] > max) max = boxArr[i];
			}
			
			// 각 요소 값들을 countArr의 idx로 카운트
			int[] cntArr = new int[max+1]; // idx 길이 때문에 max+1로		
			for(int i = 0; i < cntArr.length-1; i++) {			
				cntArr[boxArr[i]]++;
			}
			
			int ltorCnt = 0;
			int rtolCnt = 0;
			// 덤프 작업 반복
			for(int i = 0; i < k; i++) {
				// 이미 cnt인덱스 해당 값이 0 이면 cnt++ continue;
				if(cntArr[ltorCnt] == 0) {
					ltorCnt++;
					i--;
					continue;
				}
				
				if(cntArr[cntArr.length - 1 - rtolCnt] == 0) {
					rtolCnt++;
					i--;
					continue;
				}
				
				// 평탄화 끝난 경우에 break
				// how? 0 <= (cntArr.length - 1 - rtolCnt) - ltorCnt <= 1 
				if(0 <= (cntArr.length - 1 - rtolCnt) - ltorCnt && (cntArr.length - 1 - rtolCnt) - ltorCnt <= 1) break;
				 
				// 역방향 (가장 큰 거)
				cntArr[cntArr.length - 1 - rtolCnt]--; // 가장 큰 값 1개를 줄인다
				cntArr[cntArr.length - 2 - rtolCnt]++; // 그럼 그거보다 1작은 값의 개수가 1 늘어난다
				// 정방향 (가장 작은 거)
				cntArr[ltorCnt]--; // 가장 작은 값 1개를 줄인다(박스 1개를 받았기 때문에)
				cntArr[ltorCnt+1]++; // 그거보다 1큰 값의 개수가 1 늘어난다
		
			}
						
			int flattenMax = -1;
			int flattenMin = -1;
			for(int i = 0; i < cntArr.length; i++) {
				// 최저점 찾기
				if(cntArr[i] != 0 && flattenMin == -1) {
					flattenMin = i;				
				}
				// 최고점 찾기
				if(cntArr[cntArr.length-1-i] != 0 && flattenMax == -1) {
					flattenMax = cntArr.length-1-i;
				}
				
				// 덤프 작업 이후 최고점과 최저점 다 찾으면 break
				if(flattenMax != -1 && flattenMin != -1) break;
			}			
			
			int sub = flattenMax - flattenMin;
			System.out.printf("#%d %d\n", test_case, sub);
		}

	}
}