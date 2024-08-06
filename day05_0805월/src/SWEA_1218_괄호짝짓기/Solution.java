package SWEA_1218_괄호짝짓기;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_1218_괄호짝짓기/input.txt"));
		/*
		 * 0. stack 생성
		 * 1. 여는 괄호가 나오면 stack에 저장
		 * 2. 닫는 괄호가 나오면 isEmpty() 체크
		 * 3. 모든 괄호를 검사했는데 isEmpty()가 false면 return 0
				아니면 return 1
			e.g. (([]){()[]})
			
		 */
		Scanner sc = new Scanner(System.in);
		int T = 10; // 테케 개수
test:	for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 테케 길이
			String parenthStr = sc.next();

			StackImpl stack = StackImpl.getInstance();
			
			// stack 비우기
			while(!stack.isEmpty()) {
				stack.pop();
			}
			
			int result = -1;
			// 테케 길이 만큼 순회(charAt)
out:		for(int i = 0; i < N; i++) {
				char parenthesis = parenthStr.charAt(i);			
				if(parenthesis == '(' // 여는 괄호 케이스 2중 검사를 해버린
						|| parenthesis == '[' 
						|| parenthesis == '{'
						|| parenthesis == '<') 
				{
					stack.push(parenthesis);	
					
				} else { // 닫는 괄호 케이스
					if(stack.isEmpty()) { // 비어있으면 열린 괄호가 모자람
						result = 0;
						continue test;
					}
					
					switch(parenthesis) {
						case ')': if(stack.pop() == '(') continue;
									else { 
										result = 0;
										break out;
									}
						case ']': if(stack.pop() == '[') continue;
									else { 
										result = 0;
										break out;
									}
						case '}': if(stack.pop() == '{') continue;
									else { 
										result = 0;
										break out;
									}
						case '>': if(stack.pop() == '<') continue;
									else { 
										result = 0;
										break out;
									}						
					}										
					
				}			
								
			}
			
			// 모든 괄호 검사 후
			if(!stack.isEmpty()) result = 0;
				else result = 1;
			
			System.out.printf("#%d %d\n", test_case, result);
		}	
	}
}