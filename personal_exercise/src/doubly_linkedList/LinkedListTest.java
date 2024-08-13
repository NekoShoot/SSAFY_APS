package doubly_linkedList;

class Node {
	String data;
	Node prev;
	Node next;
}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;
	
	public DoublyLinkedList() {
		// 더미 노드 생성 
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	// 삽입
	void addData(int i, String data) {
		if(i < 0 || i > size) {
			System.out.println("삽입할 수 없는 범위입니다.");
			return;
		}
		
		// 삽입 위치 앞의 노드 찾기
		Node current = head;
		for(int j = 0; j < i; j++) {
			current = current.next; // 노드를 타고타고 계속해서 타고타고			
		}
		
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = current.next;
		newNode.prev = current;
		
		current.next = newNode;
		newNode.next.prev = newNode;
		
		size++;		
	}
	
	
	void removeData(int i) {
		if(i < 0 || i > size) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}
		
		// 삭제할 위치 찾기
		Node rmNode = head.next; // 왜 head.next부터 출발?
		for(int k = 0; k < i; k++) {
			rmNode = rmNode.next;
		}
		
		rmNode.prev.next = rmNode.next;
		rmNode.next.prev = rmNode.prev;
		
		size--;
	}
	
	void printReverse() {
		Node current = tail;
		String str= "head";
		while(current != head) {
			str += " <- " + current.data;
			current = current.prev;
			
		}
		
		System.out.println(str);
		
	}
	
}

public class LinkedListTest {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.addData(0, "dtd");
		list.addData(1, "sss");
		list.addData(2, "fff");
		
		list.printReverse();
	}
}
