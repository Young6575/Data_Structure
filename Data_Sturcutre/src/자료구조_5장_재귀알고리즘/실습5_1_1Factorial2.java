package 자료구조_5장_재귀알고리즘;
/*
 * 실습 5-2: n n factorial() 함수를 간결한 코딩으로 해결
 * 삼항 조건 연산자를 사용한 대표적 사례로서 기억해야 함
 */


import java.util.Scanner;

class 실습5_1_1Factorial2 {

 //--- 음이 아닌 정수 n의 팩토리얼 값을 반환 ---//
 static int factorial(int n) {
	 //recursive 함수를 간결한 코딩으로 해결 - 학습 요점이다 
	 System.out.println(n + "* factorial(" + n + "- 1)5");
     return (n > 0) ? n * factorial(n - 1) : 1;
 }

 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.print("정수를 입력하세요 : ");
     int x = stdIn.nextInt();

     System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
 }
}
