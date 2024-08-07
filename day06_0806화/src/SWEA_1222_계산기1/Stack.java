package SWEA_1222_계산기1;

import java.util.List;

public class Stack<T> {
	/*
	 * List<T>
	 * isEmpty
	 * push
	 * pop
	 * peek
	 */
	public List<T> stack;
	
	public Stack() {}
	
	public Stack(List<T> stack) {
		this.stack = stack;
	}
	
	// isEmpty()
	public boolean isEmpty() {
		return stack.size() == 0;
	}

	// push
	public void push(T item) {
		stack.add(item);
	}
	
	// pop
	public T pop() {
		int top = stack.size() - 1;
		
		if(isEmpty()) {
			System.out.println("스택이 비어있어 값을 꺼낼 수 없습니다!");
			return null;
		} else {
			T popItem = stack.get(top);
			stack.remove(top);
			return popItem;			
		}		
	}
	
	// peek
	public T peek() {
		int top = stack.size() - 1;
		
		if(isEmpty()) {
			System.out.println("스택이 비어있어 값을 꺼낼 수 없습니다!");
			return null;
		} else {
			T popItem = stack.get(top);
			return popItem;			
		}		
	}
	
}
