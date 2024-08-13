package LinkedList;

public class DoublyLinkedList extends LinkedList {
	@Override
	void addData(String data, int i) {
		if(i < 0 || i > size) {
			System.out.println("범위 밖!");
			return;
		}
		
		// head부터 출발해서 i-1번째 찾기
		Node current = head;
		for(int m = 0; m < i; m++) {
			current = current.next;
		}
		// 반복이 끝나면 current는 i-1번째 노드
		// 1. current의 next를 새로운 next에 저장해 current의 다음 노드에 연결
		Node newNode = new Node();
		newNode.data = data;
		
		newNode.next = current.next;
		// 2. current의 주소를 새로운 노드의 prev에 저장해 이전 노드에 연결
		newNode.prev = current;
		// 3. 새로운 노드 주소를 current의 next에 저장해 새로운 노드를 current의 다음 노드로 만들기
		current.next = newNode;
		// 4. 새로운 노드의 주소를 새로운 노드 다음 노드의 prev에 저장해 연결
		newNode.next.prev = newNode;
		// 5. size 증가
		size++;		
	}
	
	@Override
	void removeData(int i) {
		if(i < 0 || i > size) {
			System.out.println("범위 밖!");
			return;
		}
		
		// head.next부터 시작해 i번째 노드 찾기
		Node current = head.next;
		for(int m = 0; m < i; m++) {
			current = current.next;
		}
		// 반복이 끝나면 current는 i번째 노드
		// 1. 삭제할 current의 다음 노드의 주소를 current 이전의 노드의 next에 저장해 새로 연결
		current.prev.next = current.next;
		// 2. 삭제할 current의 이전 노드 주소를 current의 다음 노드의 prev에 저장해 새로 연결
		current.next.prev = current.prev;
		// 3. 접근이 불가해진 current를 GC가 삭제 후 메모리 반환
		// 4. 사이즈 감소
		size--;
	}
	
	// 역방향으로 출력
	@Override
	void printAll() {
		Node current = tail.prev; // tail 노드의 prev로 만들면 역순으로 되는구나!!!!
		String str = "";
		while(current != head) { // head까지(맨 앞까지 올 때 까지)
			str += " <- " + current.data;
			current = current.prev;
		}
		
		System.out.println(str);
		
	}
	
	public static void main(String[] args) {
		LinkedList list = new DoublyLinkedList();
		
		list.addData("111", 0);
		list.addData("222", 1);
		list.addData("333", 2);
		list.addData("444", 3);		
		list.printAll();
		list.removeData(2);
		list.printAll();
		
		
		
	}
	
}


