package 자료구조_5장_재귀알고리즘;

import java.util.Arrays;

public class Knight {

	private static final int size = 8;
	private static final int[][] board= new int [size][size];
	private static final int[] xMoves = {2,1,-1,-2,-2,-1,1,2};
	private static final int[] yMoves = {1,2,2,1,-1,-2,-2,-1};
	private record Point(int x, int y) {}
	
	public static void main(String[] args) {
		
		initBoard();
		
		
		if (solve(0,0)) {
			System.out.println("기사의 여행 성공");
			printBoard();
		} else {
			System.out.println("기사의 여행 실패");
		}
		
	}
	
	private static Stream<Point> 
	
	private static void printBoard() {
		for (int[] row : board) {
			for (int num : row) {
				System.out.println(num);
			}
		}
	}

	

	private static void initBoard() {
		for (int i=0;i<size; i++) {
			Arrays.fill(board[i], 0);
		}
	}
	
	private static boolean solve(int startX, int startY) {
		// 1. 현재 위치가져오기
			Point current = new Point(startX,startY);
			
		// 2. 보드에 추가
			board[current.y()][current.x()] = 1;
		// 3. 가능한 경우의 수 다 찾아다니기
			
		// 4. 반환값
		
		
		return true;
		
		
		
		
	}
	
	private static boolean isValid(Point p) {
		return p.x() >= 0 && p.x() < size &&
			   p.y() >= 0 && p.y() < size &&
			   board[p.x()][p.y()] == 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
