package 자료구조_8장_리스트.과제;

import java.util.Comparator;

public class LinkedList<T> {
	private final Node<T> head; // 한번 결정하면 못바꾸도록 하려고.
	private int size;
	
	public LinkedList() {
		this.head = new Node<>(null); //dummy 노드
		this.head.setPrev(head);
		this.head.setNext(head);
		this.size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return head.getNext() == head;
	}
	
	public void addFirst(T obj) {
		Node<T> newNode = new Node<>(obj);
		Node<T> first = head.getNext();
		
		newNode.setPrev(head);
		newNode.setNext(first);
		
		head.setNext(newNode);
		first.setPrev(newNode);
		
		size++;
	}
	
	// addLast() - 나중에
	public void addLast(T obj) {
		Node<T> newNode = new Node<>(obj);
		Node<T> last = head.getPrev();
		newNode.setPrev(last);
		newNode.setNext(head);
		last.setNext(newNode);
		head.setPrev(newNode);
		size++;
	}
	
	
//	// addLast() - 나중에
//	public void addLast(T obj) {
//		Node<T> newNode = new Node<>(obj);
//		
//		if (head == null) {
//			head = newNode;
//		} else {
//			Node<T> current = head;
//			
//			while(current.getNext() != null) {
//				current = current.getNext();
//			}
//			current.setNext(newNode);
//			current.setPrev(current);
//		}
//		size++;
//	}
	
	
	public void delete(T obj, Comparator<? super T> c) {
		//	Node<T> current(현재노드)
		// 반복구문을 사용해서 current를 이동
		// 만약에 obj와 Node<T>가 같으면 삭제
		// 아니면 return 해야 됨
		
		Node<T> current = head.getNext();
		while (current != head) {
			if (c.compare(current.getData(), obj) == 0) {
				current.getPrev().setNext(current.getNext());
				current.getNext().setPrev(current.getPrev());
				size--;
				System.out.println("삭제 완료:" + obj);
				return;
			}
			current = current.getNext();
		}
		System.out.println("삭제할 데이터를 찾을 수 없습니다:" + obj);
	}
	
	public LinkedList<T> mergeNewList(LinkedList<T> lst2, Comparator<? super T> cc) {
		// if (getData(), getData <= 0 // 순서!!
		//. 추가해야 됨(addLast를 이용해서 추가 ai
		// else
		//  추가해야 됨 (addLast를 이용해서 추가) bi
		// ai 남은 리스트를 순회해서 뒷부분에 추가
		// bi 남은 리스트를 순회해서 뒷부분에 추가

		LinkedList<T> lst3 = new LinkedList<>();
		
		Node<T> ai = head.getNext();
		Node<T> bi = lst2.head.getNext();
		
		 while(ai != head && bi != lst2.head) {
			 if (cc.compare(ai.getData(), bi.getData()) <= 0) {
				 lst3.addLast(ai.getData());
				 ai = ai.getNext();
			 } else {
				 lst3.addLast(bi.getData());
				 bi.getNext();
			 }
		 }
		 
		 while (ai !=head) {
			 lst3.addLast(ai.getData());
			 ai = ai.getNext();
		 }
		 
		 while (bi !=head) {
			 lst3.addLast(bi.getData());
			 bi = bi.getNext();
		 }
		return lst3;
 	}
	
	// add할 때 순서를 보장하라는데?
	public void add(T obj, Comparator<? super T> c) {
		Node<T> newNode = new Node<>(obj);
		Node<T> current = head.getNext();
		
		//정렬된 위치를 찾아야 함
		while (current != head && c.compare(obj, current.getData()) > 0) {
			current = current.getNext();
		}
		
		//current 기준으로 앞에 삽입
		newNode.setPrev(current.getPrev());
		newNode.setNext(current);
		current.getPrev().setPrev(newNode);;
		current.setPrev(newNode);
		size++;
	}
	
	public void add(T obj) {
		
		
		Comparable<T> ComparableObj = (Comparable<T>) obj;
		add(obj, (a,b) -> ComparableObj.compareTo(b));
		
	}
	
	
	
	
}
