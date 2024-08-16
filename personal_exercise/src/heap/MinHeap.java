package heap;

// 최소 힙
public class MinHeap {
	static int[] heap = new int[100];
	static int heapSize = 0;
	
	public static void main(String[] args) {
		heapPush(20);
		heapPush(49);
		heapPush(33);
		heapPush(15);
		heapPush(-20);
		heapPush(0);
		heapPush(6);
		
		while(heapSize != 0) {
			int popItem = heapPop();
			System.out.println(popItem);
		}
	}
	
	
	static void swop(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
	
	// 삽입
	// -> 완전 이진트리의 마지막에(가장 높은 레벨의 가장 왼쪽부터채우기)
	static void heapPush(int data) {
		heap[++heapSize] = data; // 0번 idx는 사용하지 않기 때문에(rootIdx == 1)
		
		// 부모의 idx는 자식의 1/2, child는 부모의 *2와 *2+1
		int parent = heapSize / 2;		
		int child = heapSize;
		
		// 부모-자식 대소관계 -> 최소힙에선 항상 부모가 자식보다 작음
		while(heap[parent] > heap[child] && child != 1) { // 대소 관계에 벗어난다면 && 루트에 도달하기 전까지
			// swop
			swop(parent, child);
			
			// 반복해서 비교
			child = parent;
			parent = child / 2;
		}
	} 
	
	// 삭제 및 반환 연산
	static int heapPop() {
		// 1. 루트에 있는 데이터 저장
		int popItem = heap[1];
		
		// 2.  마지막 노드를 루트로 이동
		heap[1] = heap[heapSize--]; // 옮기고 사이즈 줄이기(삭제했으므로)
		
		// 3. 자식과 부모 대소 비교 후 swop 반복
		int parent = 1;
		int child = parent * 2; // 왼쪽 자식 노드
		
		// 오른쪽 자식 노드가 있는 지 확인 후 대소 비교를 먼저 해서 더 작은 값 저장(최소 힙)
		if(child+1 <= heapSize && heap[child] > heap[child+1]) {
			child++; // 오른쪽 자식 노드 값이 더 작으면 그걸 가리키도록 
		}
		
		while(heap[child] < heap[parent] && child <= heapSize) { // 리프 노드에 도달했는지(힙 범위 넘지 않도록)
			swop(parent, child);
			
			// 4. swop 이후 index 갱신해서 재귀식 탐색 
			parent = child;
			child = parent * 2;
			if(child+1 <= heapSize && heap[child] > heap[child+1]) {
				child++; // 오른쪽 자식 노드 값이 더 작으면 그걸 가리키도록 
			}
		}
				
		return popItem;
	}
}
