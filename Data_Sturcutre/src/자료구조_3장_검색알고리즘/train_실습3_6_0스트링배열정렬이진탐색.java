package 자료구조_3장_검색알고리즘;

import java.io.Console;
/*
 * 3장 2번 실습과제 - 스트링 배열의 정렬과 이진검색 
* 교재 121 실습 3-6 
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
*/
import java.util.Arrays;

public class train_실습3_6_0스트링배열정렬이진탐색 {
	
	static void showData(String str, String[] data) {
		System.out.println(str +'\n' + Arrays.toString(data));
	}	

	static String[] sortData(String[] data) {
		int min=0;
		int minindex=0;
		String temp;
		for (int i = 0; i<data.length;i++) {
			for (int j=i+1;j<data.length;j++) {
				if (data[i].compareTo(data[j])>0) {
					minindex = j;
				} else minindex=i;
			}
			temp = data[i];
			data[i]=data[minindex];
			data[minindex]=temp;
		}
		return data;
	}
	
	static int linearSearch(String[] data, String key) {
		int i=0;
		int end=data.length-1;
		
		
		while (i<=end) {
			if (data[i]== key) {
				return i;
			} else 
				i++;
		}
		return -1;
	}

	static int binarySearch(String[] data, String key) {
			int start=0;
			int end=data.length-1;
			int standnum=0;
			
			while (standnum<2) {
				
				standnum = (start+end)/2;
				System.out.println(data[standnum]);
				if (data[standnum] == key) return standnum;
				else if (data[standnum].compareTo(key) > 0) {
					end = standnum-1;
				} else if (data[standnum].compareTo(key) < 0) {
					start = standnum+1;
				}
				System.out.println(data[standnum]);
			}
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		String []data = {"사과","포도","복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외"};
		showData("정렬전", data);
		sortData(data);//올림차순으로 정렬 교재211-212 단순 선택 정렬 알고리즘으로 구현
		showData("정렬후", data);

		String key = "포도";
		int resultIndex = linearSearch(data, key);//교재 100 페이지 seqSearch() 함수로 구현
		System.out.println("\nlinearSearch(포도): key = " + key + ", result 색인 = " + resultIndex);

		key = "포도";
		resultIndex = binarySearch(data, key);//교재 109 페이지 binSearch() 함수로 구현
		System.out.println("\nbinarySearch(배):key = " + key + ",  result = " + resultIndex);
//		key = "산딸기";
//		/*
//		 * 교재 115 Arrays.binarySearch에 의한 검색
//		 * public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
//		 *     @Override
//		 *     public int compareTo(String anotherString) {
//		 *             return this.compareTo(anotherString);
//		 *     }
//		 *	}
//		 *
//		 *  binarySearch(String[], String key)를 호출하면, 
//		 *  내부적으로 String 배열이 자동으로 Comparable<String>[]로 해석.
//		 */
//		resultIndex = Arrays.binarySearch(data, key);//교재 120 페이지 API 참조
//		//교재 116 표 3-3: static int binarySearch(Object[] a, Object key)가 사용됨 - 단 배열 a는 Comparable을 구현한 객체들로 정렬되어 있어야 함
//		
//		System.out.println("\nArrays.binarySearch(산딸기): key = " + key + ", result = " + resultIndex);
	}
}
