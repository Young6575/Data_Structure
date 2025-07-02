package 자료구조_8장_리스트.과제;

public class Node4 { 
	private SimpleObject2 data; // 데이터
	private Node4 llink; // 좌측포인터(앞쪽 노드에 대한 참조)
	private Node4 rlink; // 우측포인터(뒤쪽 노드에 대한 참조)
	
	
	public SimpleObject2 getData() {
		return data;
	}
	public void setData(SimpleObject2 data) {
		this.data = data;
	}
	public Node4 getLlink() {
		return llink;
	}
	public void setLlink(Node4 llink) {
		this.llink = llink;
	}
	public Node4 getRlink() {
		return rlink;
	}
	public void setRlink(Node4 rlink) {
		this.rlink = rlink;
	}

}