package queue;

public class Queue1 {
	static String[] queue = new String[10];
	static int front = -1;
	static int rear = -1;
		
	public static void main(String[] args) {
		
	}
	
	// isEmpty
	static boolean isEmpty() {
		return front == rear;
	}
	
	// isFull
	static boolean isFull() {
		return rear == queue.length-1;
	}
	
	// enQueue
	static boolean enQueue(String item) { // void가 아니라 boolean으로도 만들 수 있구나!
		if(isFull()) {
			System.out.println("큐가 가득찼습니다");
			return false;
		}
		
		queue[++rear] = item;
		return true;
	}
	
	// deQueue
	static String deQueue() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다");
			return null;
		}
		
		return queue[++front]; // 원소를 삭제하는 게 아니라 queue의 범위를 줄이는 느낌
	}
	
	// Qpeek
	static String Qpeek() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다");
			return null;
		}
		
		return queue[front + 1];
	}
	
	
}
