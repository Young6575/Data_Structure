package 자료구조_3장_검색알고리즘;

import java.util.Arrays;

class Student {
	String sid; 
	String sname;
	String dept;
	
	public Student(String sid, String sname, String dept) {
		this.sid=sid;
		this.sname=sname;
		this.dept=dept;
	}


	@Override
	public String toString() {
		return sid + ", " + sname + ", " + dept;
	}
	
	
}


public class train_실습3_9객체comparable구현 {

	public static void main(String[] args) {
		
		Student[] students = {
			    new Student("S001", "영희", "Math"),
			    new Student("S003", "민수", "Computer"),
			    new Student("S002", "철수", "Physics"),
			    new Student("S005", "지영", "Biology"),
			    new Student("S004", "준호", "Chemistry")
			};
		System.out.println("=== 정렬 전 학생 목록 ===");
		show(students);
		
		
		Arrays.sort(students,(s1,s2) -> s1.sid.compareTo(s2.sid));
		System.out.println("=== 정렬 후 학생 목록 ===");
		show(students);
		
		
		Student[] targets = {
			    new Student("S002", "철수", "Physics"),
			    new Student("S006", "홍길동", "Law"),
			    new Student("S004", "준호", "Chemistry")
			};
		
			System.out.println();
			for (Student x : targets) {		
				int index = Arrays.binarySearch(students,x,(o1, o2) -> o1.sid.compareTo(o2.sid));
				
				if (index >= 0 ) System.out.println("찾은 학생: " + x);
				 else if (index < 0)  System.out.println("학번" + x.sid + "인 학생은 존재하지 않습니다."); 
				
			}
		
	}

	private static void show(Student[] students) {
		for (int i=0; i<students.length;i++) {
			System.out.println(students[i].toString());
		}
	}
	

}
	


	