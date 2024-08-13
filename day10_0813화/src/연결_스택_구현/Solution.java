package 연결_스택_구현;

class Node {		
	String data;
	Node link;		
	
	Node() {}
	Node(String data, Node link) {			
		this.data = data;
		this.link = link;
	}
}

class SinglyLinkedStack {
	// 초기 상태 top -> null
	Node top;
	int size;
	
	SinglyLinkedStack() {
		top = null;			
	}
	
	void push(String data, int i) {
		if(i < 0 || i > size) {
			System.out.println("범위 밖!");
			return;
		}
		
		Node crr = top;		
		// 새 노드와 연결
		Node newNode = new Node();
		newNode.data = data;
		
		// 새 노드는 현재 가장 높은 노드 위에 쌓임
		newNode.link = crr;
		top = newNode;
		size++;			
	} 
	
	Node pop() {
		if(top == null) {
			System.out.println("빈 스택 입니다.");
			return null;
		}
		
		Node tmp = top; 
		top = top.link;
		size--;
		return tmp;
	}
	
	void printAll() {		
		Node current = top; // 첫번째 노드부터 출력
		
		while(current != null) { // 마지막 노드에 다다를 때 까지
			System.out.print(current.data + " -> ");
			current = current.link;
		}
		System.out.println("");
	}
}

public class Solution {	
	public static void main(String[] args) {
		SinglyLinkedStack sls = new SinglyLinkedStack();
		sls.push("111", 0);
		sls.push("222", 1);
		sls.push("333", 2);
		sls.push("444", 3);
		
		sls.printAll();
		
		System.out.println("pop = " + sls.pop().data);
		sls.printAll();
		
		sls.push("5", 4);
		sls.printAll();
		
		
	}
}