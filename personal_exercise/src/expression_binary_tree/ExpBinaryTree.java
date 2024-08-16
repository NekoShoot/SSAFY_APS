package expression_binary_tree;

public class ExpBinaryTree {
	static char[] tree = {0, '+', 'x', '-', '1', '2', '3', '4'};
	
	public static void main(String[] args) {
		inorder(1);
	}
	
	// 재귀를 통한 완전 탐색
	static void inorder(int root) {
		// 기저조건 1: index가 배열 범위를 벗어남
		if(root >= tree.length) return; 
		
		// 기저조건 2: leaf node인 경우 -> 수식트리는 항상 피연산자
		if('0' <= tree[root] && tree[root] <= '9') {
			System.out.print(tree[root]);
			return;
		}
		
		// 기저조건을 재귀 영역에 포함시키는 법
//		if(root * 2 < tree.length)
		// 재귀 영역
		inorder(root * 2); // 왼쪽 자식 노드 방문
		System.out.print(tree[root]); // 부모 노드 방문
//		if(root * 2 + 1 < tree.length)
		inorder(root * 2 + 1); // 오른쪽 자식 노드 방문
	}
	
	
	// 중위와 후위 표기식은 출력(방문) 순서만 바꾸면 됨!
}
