package 자료구조_5장_재귀알고리즘;
/*
 * 미로 찾기 문제
 * plato(LMS)의 미로 찾기 문제 설명 자료 학습
 * int input[12][15] 테이블에서 입구는 (0,0)이며 출구는 (11,14)임
 * 미로 테이블 (12,15)을 상하좌우 울타리를 친 maze[14][17]을 만들고 입구는 (1,1)이며 출구는(12,15)
 * stack을 사용한 backtracking 구현
 */

import java.util.Stack;

//23.2.16 수정
//23.2.24: 객체 배열 초기화, static 사용, 내부 클래스와 외부 클래스 사용 구분을 못하는 문제 => 선행 학습 필요
enum Directions {N, NE, E, SE, S, SW, W, NW}
class Items {
	int x;
	int y;
	int dir;
	
	public Items(int x, int y, int dir) {
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
	
}
class Offsets {
	int a;
	int b;
}

public class train_실습_미로찾기실습과제 {

	static Offsets[] moves = new Offsets[8];//static을 선언하는 이유를 알아야 한다
	Stack<Items> stack = new Stack<>();
	
	
	 void path(int maze[][], int mark[][], int m, int p) {//m = 12, p = 15
	//출발점 (1,1), 이동 방향 dir = 2(2는 동쪽) 을 스택에 push
	//initialize stack to the maze entrance coordinates and direction east;
		int x = 1;
		int y = 1;
		int dir = 0;
		Items item = new Items(x,y,dir);
		stack.push(item);
		mark[x][y] =3;
		boolean moved;
		int count =4;
		
		
		while (!stack.isEmpty()) {
			
            // 출구에 도달했는지 확인 (12, 15)
            if (x == 12 && y == 15) {
                System.out.println("출구에 도달했습니다!");
                break;
            }
			moved = false;
			
			//안착 후 8방향 탐색
			while (dir<8) {
				// 1이 아니여서 갈 수 있을 때 & 안가본 길일 때
				int nextx = x+moves[dir].a;
				int nexty = y+moves[dir].b;
				
				if( 0<nextx && nextx<14 && 0<nexty && nexty<17
				&&	maze[nextx][nexty] != 1 
				&& mark[nextx][nexty] == 0) {
					moved = true;
					break;
				}
				dir++;
			}	
			
			if (moved == true) {
				
				//dir 업데이트
				Items current = stack.pop();
				stack.push(new Items(current.x,current.y,dir));
				
				x = x+moves[dir].a;
				y = y+moves[dir].b;
				
				//탐색 완료된 곳 저장
				stack.push(new Items(x,y,0));
				mark[x][y]=count++;
				dir = 0;
			}
			else {
				if (stack.size() > 1)
				stack.pop();
				
				Items pre = stack.peek();
				x = pre.x;
				y = pre.y;
				dir = pre.dir+1;	
			}
		}


	} 

	
	static void show(String msg,int[][] map) {
		System.out.println(msg);
		for (int[] row : map) {
			
			for (int x : row) {
				System.out.print(x + " | ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets();//배열에 offsets 객체를 치환해야 한다.
		moves[0].a = -1;	moves[0].b = 0;   // N  (북쪽, 위쪽)
		moves[1].a = -1;	moves[1].b = 1;   // NE (북동쪽, 오른쪽 위 대각선)
		moves[2].a = 0;		moves[2].b = 1;   // E  (동쪽, 오른쪽)
		moves[3].a = 1;		moves[3].b = 1;   // SE (남동쪽, 오른쪽 아래 대각선)
		moves[4].a = 1;		moves[4].b = 0;   // S  (남쪽, 아래쪽)
		moves[5].a = 1;		moves[5].b = -1;  // SW (남서쪽, 왼쪽 아래 대각선)
		moves[6].a = 0;		moves[6].b = -1;  // W  (서쪽, 왼쪽)
		moves[7].a = -1;	moves[7].b = -1;  // NW (북서쪽, 왼쪽 위 대각선)

		//Directions d;
		//d = Directions.N;
		//d = d + 1;//java는 지원안됨
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				//테두리를 1로 울타리 치기.
				if (i == 0 || i == 13 || j ==0 || j==16) {
					
					maze[i][j] = 1;
					
				}
				//input[][]을 maze[][]로 복사
				if (i < input.length && j < input[0].length) {
					
					maze[i+1][j+1] = input[i][j];
					mark[i+1][j+1] = input[i][j];
				}
			}
		}
		
		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);

		train_실습_미로찾기실습과제 p = new train_실습_미로찾기실습과제();
		
		p.path(maze, mark, 12, 15);
		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);

		

	}
}
