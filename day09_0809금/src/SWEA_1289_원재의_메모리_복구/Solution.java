package SWEA_1289_원재의_메모리_복구;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static Map<Boolean, Character> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_1289_원재의_메모리_복구/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케 개수
				
		for(int test_case = 1; test_case <= T; test_case++) {
			String memory = sc.next(); // 메모리 원래 값
			
			int cnt = 0; // 시행 횟수 카운트
			boolean flag = false; // 연속되지 않은 값을 만나는지 확인할 flag
			for(int i = 0; i < memory.length(); i++) {
				char bit = memory.charAt(i); 
				
				if(bit != map.get(flag)) { // 연속되지 않은 값을 만나면
					cnt++;				// 카운트 하나 올리고
					flag = !flag;		// flag 거꾸로
				}
				
			}
			
			System.out.printf("#%d %d\n", test_case, cnt);
		}
	}
	
	
	static { // flag 값 할당
		map.put(false, '0');
		map.put(true, '1');
	}
}