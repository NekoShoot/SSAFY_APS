package Stack_구현;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	// 동적 구현
	static List<Integer> stack = new ArrayList<>();	
	
	public static void main(String[] args) {
		System.out.println(isEmpty());
		push(3);
		System.out.println(isEmpty());
		pop();
		System.out.println(isEmpty());
		push(3);
		peek();
		System.out.println(isEmpty());
		System.out.println(peek());
		
	}

	// isEmpty
	static boolean isEmpty() {
		return Solution.stack.size() == 0;
	}
	
	// push
	static void push(int num) {
		Solution.stack.add(num);
	}
	
	// pop
	static int pop() {
		int top = Solution.stack.size() - 1;
		int item = Solution.stack.get(top);
		Solution.stack.remove(top);
		return item;
	}
	
	// peek
	static int peek() {
		int top = Solution.stack.size() - 1;
		int item = Solution.stack.get(top);
		return item;
	}
	
}