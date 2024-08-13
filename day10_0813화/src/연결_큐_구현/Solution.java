package 연결_큐_구현;

class Node {		
	String data;
	Node link;		
	
	Node() {}
	Node(String data, Node link) {			
		this.data = data;
		this.link = link;
	}
}

class SinglyLinkedQueue {
	// 초기 상태 top -> null
	Node front;
	Node rear;
	int size;
	
	
	
	void createLinkeQueue() {		
		front = null;
		rear = null;				
	}
	
	void enQueue(String data, int i) {
		if(i < 0 || i > size) {
			System.out.println("범위 밖!");
			return;
		}
		
		// 
		Node crr = rear;
		// 새 노드와 연결
		Node newNode = new Node();
		newNode.data = data;
		
		if(size == 0) { // 공백상태 였으면
			front = newNode; // front 맞춰주기
			rear = newNode;
		} else {
			// LIFO			
			crr.link = newNode;
			rear = newNode;
		}		
		size++;			
	} 
	
	Node deQueue() {
		// 초기 혹은 공백 상태일 때
		if(rear == null && front == rear) {
			System.out.println("빈 스택 입니다.");
			return null;
		}
		
		// LIFO
		Node tmp = front; 
		front = front.link;
		size--;
		return tmp;
	}
	
	void printAll() {		
		Node current = front; // 첫번째 노드부터 출력
		
		while(current != null) { // 마지막 노드에 다다를 때 까지
			System.out.print(current.data + " -> ");
			current = current.link;
		}
		System.out.println("");
	}
}


public class Solution {
	public static void main(String[] args) {
		SinglyLinkedQueue slq = new SinglyLinkedQueue();
		slq.createLinkeQueue();
		slq.enQueue("111", 0);
		slq.enQueue("222", 1);
		slq.enQueue("333", 2);
		slq.enQueue("444", 3);
		
		slq.printAll();
		
		System.out.println("pop = " + slq.deQueue().data);
		slq.printAll();
		
		slq.enQueue("5", 3);
		slq.printAll();
	}
}