package 자료구조_5장_재귀알고리즘;

import java.util.Stack;
//실습

//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking
//모든 해가 나오는 버젼 만들기 
/*
 * 체스판은 8 x 8 체스의 기물: king/가로세로대각선 1칸만 이동, queen/가로세로 대각선/같은 편의 기물을 넘을 수 없다,
 * Rook/가로,세로 이동/다른 기물을 넘을 수없다, bishop/대각선, knight/1-2칸 이동/다른 기물을 넘을 수 있다,
 * pawn/처음 이동은 2칸까지 가능, 그 후 한칸만 가능, 잡을 때는 대각선 가능 체스판 최대 배치 문제 : king/16,
 * Queen/8, rook/8, bishop/?, knight/? rook 2개/a, h, knight 2개/b, g, bishop
 * 2개/c, f, queen 1개/black queen은 black 칸에, 폰 8개
 */
/*
 * 8-Queen 문제는 체스판 위에 8개의 퀸을 배치하되, 서로 공격할 수 없도록 배치하는 문제입니다. 
 * 이 문제를 해결하기 위한 비재귀적(스택 기반) 알고리즘을 구현하려면, 다음과 같은 방법을 사용할 수 있습니다.

개요
1. 스택을 사용하여 백트래킹을 구현합니다. 각 스택의 요소는 체스판의 각 열에 대한 퀸의 배치 상태를 나타냅니다.
2. 퀸을 한 줄씩 배치한 후, 유효한지 확인하고, 다음 줄로 이동합니다.
3. 유효하지 않으면 스택을 이용해 이전 상태로 돌아가서 다른 경로를 시도합니다.

알고리즘
1. 스택을 이용하여 백트래킹을 구현하기 때문에, 현재 상태를 스택에 저장합니다. 
   스택의 각 원소는 퀸의 배치를 나타냅니다.
2. 체스판의 각 열에 대해 가능한 위치를 하나씩 확인하면서 퀸을 배치하고, 
   충돌이 발생하지 않는다면 다음 열로 넘어갑니다.
3. 더 이상 유효한 위치가 없으면, 스택에서 이전 상태로 되돌아가서 새로운 경로를 탐색합니다.
4. 퀸을 8개 다 배치하면, 해를 찾은 것이므로 스택을 이용해 해결책을 저장합니다.
 */
class Point {
	private int ix;
	private int iy;
	private int flag;

	public Point(int x, int y, int flag) {
		ix = x;
		iy = y;
		this.ix = x;
		this.iy = y;
		this.flag = flag;
	}

	public int getIx() {
		return ix;
	}

	public int getIy() {
		return iy;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}

public class train_QueenEight_구현실습과제 {

	static void EightQueen(int[][] d) {

		int numberOfSolutions = 0;
		int count = 0;// 퀸 배치 갯수
		int ix = 0, iy = 0;// 행 ix, 열 iy
		Stack<Point> stack = new Stack<>(); // 담을 스택만들기
		Point p = new Point(ix, iy, 0);// 현 위치를 객체로 만들고
		stack.push(p);// 스택에 현 위치 객체를 push

//			if (!stack.isEmpty() && ix == 8) // ix가 8이면 8개 배치 완료, stack이 empty가 아니면 다른 해를 구한다
//				break;
while (true) {
	
		while (ix < d.length) {
			
			if (stack.isEmpty()) {
				System.out.println("\n총 해의 갯수 : " + numberOfSolutions);
				return;
			}
			
			Point currentPoint = stack.peek();
			
			int Moveresult = nextMove(d, ix, iy); // 해당 행에 배치할 곳이 있는지 검사 로직
			
			if (Moveresult == -1) {// 다음 이동할 열을 iy로 주는데 -1이면 더이상 이동할 열이 없음을 나타냄
				stack.pop();
				d[currentPoint.getIx()][currentPoint.getIy()] = 0;
				ix--;
				iy = currentPoint.getIy() + 1;
				count--;

			} else {
				stack.push(new Point(ix, Moveresult, 0));
				d[ix][Moveresult] = 1;
				count++;
				ix++;
				iy = 0; 
			}		
		}
		
			numberOfSolutions++;
		
			System.out.println("\n해 " + numberOfSolutions + " :");
			showQueens(d);
			
			Point lastqueen = stack.pop();
			d[lastqueen.getIx()][lastqueen.getIy()] = 0;
			ix = lastqueen.getIx(); 
			iy = lastqueen.getIy()+1;
			count--;
		
		
}  

	}

	public static boolean checkCol(int[][] d, int row, int ccol) {// 배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
		for (int i = 0; i < row; i++) {
			if (d[i][ccol] != 0)
				return false;
		}
		return true;
	}

	// 배열 d에서 행 cx, 열 cy에 퀸을 남서⬋, 북동⬈ 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		int x = cx - 1;
		int y = cy + 1;

		// 북동⬈ 대각선
		while (x >= 0 && y < d[0].length) {
			if (d[x][y] != 0)
				return false;
			x--;
			y++;
		}
		// 남서⬋ 대각선 row 밑으로는 아직 배치가 되지 않았기에 code 불필요
//		while (y > 0) {
//			x++; y--;
//			if (d[x][y] != 0)
//				return false;
//		}

		return true;

	}

	// 배열 d에서 행 cx, 열 cy에 퀸을 남동⬊, 북서⬉ 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
		int x = cx - 1;
		int y = cy - 1;

		// 남동⬊ 대각선 row 밑으로는 아직 배치가 되지 않았기에 code 불필요
//		while (x < d[0].length) {
//			x++; y++;
//			if (d[x][y] != 0)
//				return false;
//		}
		// 북서⬉ 대각선
		while (x >= 0 && y >= 0) {
			if (d[x][y] != 0)
				return false;
			x--;
			y--;
		}
		return true;
	}

	// 배열 d에서 (x,y)에 퀸을 배치할 수 있는지 조사
	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if (checkCol(d, x, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y))
			return true;
		return false;
	}

	// 배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
	public static int nextMove(int[][] d, int row, int col) {// 현재 row, col에 대하여 이동할 col을 return
		for (int i = col; i < d[0].length; i++) {
			if (checkMove(d, row, i))
				return i;
		}
		return -1;
	}

	static void showQueens(int[][] data) {// 배열 출력
		for (int[] row : data) {
			for (int x : row) {
				if (x == 0)
					System.out.print(". ");
				else
					System.out.print("Q");
			}
			System.out.println();

		}
	}

	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[8][8];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		EightQueen(data);

	}
}