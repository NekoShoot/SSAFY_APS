package SWEA_1218_괄호짝짓기;

import java.util.ArrayList;
import java.util.List;

public class StackImpl implements StackInterface {
	// member field
	private List<Character> stack = new ArrayList<>();
	
	// 기본 생성자
	private StackImpl() {}
	
	// 변수 받는 생성자
	private StackImpl(List<Character> stack) {
		this.stack = stack;
	}
	
	// singleton
	private static StackImpl instance = new StackImpl();	
	public static StackImpl getInstance() { return instance; }
	
	@Override
	public boolean isEmpty() {		
		return this.stack.size() == 0; // 0이면 true, 아니면 false
	}
	
	@Override
	public void push(char parenthesis) {
		// 여는 괄호만 저장하기 위해
		this.stack.add(parenthesis);		
		return;
	}
	
	@Override
	public char pop() {
		int top = stack.size() - 1;
		char topChar = this.stack.get(top);
		this.stack.remove(top);
		return topChar;
	}
	
	@Override
	public char peek() {
		int top = stack.size() - 1;
		return this.stack.get(top);
	}

}
