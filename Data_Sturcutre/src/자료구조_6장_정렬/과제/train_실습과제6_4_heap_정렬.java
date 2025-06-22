package 자료구조_6장_정렬.과제;
//heap의 full, empty에 대한 예외처리 구현 권장 
import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // MaxHeap의 현재 입력된 element 개수
	private int MaxSize; // Maximum allowable size of MaxHeap
	
	public Heap(int sz) {
		this.MaxSize = sz;
		heap = new int[MaxSize +1]; // 인덱스 1부터 사용
		this.n = 0;
	}

	public boolean isEmpty() {
		return n ==0;
	}
	
	public boolean isFull() {
		return n == MaxSize;
	}
	
	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
	
	public int getSize() {
		return n;
	}
	
	public int peek() {
		if (isEmpty()) {
			System.out.println("아무것도 없어요!");
		}
		return heap[1];
	}
	
	public void display() {//heap 배열을 출력한다. 배열 인덱스와 heap[]의 값을 출력한다.
		int i;
	}	
	
	@Override
	public void Insert(int x) {//max heap이 되도록 insert한다. 삽입후 complete binary tree가 유지되어야 한다.
		// 1. isFull?
		if (isFull()) {
			//throw new FullException("가득 참") 이렇게 처리
			HeapFull();
			return;
		}
		n++;
		// 2. 공간을 생성해야 함
		int i = n;
		
		// 3. 재배치를 시작(0)
		// i의 번호를 구하는 함수
		while (i > 1 && heap[i/2] < x) {
			//교체
			heap[i] = heap[i/2];
			i = i/2;
		}
		
		// 결론적으로 i에 x를 넣고 싶은 것.
		heap[i] = x;


	}
	@Override
	public int DeleteMax() {//heap에서 가장 큰 값을 삭제하여 리턴한다. 
		if (n == 0) {
			HeapEmpty();
			int elm = 0;
			return elm;
		}

		int x = heap[1]; //반환값
		int lastE = heap[n];
		heap[1] = lastE;
		n--;
		
		int i = 1; // 루트
		int j = 2; // 왼쪽
		int comp;
		while (j <= n) {
			// 오른쪽 자식이 존재하고, 오른쪽이 더 크면 
			if (j+1 <= n && heap[j] < heap[j+1]) {
				j++;
			} 
			
			
			// 마지막 원소가 자식보다 크거나 같으면 적절한 위치
			if (lastE >= heap[j]) {
				break;
			}
			
			
			//자식을 위로 이동
			heap[i] = heap[j];
			i = j;
			j = 2 *i;
			
		}
		heap[i] = lastE;
		return x;
	}
}
public class train_실습과제6_4_heap_정렬 {
	 static void showData(int[] d) {
		 for (int i=0;i<d.length;i++) {
			 System.out.print
			 (d[i] + " , ");
		 }
	 }
	 
	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
	    final int count = 10;//난수 생성 갯수
	    int[] x = new int[count+1];//x[0]은 사용하지 않으므로 11개 정수 배열을 생성한다 
	    
	    for (int v=1;v<x.length;v++) {
	    	x[v] = rnd.nextInt(30);
	    }
	    
	    
	    int []sorted = new int[count];//heap을 사용하여 deleted 정수를 배열 sorted[]에 보관후 출력한다

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1://난수를 생성하여 배열 x에 넣는다 > heap에 insert한다.
				for (int i =1; i < x.length;i++)
					heap.Insert(x[i]);
			     showData(x);
				break;
			case 2:	//heap 트리구조를 배열 인덱스를 사용하여 출력한다.
				heap.display();
				break;
			case 3://heap에서 delete를 사용하여 삭제된 값을 배열 sorted에 넣는다 > 배열 sorted[]를 출력하면 정렬 결과를 얻는다 
			    for (int i = 0; i < count; i++) {
			        // DeleteMax()를 호출하여 가장 큰 값을 꺼내고,
			        // 그 값을 sorted 배열에 순서대로 저장합니다.
			        sorted[i] = heap.DeleteMax();
			    }
				showData(sorted);
				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}

