package SWEA_1224_계산기3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static Map<Character, Integer> map;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_1224_계산기3/input.txt"));
		/*
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		// 테케 개수 t = 10;
		// t만큼 반복
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++) {
			int length = sc.nextInt();
			String infix = sc.next();
			String postfix = infixToPostfix(infix);
			int result = calculate(postfix);			
			System.out.printf("#%d %d\n", test_case, result);
		}		
		
	}
	
	 
	
	
	// 중위에서 후위로 계산식을 바꿔줌
	static String infixToPostfix(String infix) {
		String postfix = "";
		
		StackCharImpl stack = StackCharImpl.getInstance();
		
		// 문자 길이만큼 순회
		for(int i = 0; i < infix.length(); i ++) {
			char c = infix.charAt(i);
			
			// 피연산자면 바로 출력
			if('0' <= c && c <= '9') {
				postfix += c;
				
			} else {
				if(c == '(') {
					stack.push(c);
							
				} else if(c == ')') {
					char popItem = (char) stack.pop(); // 일단 하나를 뽑는다
					while(popItem != '(') { // 뽑은게 열린 괄호가 아니면
						// 출력하고 계속 뽑기
						postfix += popItem;
						popItem = (char) stack.pop();
					}
					
				} else { // +와 *의 경우
						// 스택의 top에 c의 우선순위 보다 낮은 연산자가 올 때까지 반복
						// 연산자의 우선순위가 스택의 top보다 커질 때까지 반복					
						while(map.get(c) <= map.get(stack.peek())
								&& !stack.isEmpty() // 비어있지 않아야 pop 가능
								&& ((char) stack.peek()) != '(') // 열린 괄호는 닫힌 괄호가 올 때까지 기다려 
						{ 
							char popItem = (char) stack.pop();
							postfix += popItem;
						}				
						
					// if문 종료 후 push
					stack.push(c);
				}		
				
	
			}				
						
		}
		
		// 반복이 끝나고 남아있으면 비우기
		while(!stack.isEmpty()) {
			stack.pop();
		}
		
		return postfix;
	}
	
	
	
	// 후위 수식 계산
	static int calculate(String postfix) {
		StackIntImpl stack = StackIntImpl.getInstance();
		// 길이만큼 반복
		for(int i = 0; i < postfix.length(); i++) {
			
			char c = postfix.charAt(i);
			
			if('0' <= c && c <= '9') {
				stack.push(c - '0');
				
			} else {
				// LIFO
				int lastNum = (int) stack.pop();
				int firstNum = (int) stack.pop();
				int result;
				
//				System.out.println(lastNum + " , " + firstNum);
				
				if(c == '+') {
					result = firstNum + lastNum;					
					
				} else {
					result = firstNum * lastNum;
					
				}				
				
				stack.push(result); // stack에 결과 저장
			}			
			
		}
		
		return ((int) stack.peek()); // 계산을 끝내면 마지막에 남은 게 그 결과
	}
	
	
	
	// 정적 초기화 블록
	static {
		map = new HashMap<>();
		// 높은 우선도일 수록 높은 숫자 value 할당
		map.put('+', 1);
		map.put('*', 2);
		map.put('(', 0); // stack 안의 열린 괄호는 가장 우선도가 낮음
		// why? 닫힌 괄호가 나올 때까지 기다려야하기 때문에!! 
	}
}