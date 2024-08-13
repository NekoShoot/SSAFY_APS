package LinkedList;

//size, head, tail
public class LinkedList {
	Node head;
	Node tail;
	int size;
	
	public LinkedList() {
		head = new Node(); // head도 node니까 새로 만들어준다!
		tail = new Node();
		head.next = tail; // doubly에서 첫 노드 추가할 때 
		tail.prev = head; // next와 prev가 null이기 때문에 생성자에서 미리 정의해줌!
	}
	
	// 삽입
	void addData(String data, int i) {};
	
	// 삭제
	void removeData(int i) {};
	
	
	// 전체 조회
	void printAll() {};
	
}