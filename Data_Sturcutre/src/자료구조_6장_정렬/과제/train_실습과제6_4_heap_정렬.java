package 자료구조_6장_정렬.과제;

import java.util.Random;
import java.util.Scanner;

//heap의 full, empty에 대한 예외처리 구현 권장

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
		heap = new int[MaxSize + 1]; // 인덱스 1부터 사용
		this.n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public boolean isFull() {
		return n == MaxSize;
	}

	private void HeapEmpty() {
		System.out.println("Heap is Empty");
	}

	private void HeapFull() {
		System.out.println("Heap is Full");
	}

	public int getSize() {
		return n;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("아무것도 없어요!");
			return -1; // 또는 예외 발생
		}
		return heap[1];
	}

	public void display() { // heap 배열을 출력한다. 배열 인덱스와 heap[]의 값을 출력한다.
		if (isEmpty()) {
			System.out.println("Heap is empty.");
			return;
		}
		
		
		System.out.println("Heap Array (Index : Value)");
		for (int i = 1; i <= n; i++) {
			System.out.println(i + " : " + heap[i]);
		}
	}

	@Override
	public void Insert(int x) { // max heap이 되도록 insert한다. 삽입후 complete binary tree가 유지되어야 한다.
		if (isFull()) {
			HeapFull();
			return;
		}
		n++;
		int i = n;

		// 부모 노드와 비교하며 위로 올라감 (Up-Heap)
		while (i > 1 && heap[i / 2] < x) {
			heap[i] = heap[i / 2]; // 부모 노드를 아래로 내림
			i /= 2;
		}
		heap[i] = x; // 올바른 위치에 삽입
	}

	@Override
	public int DeleteMax() { // heap에서 가장 큰 값을 삭제하여 리턴한다.
		if (isEmpty()) {
			HeapEmpty();
			return -1; // 에러 값 리턴
		}

		int max = heap[1]; // 삭제할 최대값 (루트 노드)
		int lastE = heap[n]; // 힙의 마지막 원소
		n--;

		int parent = 1; // 루트에서 시작
		int child = 2; // 루트의 왼쪽 자식

		while (child <= n) {
			// 오른쪽 자식이 존재하고, 왼쪽 자식보다 크면 child를 오른쪽 자식으로 변경
			if (child < n && heap[child] < heap[child + 1]) {
				child++;
			}

			// 마지막 원소가 자식 노드보다 크거나 같으면, 올바른 위치를 찾은 것
			if (lastE >= heap[child]) {
				break;
			}

			// 자식 노드를 부모 위치로 올림 (Down-Heap)
			heap[parent] = heap[child];
			parent = child;
			child *= 2;
		}
		heap[parent] = lastE; // 찾은 위치에 마지막 원소 삽입

		return max;
	}
} // <<-- 1. 여기에 Heap 클래스를 닫는 괄호 '}'가 빠져 있었습니다.

public class train_실습과제6_4_heap_정렬 {
	static void showData(int[] d, int length) { // 출력할 데이터 길이를 받도록 수정
		for (int i = 0; i < length; i++) {
			System.out.print(d[i] + " , ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
		final int count = 10; // 난수 생성 갯수
		int[] x = new int[count]; // x[0]부터 사용하도록 10개 정수 배열 생성

		do {
			System.out.println("\nMax Heap. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1: // 난수를 생성하여 배열 x에 넣고 > heap에 insert한다.
				for (int i = 0; i < count; i++) {
					x[i] = rnd.nextInt(100); // 0~99 사이 난수 생성
					heap.Insert(x[i]);
				}
				System.out.println("난수 " + count + "개를 생성하여 힙에 삽입했습니다.");
				System.out.print("생성된 데이터: ");
				showData(x, count);
				break;
			case 2: // heap 트리구조를 배열 인덱스를 사용하여 출력한다.
				heap.display();
				break;
			case 3: // heap에서 delete를 사용하여 삭제된 값을 배열 sorted에 넣는다
				if (heap.isEmpty()) {
					System.out.println("먼저 데이터를 삽입하세요 (메뉴 1).");
					break;
				}
				int[] sorted = new int[count]; // 정렬 결과를 저장할 배열
				int heapSize = heap.getSize(); // 현재 힙의 크기만큼만 정렬

				for (int i = 0; i < heapSize; i++) {
					sorted[i] = heap.DeleteMax();
				}
				System.out.println("힙 정렬 결과:");
				showData(sorted, heapSize);
				break;

			case 4:
				stdIn.close(); // Scanner 닫기
				System.out.println("프로그램을 종료합니다.");
				return;
			
			default:
				System.out.println("잘못된 입력입니다. 1~4 사이의 숫자를 입력하세요.");
			}
		} while (select != 4);
	}
}