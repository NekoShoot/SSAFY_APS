package SWEA_1224_계산기3;

import java.util.ArrayList;
import java.util.List;

public class StackCharImpl implements StackInterface {
	// member field
	private List<Character> stack = new ArrayList<>();	

	// 기본 생성자
	private StackCharImpl() {}
	
	// 변수 받는 생성자
	private StackCharImpl(List<Character> stack) {
		this.stack = stack;
	}

	// singleton
	private static StackCharImpl instance = new StackCharImpl();	
	public static StackCharImpl getInstance() {
		return instance; 
	}
	
	@Override
	public boolean isEmpty() {		
		return this.stack.size() == 0; // 0이면 true, 아니면 false
	}
	
	@Override
	public void push(Object item) {
		char parenthesis = (char) item;
		this.stack.add(parenthesis);		
		return;
	}
	
	@Override
	public Object pop() {
		int top = stack.size() - 1;
		char topItem = this.stack.get(top);
		this.stack.remove(top);
		return topItem;
	}
	
	@Override
	public Object peek() {
		int top = stack.size() - 1;
		return this.stack.get(top);
	}


}
