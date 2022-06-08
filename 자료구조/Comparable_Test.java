import java.util.*;

public class Comparable_Test {
	public static void main(String[] args) {
		Student a = new Student(17 , 2);
		Student b = new Student(18 , 3);
		
		// comparable의 특징 
		// 자기 자신과 비교이므로 a와 b를 비교함.
		int isBig = a.compareTo(b);
		
		if(isBig > 0) {
			System.out.println("a객체가 b객체보다 큽니다.");
		}
		else if(isBig == 0) {
			System.out.println("두 객체의 크기가 같습니다.");
		}
		else {
			System.out.println("a객체가 b객체보다 작습니다.");
		}
		
	}
}


class Student implements Comparable<Student> {
	int age;
	int classNumber;
	
	Student(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}
	
	
	@Override
	public int compareTo(Student o) {
		
		/*
		 * 만약 자신의 age가 o의 age보다 크다면 양수가 반환 될 것이고,
		 * 같다면 0을, 작다면 음수를 반환할 것이다.
		 */		
		return this.age - o.age;
		
	}
}
