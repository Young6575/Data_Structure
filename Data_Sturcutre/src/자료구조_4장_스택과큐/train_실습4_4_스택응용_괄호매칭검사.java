package 자료구조_4장_스택과큐;


/*
문제 설명:
괄호로 이루어진 문자열이 주어졌을 때, 각 괄호가 제대로 짝을 이루고 있는지 확인하는 프로그램
괄호에는 <>, (), {}, []가 포함 
여는 괄호가 있을 때, 반드시 짝이 맞는 닫는 괄호가 나와야 하고, 
괄호는 올바르게 중첩되어야 한다.

조건:
  1. 여는 괄호는 반드시 닫는 괄호와 짝을 이뤄야 한다.
  2. 괄호들은 올바르게 중첩되어야 한다.
  3. 괄호 외의 문자는 무시한다.

입력 형식:
  한 줄에 괄호 문자열이 주어지고, 문자열은 괄호 외에도 다른 문자를 포함.

출력 형식:
  괄호가 유효하면 "Valid"를, 유효하지 않으면 "Invalid"를 출력.


*/
import java.util.*;

import com.sun.tools.classfile.Annotation.element_value;

 class Charstack {
	private List<Character> element;
	private int top; 
	private int num;
	private int size;
	
	public Charstack(int size) {
		element = new ArrayList<Character>(size);
		top=0;
		this.size=size;
	}
	
	public boolean isEmpty() {
		 return num ==0;
	}
	
	void push(char c) {
		try {
			element.add(c);
			top++;			
		} catch (Exception e) {
			System.out.println("오류 발생");
		}
	}
	
	public int pop() {
		int result = element.get(--top);
		element.remove(top);
		return result;
	}
	
}


public class train_실습4_4_스택응용_괄호매칭검사 {

	
    public static boolean isValid(String s) {
    	Stack<Character> stack = new Stack<>();
    	for (char ch : s.toCharArray()) {
//        if (ch ='(' | ch ='[' | ch ='{' | ch ='<') s.push;
    		
    		
    	}
    	
    	
    	
        //Map<Character, Character> pairs = *** // 사용 추천 "[ ]"을 map 쌍으로 정의
		HashMap<String, String> key1 = new HashMap<String, String>();
			


 
		
		
    public static void main(String[] args) {
 
        String[] cases1 = {
            "(12{as[33<1q2w3e>90]kkk}4r)fg", 
            "<111{ddd[4r(1q2w3e)44]77}jj>kk" ,
            "zz{w(a+b)*[c/d]-<q-e>1+2}w*t", 
            "dd[a+b+c(y*u[abstract]go{234}2w3e)444]ttt" , 
            "a+b<c-d<e%r{123{waste[go[stop(a+b+c(?)$)@]!]*}12}33>c-d>drop" 
        };


        String[] cases2 = {
            "a-b-c{1234[3.14(hello)kkk]1>d-w",  
            "a*b*c(121<good[days)gostop>q-w]t-1",  
            "123{hello[a-w-e(w/e/r]\n)\t}qq", 
            "q*t&w{12-34[a+b]*(c/d]-e}123", 
            "12<a/b/c/d{q-t-t[a=c(78::]23;)'8}sss>x+y+w",
        };

        System.out.println("예제1:");
        for (String test : cases1) {
            System.out.println(test + " → " + isValid(test));
        }

        System.out.println("\n예제2:");
        for (String test : cases2) {
            System.out.println(test + " → " + isValid(test));
        }
    }
}
