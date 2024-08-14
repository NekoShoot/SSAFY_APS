package IM_보물상자_비밀번호;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class test {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/IM_보물상자_비밀번호/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케 개수
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 총 숫자 개수
			int K = sc.nextInt(); // K번째로 큰 수 찾기
			int numberPerLine = N/4; // 한 변당 숫자 개수
			char[] tbHead = new char[N]; // 상자 뚜껑
			String numbers = sc.next();
			
			// arr 채우기
			for(int i = 0; i < N; i++) {
				tbHead[i] = numbers.charAt(i);
			}
			
			int cnt = 0;
			int[] arr = new int[N];
			String str = "";
			for(int i = 0; i < numberPerLine; i++) { // 뚜껑 회전
				for(int j = 0; j < N; j++) {			
					if(j%numberPerLine == 0 && j != 0) {
						arr[cnt++] = ch16to10(str);												
						str = "";
					}		
					
					str += tbHead[(j+i)%N];
					
					if(j == N-1) {
						arr[cnt++] = ch16to10(str);
						str = "";								
					}
		
				}							
				
			}			
			Arrays.sort(arr);
			System.out.println(arr[arr.length - K]);
			
			
		}
	}

	// 16진수를 10진수로
	// A:11 B:12 C:13 D:14 F:15
	static int ch16to10(String number) {
		int result = 0;
		// 역방향 순회로 곱해서 더해주기
		for(int i = number.length()-1; i >= 0; i--) {
			char num = number.charAt(i);			
			int multiple = (int) Math.pow(16, (number.length()-1) - i); // 계수
			
			if('0' <= num && num <= '9') { // 숫자라면
				int tenDigitNum = (num - '0') * multiple;				
				result += tenDigitNum;
//				System.out.println(tenDigitNum);
			} else {
				int tenDigitNum = 0;
				switch(num) {
					case 'A': 
						tenDigitNum = 11 * multiple;
						break;
						
					case 'B':
						tenDigitNum = 12 * multiple;
						break;
						
					case 'C':
						tenDigitNum = 13 * multiple;
						break;
						
					case 'D':
						tenDigitNum = 14 * multiple;
						break;
						
					case 'F':
						tenDigitNum = 15 * multiple;
						break;
				}	
//				System.out.println(tenDigitNum);
				result += tenDigitNum;
			}
			
		}		
//		System.out.println(result);
		return result;		
		
	}
	
}
