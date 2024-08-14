package IM_보물상자_비밀번호;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/IM_보물상자_비밀번호/input.txt"));
		/*
		 * 16진수 0~F 숫자
		 * 뚜껑 -> 시계방향 회전(1칸 씩)
		 * 각 변에는 동일한 개수의 숫자 -> 시계방향 순으로 높은 자리, 하나의 수를 나타냄
		 * 자물쇠 -> 비밀번호 == 보물상자에 적힌 숫자로 만들 수 있는 모든 수 중 
		 * 	K번째로 큰 수를 10진수로 만든 수
		 * N개의 숫자가 입력으로 주어질 때 비밀번호 출력
		 * 
		 * N = 4의배수, 8 <= N <= 28
		 * N개의 숫자는 각각 0~F(알파벳은 대문자로만) A:11 B:12 C:13 D:14 F:15
		 * K는 생성가능한 수의 개수 이하로만
		 * 
		 * < 핵심 로직 >
		 * - queue <- enqueu(dequeue()) 로 시계방향으로 회전 시키기
		 * - 사각형 -> 각 변에 적히는 숫자 개수 == N/4
		 * - queue의 숫자들을 N/4개씩 잘라가며 합성
		 * - 한 변의 숫자를 전부 밀면 동일해지므로, (N/4)-1번 회전 반복 후 합성 값 도출
		 * - Set으로 중복제거
		 * - 16진수를 10진수로 변경
		 * - 내림차순으로 정렬
		 * - K번째 큰 수 찾기
		 */
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케 개수
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 총 숫자 개수
			int K = sc.nextInt(); // K번째로 큰 수 찾기
			
			int numberPerLine = N/4; // 한 변당 숫자 개수
			Queue<Character> queue = new LinkedList<>(); // 상자 뚜껑
			String numbers = sc.next();
			
			for(int i = 0; i < numbers.length(); i++) { // 뚜껑에 숫자들 채우기
				queue.offer(numbers.charAt(i));
			}
			
			
			Set<String> set = new HashSet<>(); // 생성 가능한 수를 저장할 집합(변수 제거)
			String subset = "";
			for(int j = 0; j < N/4; j++) { // 뚜껑 돌리기
				for(int i = 0; i < N; i++) { // 변마다 잘라서 숫자 만들기			
					if(i%(N/4) == 0 && i != 0) { // 줄마다 넣고 초기화						
						set.add(subset);
						subset = "";
					}
					
					char tmp = queue.poll();
					subset += tmp;
					queue.offer(tmp);
					
					if(i == N-1) {
						set.add(subset);
						subset = "";
					}
				}
				
				// 시계방향으로 한 칸 회전
				queue.offer(queue.poll());
				System.out.println(queue);
			}
			

//			// 정렬을 위해 set -> arr로 바꾸고 그 과정에서 16진수를 10진수로 바꾸기			
			String[] tenDigitNumbers =  set.toArray(new String[0]);
			
			int[] tenDigits = new int[tenDigitNumbers.length];
			int cnt = 0;
			for(String tenDigitNumber : tenDigitNumbers) {
				tenDigits[cnt] = ch16to10(tenDigitNumber);
				cnt++;
			}

			// 정렬
			reverseSort(tenDigits);

			int result = tenDigits[K-1];
			System.out.printf("#%d %d\n", test_case, result);
		}
		
	}
	
	static void reverseSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int maxIdx = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[maxIdx] < arr[j]) maxIdx = j;
			}
			
			int tmp = arr[i];
			arr[i] = arr[maxIdx];
			arr[maxIdx] = tmp;
			
		}
	} 

	// 16진수를 10진수로
	// A:10 B:11 C:12 D:13 E:14 F:15
	static int ch16to10(String number) {
		int result = 0;
		// 역방향 순회로 곱해서 더해주기
		for(int i = number.length()-1; i >= 0; i--) {
			char num = number.charAt(i);
			int multiple = (int) Math.pow(16, number.length()-1 - i); // 계수
			
			if('0' <= num && num <= '9') { // 숫자라면
				int tenDigitNum = (num - '0') * multiple;
				result += tenDigitNum;
				
			} else {
				int tenDigitNum = switch (num) {
                    case 'A' -> 10 * multiple;
                    case 'B' -> 11 * multiple;
                    case 'C' -> 12 * multiple;
                    case 'D' -> 13 * multiple;
                    case 'E' -> 14 * multiple;
                    case 'F' -> 15 * multiple;
                    default -> 0;
                };

                result += tenDigitNum;
			}
			
		}
		
		return result;		
		
	}
	
}
