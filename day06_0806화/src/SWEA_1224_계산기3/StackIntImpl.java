package SWEA_1224_계산기3;

import java.util.ArrayList;
import java.util.List;

public class StackIntImpl implements StackInterface{
	// member field
	private List<Integer> stack = new ArrayList<>();	

	// 기본 생성자
	private StackIntImpl() {}
	
	// 변수 받는 생성자
	private StackIntImpl(List<Integer> stack) {
		this.stack = stack;
	}

	// singleton
	private static StackIntImpl instance = new StackIntImpl();	
	public static StackIntImpl getInstance() {
		return instance; 
	}
	
	@Override
	public boolean isEmpty() {		
		return this.stack.size() == 0; // 0이면 true, 아니면 false
	}
	
	@Override
	public void push(Object item) {
		int number = (int) item;
		this.stack.add(number);		
		return;
	}
	
	@Override
	public Object pop() {
		int top = stack.size() - 1;
		int topItem = this.stack.get(top);
		this.stack.remove(top);
		return topItem;
	}
	
	@Override
	public Object peek() {
		int top = stack.size() - 1;
		return this.stack.get(top);
	}
}
