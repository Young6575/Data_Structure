package 자료구조_2장_배열;

import java.util.Random;

public class 행렬_참고용 {

	public static void main(String[] args) {

		// 1.3행 5열짜리 표 A 만들기
				int[][] arrA = new int[3][5];

				Random rnd = new Random();
				for (int i = 0; i < arrA.length; i++) {

					for (int j = 0; j < arrA[i].length; j++) {
						arrA[i][j] = rnd.nextInt(10);
					}
				}

				System.out.print("[A반 시험점수]");
				for (int[] row : arrA) {
					System.out.println();

					for (int x : row) {
						System.out.print(x + " ");

					}

				}

		// 2.같은 크기 표 B 만들고 무작위 점수 채우기
				System.out.println('\n');
				
				int[][] arrB = new int[3][5];

				for (int i = 0; i < arrB.length; i++) {

					for (int j = 0; j < arrB[i].length; j++) {
						arrB[i][j] = rnd.nextInt(99);
					}
				}

				System.out.print("[B반 시험점수]");
				for (int[] row : arrB) {
					System.out.println();

					for (int x : row) {
						System.out.print(x + " ");

					}

				}
				
		// 3.C = A + B
				System.out.println('\n');
				int[][] sumArr = new int [3][5];
				
				for (int i=0; i<arrA.length;i++) {
					for (int j=0; j<arrA[i].length;j++) {
						
						sumArr[i][j] = arrA[i][j] + arrB[i][j];
						
					}
				}
				
				System.out.print("[A+B반 시험점수]");
				for (int[] row : sumArr) {
					System.out.println();

					for (int x : row) {
						System.out.print(x + " ");

					}

				}
				
				
				
		// 4.5행4열 표D 만들기
		//D[5][4]는 예를 들어 과목별 프로젝트 점수라고 생각해보자
				
				System.out.println('\n');
				int[][] arrD = new int [5][4];
				
				for (int i=0; i<arrD.length;i++) {
					for (int j=0; j<arrD[i].length;j++) {
						
						arrD[i][j] = rnd.nextInt(10);
						
					}
				}
				
				System.out.print("[D반 프로젝트점수]");
				for (int[] row : arrD) {
					System.out.println();

					for (int x : row) {
						System.out.print(x + " ");

					}

				}
				
				
		// 5.E = A X D
				int sum =0;
				
				//arrA [3][5]
				//arrD [5][4]
				// arrE [arrA의 행 갯수][arrD의 열 갯수]
				int [][] arrE = new int [3][4];
				
				//arrA 기준으로 행방향으로 내려가면서 진행
				//arrA 행방향으로 한번씩 돌고 그 다음에 arrD 다음열로 넘어가는 방식으로 진행
				
				//arrD를 열방향으로 +1
				for (int i=0; i < arrD[i].length;i++) {
					
					//arrA를 행방향으로
					for (int j=0; j < arrA.length;j++) {
						
						// 각각 곱해서 arrE에 데이터 입력
						for (int k=0; k < arrA[0].length;k++) {
							
					 sum = sum + arrA[j][k] * arrD[k][i];
				
						}
						
						arrE[j][i] = sum;
						sum = 0;
					}
					
					
				}
				
				System.out.println('\n');
				System.out.print("[A*D 행렬곱셈]");
				for (int [] row : arrE) {
					System.out.println();
					
					for (int x : row) {
						
						System.out.print(x + " ");
					}
					
				}

		// 6.F = D의 전치 행렬
						
						int [][] arrF = new int [4][5];
				
				for(int i=0; i<arrD.length;i++) {
					
					for (int j=0;j<arrD[i].length;j++) {
						
						arrF[j][i] = arrD[i][j];
					}
					
				}

				System.out.println('\n');
					System.out.print("[표D의 전치행렬]");
					for (int[] row : arrF) {
						
						System.out.println();
						
						for (int x : row) {
							System.out.print(x + " ");
						}
						
					}
					
		// 7.G = A X F
					
				

			
				

		// 8.E와 G가 같은지 비교

		// 9.2차원 배열을 테이블 행태로 출력

			}
	
	
}
