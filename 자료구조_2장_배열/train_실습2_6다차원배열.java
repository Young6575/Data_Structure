package 자료구조_2장_배열;


/*
 * 3번째 실습
 * 교재 83 - 배열 처리 + function parameter 전달 숙달 훈련 
 *  함수에서 배열을 리턴할 때 리턴 타입 정의할 수 있어야 한다
 */

import java.util.Arrays;
import java.util.Random;
public class train_실습2_6다차원배열 {

	public static void main(String[] args) {
		int [][]A = new int[2][3];
		int [][]B = new int[3][4];
		int [][]C = new int[2][4];

		inputData(A);inputData(B);
		int [][]D = A.clone();//교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData("행렬 A", A);
		System.out.println("D[2][3] = ");
		showData("행렬 D", D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData("행렬 B", B);
		int [][]E = addMatrix(A,D);
		System.out.println("E[2][3] = ");
		showData("행렬 E", E);
		C = multiplyMatrix(A,B);
		System.out.println("C[2][4] = ");
		showData("행렬 C", C);

		int [][]F = transposeMatrix(B);
		System.out.println("F[3][2] = ");
		showData("행렬 F", F);
		C= multiplyMatrixTransposed(A,F);
		showData("행렬 곱셈 결과-전치행렬 사용", C);
		boolean result = equals(A,C);
		if (result)
			System.out.println("행렬 A,C는 equal이다");
		else
			System.out.println("행렬 A,C는 equal 아니다");
	}
	static void inputData(int [][]data) {
		Random rnd = new Random();
		
		for (int i=0; i < data.length;i++) {
			for (int j=0;j < data[i].length;j++) {
				data[i][j] = rnd.nextInt(20);
			}
		}
	}
	static void showData(String msg, int[][]items) {
		System.out.println("[" +msg + "]");
		
		for (int[] row : items) {
			for (int x : row) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		System.out.println();
//		System.out.println(Arrays.deepToString(items));
	}
	
	static boolean equals(int[][]a, int[][]b) {
		//행렬 a,b의 행의 수, 열의 수가 같아야 하고 각 원소가 같아야 한다.

	}
	static int[][] addMatrix(int [][]X, int[][]Y) {
		int [][] result = new int[X.length][X[0].length];
		
		for (int i=0;i<X.length;i++) {
			for (int j=0;j<X[i].length;j++) {
				result[i][j] = X[i][j] + Y[i][j];
			}
		}
		return result;
	} 
	
	static int[][] multiplyMatrix(int [][]X, int[][]Y) {

		
	}
	static int[][] transposeMatrix(int [][]X) {

		
	}
	static int[][] multiplyMatrixTransposed(int [][]X, int[][]Y){
		
	}
}

