package 자료구조_4장_스택과큐;


/*
 * 실습 4_3번
 * point(x,y) 객체를 스택에 저장
 * 좌표를 스택에 구현 소스 코드 - 5장에서 활용
 * 예외 처리 코드를 이해하는 것이 필요
 * 스택 구현을 배열이 아닌 list로 구현
 */


import java.util.ArrayList;
import java.util.List;
/*
* objectStack에 Point2 객체를 push, pop하는 코드를 구현 실습한다
*/
import java.util.Random;
import java.util.Scanner;
class Point2 {
	private int ix;
	private int iy;

	public Point2(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return ix + " / " +iy;
	}

	@Override
	public boolean equals(Object p) {
		return false;

	}
}

class objectStack{
	

	/*
	 * 정수스택 버젼을 참조하여 예외처리 완성
	 * --- 실행시 예외: 스택이 비어있음 ---
	 * generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	 */
	//--- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
//추가
		public EmptyGenericStackException(String msg) {
			super(msg);
		}
	}

	//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
//추가
		public OverflowGenericStackException(String msg) {
			super(msg);
		}
	}

    private List<Point2> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

//--- 생성자(constructor) ---//
	public objectStack(int capacity) {
		//구현
		data = new ArrayList<Point2>(capacity);
		top=0;
		this.capacity=capacity;
	}

//--- 스택에 x를 푸시 ---//
	public boolean push(Point2 x) throws OverflowGenericStackException {
		if (isFull()) throw new OverflowGenericStackException("stack이 가득찼습니다.");
		//구현
		data.add(x);
		top++;
		return true;
	}

//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point2 pop() throws EmptyGenericStackException  {
		if (top == 0)
			throw new EmptyGenericStackException("저장된 데이터가 없습니다.");
			
		//구현
		return data.get(--top);
	}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point2 peek() throws EmptyGenericStackException  {
		if (top == 0)
			throw new EmptyGenericStackException("저장된 데이터가 없습니다.");
		//구현
		return data.get(top-1);
	}

//--- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point2 x) {
		//구현
		
		return 1;
	}

//--- 스택의 크기를 반환 ---//
	public int getCapacity() { 
		return capacity;
	}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		if 	(top ==0) return true;
		else return false;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		if (top == capacity) return true;
		else return false;
	}

//--- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() {
		
		//구현
		for (int i =0;i < top;i++) {
			System.out.println(i + " : " + data.get(i));
		}
	}
}
public class 실습4_2_2객체스택_리스트 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		objectStack s = new objectStack(8); // 최대 8 개를 push할 수 있는 stack
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point2 p = null;
		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(5)clear (0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			switch (menu) {
			case 1: // 푸시
				System.out.print("데이터: ");
				rndx = random.nextInt(20);
				rndy = random.nextInt(20);
				p = new Point2(rndx,rndy);
				try {
					s.push(p);
					System.out.println(p);
				} catch(objectStack.OverflowGenericStackException e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 팝
				try {
					p = s.pop();
					System.out.println("pop한 데이터는 " + p + "입니다.");
				} catch(objectStack.EmptyGenericStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek();
					System.out.println("peek한 데이터는 " + p + "입니다.");
				} catch (objectStack.EmptyGenericStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
				
			case 5: //초기화
				s.clear();
				break;
			}
		}
	}
}
