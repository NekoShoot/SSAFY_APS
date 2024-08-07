package SWEA_1222_계산기1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_1222_계산기1/input.txt"));
		/*
		 * stack
		 * List<T> stack
		 * 
		 * - 중위 -> 후위
		 * 연산자 push 피연산자 출력
		 * 
		 *  
		 * 후위 -> 계산
		 * 피연산자 push 연산자 계산
		 * + 만나면 num1 = pop, num2 = pop
		 *  
		 */
		
		/*
		 * pseudo code
		 * 1. int N = sc.nextInt(); 문자 길이
		 * 2. String calculStr = sc.next();
		 * infixToPostfix(calculStr)
		 * 3. for(int i = 0; i < N; i++) 문자 길이만큼 순회
		 * 		char c = calculStr.charAt(i);
		 * 		String postfix = "";
		 * 		if('0' <= c <= '9') stack.push(c);
		 * 			else postfix += c;
		 * calculatePostfix(postfix)
		 * 4. for(int i = 0; i < postfix.length(); i++)
		 * 		char c = postfix.charAt(i);
		 * 		if('0' <= c <= '9') stack.push(c - '0') 
		 * 			else {
		 * 				numLast = stack.pop;
		 * 				numFirst = stack.pop;
		 * 
		 * 				int result = numFirst + numLast;
		 * 				stack.push(result); 				
		 * 		}
		 * 		
		 * 		return stack.pop;
		 */
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++) {			
			int N = sc.nextInt();	
			String str = sc.next();
			int calculated = calculator(str);
			
			System.out.printf("#%d %d\n", test_case, calculated);
		}
		
	}
	
	// 중위를 후위로
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static String infixToPostfix(String expression) {
		List<Character> list = new ArrayList<>();
		Stack stack = new Stack(list);
		String postfix = "";
		for(int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			
			if('0' <= c && c <= '9') { // 피연산자
				postfix += c;
			} else { // + 연산자				
				while(!stack.isEmpty()) {
					char item = (char) stack.pop();
					postfix += item;
				}
				
				stack.push(c);
			}			
		}
		
		while(!stack.isEmpty()) {
			postfix += stack.pop();
		}
		
		return postfix;
	}
	
	
	// 후위를 계산
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static int calculatePostfix(String postfix) {		
		List<Integer> list = new ArrayList<>();
		Stack stack = new Stack(list);		
		
		for(int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if('0' <= c && c <= '9') {
				stack.push(c - '0');			
			} else {
				int numLast = (int) stack.pop();
				int numFirst = (int) stack.pop();
				int result = numFirst + numLast;
				
				stack.push(result);
			}
			
		}
		
		return (int) stack.peek();				
	}
	
	
	static int calculator(String expression) {
		String postfix = infixToPostfix(expression);
		int result = calculatePostfix(postfix);
		return result;
	}
	
}