package 자료구조_8장_리스트.과제;

import java.util.Comparator;

public class DoubledLinkedList2 {
	private Node4 first; // 머리 포인터(참조하는 곳은 더미노드)

	
	// --- 생성자(constructor) ---//
	public DoubledLinkedList2() {
		first = new Node4(); // dummy(first) 노드를 생성
		first.setData(null);
		first.setLlink(first); 
		first.setRlink(first);
	}

	// --- 리스트가 비어있는가? ---//
	public boolean isEmpty() {
		return first.getRlink() == first;
	}

	// --- 노드를 검색 ---//
	public boolean search(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		return false;

	}

	// --- 전체 노드 표시 ---//
	public void show() {
		// 헤드 다음부터 검색
		Node4 current = first.getRlink(); 
		
		while (current != first) {
			System.out.println(current.getData().no +" / "+ current.getData().name +" / "+ current.getData().expire);
			current = current.getRlink();
		}
	}

	// --- 올림차순으로 정렬이 되도록 insert ---//
	public void add(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		Node4 newNode = new Node4();
		newNode.setData(obj);
		Node4 current = first.getRlink();
		
		
		
		while (c.compare(obj, current.getData()) >= 0) {
			current = current.getRlink();
		}
		
		newNode.setLlink(current);
		newNode.setRlink(current.getRlink());
		
		current.setRlink(newNode);
		current.getRlink().setLlink(newNode);
	}

	// --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
	public void delete(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {

	}
	
	public DoubledLinkedList2 merge_NewList(DoubledLinkedList2 lst2, Comparator<SimpleObject2> cc) {
		//l3 = l1.merge(l2); 실행하도록 리턴 값이 리스트임 
		//l.add(객체)를 사용하여 구현
		//기존 리스트의 노드를 변경하지 않고 새로운 리스트의 노드들을 생성하여 구현 
		DoubledLinkedList2 lst3 = new DoubledLinkedList2();
		Node4 ai = this.first.rlink, bi = lst2.first.rlink;



		return lst3;

	}
	void merge_InPlace(DoubledLinkedList2 b, Comparator<SimpleObject2> cc) {
		/*
		 * 연결리스트 a,b에 대하여 a = a + b
		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
		 * 난이도 등급: 최상급
		 * 회원번호에 대하여 a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
		 */
		Node4 p = first.rlink, q = b.first.rlink;
		Node4 temp = null;


	}
}