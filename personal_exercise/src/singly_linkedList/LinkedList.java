package singly_linkedList;

class Node {
	String data;
	Node link; // class Node인데 데이터 타입이 Node...?
	// 스스로의 클래스 타입으로 멤버 변수 생성 가능!
}

class SinglyLinkedList {
	Node head; // 이건 Class 타입 Node
	int size; // 삽입할 때 증가, 삭제할 때 감소
	
	// 생성자
	SinglyLinkedList() {
		head = new Node();
	}
	
	// 삽입
	// i가 가리키는 인덱스에 새로운 데이터를 추가하는 메소드
	void addData(int i, String data) {
		// 0이면 제일 앞에 추가
		// size와 같으면 제일 뒤에 추가
		
		// 범위 체크
		if(0 > i || i > size ) { // 범위 밖이면
			System.out.println("삽입할 위치가 잘못되었습니다.");
			return;
		}
		
		// 새 노드 생성
		Node newNode = new Node();
		newNode.data = data;
		
		// 삽입할 위치 앞에 있는 노드 찾기
		Node current = head;
		for(int k = 0; k < i; k++) {
			current = current.link; // 링크 계속 타고 가면서 찾기! 
		}
		
		// 연결이 끊기지 않게 새 노드부터 연결
		newNode.link = current.link;
		current.link = newNode.link;
		
		size++;
	}
	
	// 삭제
	void removeData(int i) {
		// i == 0, 제일 앞에 있는 데이터 삭제
		// i == size-1 제일 마지막에 있는 데이터 삭제
		
		if(0 > i || i >= size ) { 
			System.out.println("삭제할 위치가 잘못되었습니다.");
			return;
		}
				
		// 삭제할 노드의 앞 노드로 이동
		Node current = head;
		for(int k = 0; k < i; k++) {
			current = current.link;
		}
		
		// 삭제할 노드 앞에 있는 노드의 링크 필드에 삭제할 노드의 링크 필드를 붙여 넣기
		current.link = current.link.link; //current.link -> 다음 노드 current.link.link -> 다음 노드가 가리키는 그 다음 노드
		
		size--;
	}
	
	void printAll() {
		Node current = head.link;
		
		while(current != null) {
			System.out.println(current.data + " -> ");
			current = current.link;
		}
			
	}
	
}

public class LinkedList {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addData(0, "dtd");
	}
}
