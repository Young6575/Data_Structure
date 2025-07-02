package 자료구조_8장_리스트.과제;


public class Node<T> {
	private  T Data;
	private Node<T> Prev;
	private Node<T> Next;
	
	public Node(T data) {
		
		this.Data = data;
		this.Prev = null;
		this.Next = null;
	}

	public T getData() {
		return Data;
	}

	public void setData(T data) {
		Data = data;
	}

	public Node<T> getPrev() {
		return Prev;
	}

	public void setPrev(Node<T> prev) {
		Prev = prev;
	}

	public Node<T> getNext() {
		return Next;
	}

	public void setNext(Node<T> next) {
		Next = next;
	}
	
}
