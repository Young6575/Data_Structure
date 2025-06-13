package 자료구조_3장_검색알고리즘;

class Student {
	String sid; 
	String sname;
	String dept;
	
	public Student(String sid, String sname, String dept) {
		this.sid=sid;
		this.sname=sname;
		this.dept=dept;
	}
	

	
	
}	

public class train_실습3_10_객체comparator구현 {

	public static void main(String[] args) {
		
		Student[] students = {
			    new Student("S001", "영희", "Math"),
			    new Student("S003", "민수", "Computer"),
			    new Student("S002", "철수", "Physics"),
			    new Student("S005", "지영", "Biology"),
			    new Student("S004", "준호", "Chemistry")
			};
		
	}
}
