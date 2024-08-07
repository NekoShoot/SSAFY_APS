package SWEA_1225_암호생성기;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Queue_구현.Queue;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_1225_암호생성기/input.txt"));
		/*
		 * 1. 8개 숫자 입력 받기
		 * 2. 첫 숫자 1 감소 -> 맨 뒤로
		 * 3. 다음 첫 숫자 2 감소 -> 맨 뒤로
		 * 4. 그 다음 첫 수 3 감속 -> 맨 뒤로
		 * 5. ...
		 * 사이클을 반복하다가 0보다 숫자가 작아지는 경우 0으로 유지 -> 프로그램 종료
		 *  
		 */
		Scanner sc = new Scanner(System.in);
		int T = 10; // 테케 개수
		// 테케 개수만큼 반복
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt(); // 테케 번호
			List<Integer> list = new LinkedList<>();
			Queue queue = new Queue(list);
			
			// queue 채우기
			for(int i = 0; i < 8; i++) { // 8개의 데이터가 주어짐
				queue.enQueue(sc.nextInt());
			}	
			
			int cnt = 0;
			
			// 사이클 반복
			while((int) queue.Qpeek() >= 0) {				
				int item = (int) queue.deQueue();
				int modified = item - ((cnt % 5) + 1);
				if(modified <= 0) { // 마지막이면 break
					modified = 0;
					queue.enQueue(modified);
					break;
				}
				cnt++;
				queue.enQueue(modified);
			}			
			
			System.out.printf("#%d ", n);
			for(int i = 0; i < 8; i++) {
				if(i < 7) System.out.printf("%d ", queue.deQueue());
					else System.out.printf("%d\n", queue.deQueue());
			}
			
		}
		
		
	}
	
	
	
	
}