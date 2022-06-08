import java.util.Comparator;

/*
main 함수 밖에 정적(static) 타입으로 선언해도 되고, main함수 안에 지역변수 형식처럼 사용할 수 도 있다.

외부에서 Comparator를 구현하는 익명객체가 생성되었기 때문에, 
Student 클래스 내부에서 우린 Comparator을 구현해줄 필요가 없어졌다.
즉, 이전에 a.compare(b,c) 이런식이 아니라, 위에서 생성한 익명객체를 가리키는 comp를 통해 
comp.compare(b, c) 이런 식으로 해주면 된다는 것이다.
*/

public class Comparator_Test {
	public static void main(String[] args) {
		
		Student2 a = new Student2(17, 2);
		Student2 b = new Student2(18, 3);
		Student2 c = new Student2(19, 1);
		
		// a객체와는 상관 없이 b와 c객체를 비교한다.
		int isBig = comp.compare(b, c);
		
		if(isBig > 0) {
			System.out.println("b객체가 c객체보다 큽니다.");
		}
		else if(isBig == 0) {
			System.out.println("두 객체의 크기가 같습니다.");
		}
		else {
			System.out.println("b객체가 c객체보다 작습니다.");
		}
	}
	
	public static Comparator<Student2> comp = new Comparator<Student2>() {

		@Override
		public int compare(Student2 o1, Student2 o2) {
			return o1.classNumber - o2.classNumber;
		}
	};
}

class Student2 implements Comparator<Student2> {
	int age;
	int classNumber;
	
	Student2(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}
	
	@Override
	public int compare(Student2 o1, Student2 o2) {
		return o1.classNumber - o2.classNumber;
	}
}

