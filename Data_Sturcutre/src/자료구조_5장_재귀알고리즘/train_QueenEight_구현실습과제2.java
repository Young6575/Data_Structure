package 자료구조_5장_재귀알고리즘;

import java.util.Stack;



public class train_QueenEight_구현실습과제2 {

	static void EightQueen(int[][] d) {
		int numberOfSolutions = 0;
		int count = 0; // 퀸 배치 개수
		int ix = 0, iy = 0; // 현재 행, 열
		Stack<Point> stack = new Stack<>();

		while (true) {
			// 현재 행(ix)에서 가능한 열을 찾음
			boolean found = false;
			while (iy < 8) {
				if (checkMove(d, ix, iy)) {
					d[ix][iy] = 1;
					stack.push(new Point(ix, iy, 0));
					count++;
					ix++; // 다음 행으로 이동
					iy = 0; // 새로운 행은 열 0부터 시작
					found = true;
					break;
				} else {
					iy++;
				}
			}

			if (!found) {
				if (stack.isEmpty()) break; // 탐색 종료

				// 백트래킹: 이전 퀸 위치를 되돌림
				Point last = stack.pop();
				ix = last.getIx();
				iy = last.getIy();
				d[ix][iy] = 0;
				count--;
				iy++; // 다음 열부터 다시 시도
				continue;
			}

			if (count == 8) {
				numberOfSolutions++;
				System.out.println("해 " + numberOfSolutions + ":");
				showQueens(d);

				// 백트래킹
				Point last = stack.pop();
				ix = last.getIx();
				iy = last.getIy();
				d[ix][iy] = 0;
				count--;
				iy++;
			}
		}

		System.out.println("총 해의 수: " + numberOfSolutions);
	}

	// 해당 위치에 퀸을 놓을 수 있는지 검사
	public static boolean checkMove(int[][] d, int x, int y) {
		return checkCol(d, y) && checkDiag(d, x, y);
	}

	// 열에 퀸이 있는지 검사
	public static boolean checkCol(int[][] d, int ccol) {
		for (int i = 0; i < d.length; i++) {
			if (d[i][ccol] != 0) return false;
		}
		return true;
	}

	// 대각선 검사 (↗ ↙, ↖ ↘)
	public static boolean checkDiag(int[][] d, int row, int col) {
		int n = d.length;
		for (int i = 1; i < n; i++) {
			if (row - i >= 0 && col - i >= 0 && d[row - i][col - i] != 0) return false;
			if (row - i >= 0 && col + i < n && d[row - i][col + i] != 0) return false;
		}
		return true;
	}

	// 체스판 출력
	static void showQueens(int[][] d) {
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[0].length; j++) {
				System.out.print((d[i][j] == 1 ? "Q " : ". "));
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] data = new int[8][8];
		EightQueen(data);
	}
}
