package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAPI {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		// 삽입
		queue.add(1); // 추가될 수 없으면 throw exception
		queue.offer(1); // 추가될 수 없으면 return false
		System.out.println(queue);
		
		// 삭제
		queue.remove(); // 삭제될 수 없으면 throw exception
		queue.poll(); // 삭제될 수 없으면 return null;
		System.out.println(queue);
		
//		queue.remove();
		System.out.println(queue.poll());
		
		// 조회

	}

}
