package Queue_구현;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> {
	// 선형 큐 동적 구현
	/*
	 * - front: 삭제만
	 * - rear: 삽입만
	 * enQueue(): 삽입
	 * deQueue(): 삭제
	 * createQueue(): 공백 큐 생성
	 * isEmpty(): 공백 확인
	 * isFull(): 포화 확인
	 * Qpeek(): rear 값 확인
	 */
	
	// member field
	public List<T> queue;
	public int front = -1;
	public int rear = -1;
	
	// 기본 생성자
	public Queue() {}
	
	public Queue(List<T> queue) {
		this.queue = queue;
	}
	
	// 공백 큐 생성
	public void createQueue() {
		this.queue = new LinkedList<>();
	}
			
	// isEmpty()
	public boolean isEmpty() {
		return front == rear; 
	}
	
	// isFull()
//	public boolean isFull() {
//		return rear == n-1; (정적 배열에서는 끝이 정해져 있으므로)
//	}
	
	// enQueue()
	public void enQueue(T item) {
		// 동적 구현에서는 full 구현이 안되는 거 같다..?(limit이 없어서)
	
//		if(isFull()) {
//			System.out.println("큐가 가득 차 더 이상 삽입할 수 없습니다.");
//			return;
//		}
		
		rear++;
		this.queue.add(item);		
	}
	
	// deQueue()
	public T deQueue() {
		if(this.queue.isEmpty()) {
			System.out.println("큐가 비어있어 값을 꺼낼 수 없습니다.");
			return null;
		}
		
		return queue.get(++front);		
	}
	
	public T Qpeek() {
		if(this.queue.isEmpty()) {
			System.out.println("큐가 비어있어 값을 꺼낼 수 없습니다.");
			return null;
		}
		
		return queue.get(front + 1);
	}
	
}