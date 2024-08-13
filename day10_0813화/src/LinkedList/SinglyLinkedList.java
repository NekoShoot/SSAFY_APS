package LinkedList;

public class SinglyLinkedList extends LinkedList {
	@Override
	void addData(String data, int i) {
		if(i < 0 || i > size) {
			System.out.println("범위 밖!");
			return;
		}

		// head로부터 출발해서 i번째 앞에 있는 노드 찾기(그 뒤에 삽입해야 되니까)
		Node current = head;
		for(int m = 0; m < i; m++) {
			current = current.next; // 현재 노드에 다음 노드를 대입해서 계속 넘어가는 방식
		}
		// 반복이 끝나면 current는 i-1번째의 node
		// 1. i-1번째 node의 link를 new node에 복사
		Node newNode = new Node();
		newNode.data = data;
		
		newNode.next = current.next;
		// 2. i-1번째 node의 link를 new node의 주소로 변경
		current.next = newNode;
		// 3. size 증가
		size++;
	}
	
	@Override
	void removeData(int i) {
		if(i < 0 || i > size) {
			System.out.println("범위 밖!");
			return;
		}
		
		// head로부터 출발해 i-1번째 찾기
		// double과 다르게 앞 노드를 참조할 수 없어서 무조건 앞에걸 찾아서 정방향으로 가야됨!
		Node current = head;
		for(int m = 0; m < i; m++) {
			current = current.next;
		}
		// 반복이 끝나면 current에 지우고 싶은 i번째 바로 앞 노드가 있음
		// 1. i-1의 링크 필드(다음 노드 주소 값)를 다음 다음 노드 주소로 변경		
		current.next = current.next.next;
		// 2. size 감소
		size--;		
	}
	
	@Override
	void printAll() {
		// 이 구현 방식은 head가 dummy이므로
		Node current = head.next; // 첫번째 노드부터 출력
		
		while(current != null) { // 마지막 노드에 다다를 때 까지
			System.out.print(current.data + " -> ");
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList list = new SinglyLinkedList();
		
		list.addData("111", 0);
		list.addData("222", 1);
		list.addData("333", 2);
		list.addData("444", 3);	
		
		list.printAll();
		
		list.removeData(2);
		System.out.println("/");
		
		list.printAll();
	}
}
