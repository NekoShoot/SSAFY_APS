package SWEA_1228_암호문1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_1228_암호문1/input.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();		
		
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++) {
			List<Integer> cypherList = new LinkedList<>(); // 암호문 뭉치
			
			int N = sc.nextInt(); // 암호 개수
			for(int i = 0; i < N; i++) { // 암호문
				int cypher = sc.nextInt();
				cypherList.add(cypher);			
			}
			
			int x;
			int y;
			int s;
			int M = sc.nextInt(); // 명령어 개수
			for(int i = 0; i < M; i++) { // 명령 실행
				String order = sc.next();				
				if(order.equals("I")) {
					x = sc.nextInt();
					y = sc.nextInt();					
					for(int j = 0; j < y; j++) {
						s = sc.nextInt();
						cypherList.add(x+j, s);
					}
					
				} else {
					System.out.println("오류 발생!");
					return;
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