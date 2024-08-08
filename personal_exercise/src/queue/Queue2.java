package queue;

public class Queue2 {
	static String[] queue = new String[4];
	static int front, rear;
	
	public static void main(String[] args) {
		
	}
	
	// 포화 상태 확인
	static boolean isFull() {
		return (front - rear + queue.length) % queue.length == 1;
	}
	
	// 공백 상태 확인
	static boolean isEmpty() {
		return front == rear;		
	}
	
	// 삽입
	static void enQueue(String data) {
		if(isFull()) {
			System.out.println("큐가 가득 찼습니다.");
		}
		rear = (rear+1) % queue.length;
		queue[rear] = data;
	}
	
	// 삭제
	static String deQueue() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		
		front = (front + 1) % queue.length;
		return queue[front];
	}
	
	// 조회
	static String Qpeek() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		
		return queue[(front + 1) % queue.length];
	}
}
