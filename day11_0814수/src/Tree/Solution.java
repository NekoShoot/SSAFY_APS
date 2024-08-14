package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Node {
	Node parent;
	String data;
	int id;
	List<Node> children = new LinkedList<>(); // 자식 노드들	
	
	Node() {}
}

// left와 right를 미리 만들어 놓고 들어오면 그 때 할당하는 방식
// idx 할당하고 새로 추가할 때마다 ++
// map<key, value> 이용해서 탐색 <idx, Node>
// root.index == 1;

class TreeLinkedList {
	static Map<Integer, Node> nodeMap = new HashMap<>();
	Node root;
	int size;
	int cnt = 1;
	
	TreeLinkedList() {}
	
	// id <- 부모 node의 이름
	void addData(String data, int id) {		
		if(id < 0 || id > cnt) {
			System.out.println("탐색하려는 id가 범위 밖!");
			return;
		} 
		
		Node newNode = new Node();			
		newNode.data = data;
		newNode.id = cnt++;		
		
		if(id == 0) { // root일 경우
			newNode.parent = null;
			root = newNode;
		} else {
			newNode.parent = nodeMap.get(id); // 부모와 edge 연결			
			newNode.parent.children.add(newNode); // 부모의 자손으로 만들어주기
		}		
		
		nodeMap.put(newNode.id, newNode); // map에 넣어주기
		size++;
	}
	
	// id <- 삭제하려는 node 이름
	void removeData(int id) {
		if(id < 0 || id > cnt) {
			System.out.println("탐색하려는 id가 범위 밖!");
			return;
		}
		
		Node node = nodeMap.get(id);
		// parent랑 연 끊어야 하고
		List<Node> parentsChildrenList = node.parent.children;
		// 순회하면서 node 찾기
		if(parentsChildrenList != null) {
			for(Node child : parentsChildrenList) {
				if(child == node) child = null;
			}
		}
						
		// children이랑 연 끊어야 됨
		List<Node> nodesChildrenList = node.children;
		if(nodesChildrenList != null) {
			for(Node child : nodesChildrenList) {
				child.parent = null;
			}
		}
		
		// map 제거
		nodeMap.remove(id);
	}
	
	void printWithParent(int id) {
		System.out.println("이 node의 데이터는 " + nodeMap.get(id).data + "입니다.");
		
		if(id == 1) System.out.println("이 node의 parent는 " + nodeMap.get(id).parent + "입니다.");
		else System.out.println("이 node의 parent는 " + nodeMap.get(id).parent.data + "입니다.");
				
	}
	
	void printWithChildren(int id) {
		Node node = nodeMap.get(id);
		System.out.println("이 node의 데이터는 " + node.data + "입니다.");
		
		List<Node> children = node.children;
		if(children == null) System.out.println("이 노드엔 자손이 없습니다.");
		else {
			for(Node child : children) {
				System.out.printf("이 노드의 자손은 %s입니다.\n", child.data);
			}
			
		}
		
	}
}




public class Solution {	
	public static void main(String[] args) {
		// linkedList로 tree 구현
		TreeLinkedList tree = new TreeLinkedList();
		tree.addData("111", 0);
		tree.addData("222", 1);
		tree.addData("333", 2);
		tree.addData("1444", 1);
		
		tree.printWithParent(2);
		tree.printWithChildren(1);
	}	
}

