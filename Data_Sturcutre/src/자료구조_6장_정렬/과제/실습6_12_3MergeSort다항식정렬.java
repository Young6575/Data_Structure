package 자료구조_6장_정렬.과제;
/*
 * 6장 구현과제3
 */

class Polynomial3 implements Comparable<Polynomial3>{
    double coef;           // 계수
    int    exp;            // 지수

    Polynomial3(){}
    
    //--- 생성자(constructor) ---//
    Polynomial3(double coef, int exp) {
        this.coef = coef;  
        this.exp = exp; 
    }
    
    @Override
    public int compareTo(Polynomial3 o) {
    	return Integer.compare(this.exp, o.exp);
    }

}


public class 실습6_12_3MergeSort다항식정렬 {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(Polynomial3[] a, int lefta, int righta, int leftb, int rightb ) {
		
		//body를 지우고 작성 훈련 연습이 도움이 된다 
		Polynomial3 temp[] = new Polynomial3[30];
		int i = lefta;
		int j = leftb;
		int k = 0;
		//구현코드
		
		// 1. 두 배열을 1대1로 비교
		while (i <= righta && j <= rightb) {
			//a[i]가 차수가 더 큰 경우
			if (a[i].compareTo(a[j]) > 0) {
				temp[k++] = a[i++];
			} 
			//a[i]가 차수가 작거나 같은 경우
			else temp[k++] = a[j++];
		}
		
		// 2. 1대1 비교 후 뒤에 하나가 남을 경우 temp 뒤에 붙여넣기
		while (i <= righta) {
			temp[k++] = a[i++];
		}
		
		while (j <= rightb) {
			temp[k++] = a[j++];
		}
		
		// 3. type이 void이니 a[]에 정렬 된 temp[]를 넣어주기
		for (i = 0; i <k; i++) {
			a[lefta + i] = temp[i];
		}
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(Polynomial3[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) 
			return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
			return;
	}
	static void ShowPolynomial(String str, Polynomial3[] x, int count) {
		//str 변수는 다항식 이름으로 스트링이다
		//count가 -1이면 다항식 x의 length로 계산하고 -1이면 count가 다항식 항의 숫자이다 
		//정렬후 다항식 x = 2.5x**7  + 3.8x**5  + 3.1x**4  + 1.5x**3  + 3.3x**2  + 4.0x**1  + 2.2x**0 
		int n = 0;
		if (count < 0)
			n = x.length;
		else
			n = count;
		//구현코드
		System.out.print(str);
		for (int i=0; i < n; i++) {
			//지수 0일 경우
			if (i == n-1) 
				System.out.print(x[i].coef);
			else 
				System.out.print(x[i].coef +"x**"+x[i].exp + " + ");
		}
		System.out.println();
	}
	static int AddPolynomial(Polynomial3[]x,Polynomial3[]y,Polynomial3[]z) {
		//z = x + y, 다항식 덧셈 결과를 z로 주고 z의 항의 수 terms을 리턴한다 
		int p=0,q=0,r=0;
		int terms = 0;
		//구현코드
		// 1. 1대1 비교
		while (p < x.length && q < y.length ) {
			
			//x 지수가 큰 경우
			if (x[p].compareTo(y[q]) > 0) 
				terms = addTerm(z, x[p++], terms);
			// 그 외의 경우
			else
				terms = addTerm(z, y[q++], terms);
		}
		
		// 2. 남은 부분 더하기

		while (p < x.length) addTerm(z, x[p++], terms);
		while (q < y.length) addTerm(z, y[q++], terms);
		
		return terms;
		
	}
	static int addTerm(Polynomial3[]z, Polynomial3 term, int terms) {
		//다항식 z에 새로운 항 term을 추가한다. 지수가 같은 항이 있으면 계수만 합한다
		//추가된 항의 수를 count하여 terms으로 리턴한다.
		//구현코드
		
		for (int i=0; i < terms;i++) {
			if (z[i].exp == term.exp) {
				z[i].coef += term.coef;
				return terms; 
			}
		}
		
		z[terms] = term;
		
		return ++terms;
			
	}
	static int MultiplyPolynomial(Polynomial3[]x,Polynomial3[]y,Polynomial3[]z) {
		//z = x * y, 다항식 z의 항의 수는 terms으로 리턴한다 
		//terms = addTerm(z, term, terms);사용하여 곱셈항을 추가한다.
		int p=0,q=0,r=0;
		int terms = 0;
		//구현코드
		return terms;
	}
	static double EvaluatePolynomial(Polynomial3[]z, int zTerms, int value) {
		//zTerms는 다항식 z의 항의 수, value는 f(x)를 계산하기 위한 x 값
		//다항식 계산 결과를 double로 리턴한다 
		double result = 0.0;
		//구현 코드
		return result;
	}
	public static void main(String[] args) {
		Polynomial3[] x = {
		         new Polynomial3(1.5, 3),
		         new Polynomial3(2.5, 7),
		         new Polynomial3(3.3, 2),
		         new Polynomial3(4.0, 1),
		         new Polynomial3(2.2, 0),
		         new Polynomial3(3.1, 4),
		         new Polynomial3(3.8, 5),
		     };
		Polynomial3[] y = {
		         new Polynomial3(1.5, 1),
		         new Polynomial3(2.5, 2),
		         new Polynomial3(3.3, 3),
		         new Polynomial3(4.0, 0),
		         new Polynomial3(2.2, 4),
		         new Polynomial3(3.1, 5),
		         new Polynomial3(3.8, 6),
		     };
		int nx = x.length;


		ShowPolynomial("다항식 x = ", x, -1);
		ShowPolynomial("다항식 y = ", y, -1);
		MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
		MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
		ShowPolynomial("정렬후 다항식 x = ", x, -1);
		ShowPolynomial("정렬후 다항식 y = ", y, -1);
		
		Polynomial3[] z = new Polynomial3[20];
		
		for (int i =0; i < z.length; i++)
			z[i] = new Polynomial3();
	
		int zTerms = AddPolynomial(x,y,z);//다항식 덧셈 z = x + y
		ShowPolynomial("덧셈후 다항식 z = ", z, zTerms);

		
		zTerms = MultiplyPolynomial(x,y,z);//다항식 곱셈 z = x * y
		MergeSort(z, 0, zTerms); // 배열 x를 퀵정렬
		ShowPolynomial("곱셈후 다항식 z = ", z, zTerms);
		double result = EvaluatePolynomial(z, zTerms, 1);//다항식 값 계산 함수 z(10) 값 계산한다 
		System.out.println(" result = " + result );
	}
}
