package SWEA_1230_암호문3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_1230_암호문3/input.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();		
		
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++) {
			List<Integer> cypherList = new LinkedList<>();

			int N = sc.nextInt(); // 암호문 개수 
			for(int i = 0; i < N; i++) { // 암호문 뭉치
				cypherList.add(sc.nextInt());
			}
			
			// 명령어 개수
			int M = sc.nextInt();
			int x;
			int y;
			int s;
			for(int i = 0; i < M; i++) { // 명령 실행
				char order = sc.next().charAt(0);
				switch(order) {
					case 'I' : 
						x = sc.nextInt(); // x번째 암호문 바로 다음
						y = sc.nextInt(); // y개 암호문 삽입
						for(int j = 0; j < y; j++) {
							s = sc.nextInt();
							cypherList.add(x+j, s);
						}					
						break;
						
					case 'D':
						x = sc.nextInt();
						y = sc.nextInt();
						for(int j = x+y; j > x; j--) { // 역방향 순회
							cypherList.remove(j);
						}					
						break;
						
					case 'A':
						y = sc.nextInt();
						for(int j = 0; j < y; j++) {
							s = sc.nextInt();
							cypherList.add(s);
						}
				}
			}
			
			sb.append("#%d ");
			for(int i = 0; i < 10; i++) {
				if(i < 9) sb.append(cypherList.get(i) + " ");
				else sb.append(cypherList.get(i) + "\n");
			}
			
			String result = sb.toString();
			System.out.printf(result, test_case);
			sb.delete(0, sb.length());
		}
	}
}