package 자료구조_2장_배열;

import java.util.Arrays;

/*
 * 2장: 메소드 함수에 parameter 전달
 * 메소드에 배열 전달 실습: 교재 59 - 메소드의 매개변수로 배열 사용하기
 * function parameters를 작성할 수 있어야 한다 
 */

import java.util.Random;
public class train_실습2_4메소드배열전달 {
	static int top = 0;
	static final int MAX_LENGTH = 20;
	static String name;
	public static void main(String[] args) {
	int []data = new int[10];
		inputData(data);
		showData("소스데이터",data);
		
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(data, 3);
		System.out.println("찾는 값 = " + 3 + ", 존재여부 = " + existValue);
		reverse(data);// 역순으로 출력 
		System.out.println();
		showData("역순 데이터", data);
		
	}
	static void showData(String title, int[] data) {
		//top 갯수까지 출력한다 [1,2,3]등으로 출력하도록 작성
		name = title;
		
		System.out.println(title);

		System.out.println("- for문으로 showdata -");
		System.out.print("[");
		for (int x : data)
			if 	(x==data[data.length-1]) {
				System.out.print(x + "]");				
			} else 
			System.out.print(x + ", ");
		
		System.out.println();	
		System.out.println("- Arrays의 매서드로 showdata -");
		System.out.println(Arrays.toString(data));
	}
	
	static void inputData(int[] data) {//교재 63 - 난수의 생성
		Random rnd = new Random();
		
		for (int i =0; i<data.length;i++) {
			
			data[i] = rnd.nextInt(50);
		}
		
	}
	
	static int findMax(int[] data) {
		//최대값을 리턴한다 
		int max=0;
		
		//for문으로 max 검색
		for (int x : data) {
			if (max < x) {
				max = x;
			}
		}
		
		//arrays.sort 이용
//		Arrays.sort(data);
//		max = data[data.length-1];
		
		return max;
		
	}
	
	static boolean findValue(int[] data, int num) {
		//items[]에 value 값이 있는지를 찾아 존재하면 true, 없으면 false로 리턴
		for (int x : data) {
			if(x == num) {
				return true;
			}	
		}
		return false;
	}
	
	static void reverse(int[] data) {
		int [] reversedata = new int[data.length];
		int num = data.length-1;
		
		for (int x : data) {
			reversedata[num] = x;
			num = num -1;
		}
		
		this.data = Arrays.copyOfRange(reversedata, 0, MAX_LENGTH);
		System.out.println(Arrays.toString(data));
	}

 

}
