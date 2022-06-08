public class Anonymous_Test {
	public static void main(String[] args) {
		
		Rectangle R = new Rectangle();
		
		// 익명 객체 1
		Rectangle anony = new Rectangle() {
			@Override
			int get() {
				return width;
			}
		};
	
		// height만 return
		System.out.println("R.get() : " + R.get());
		
		// main내부 익명객체 width 값을 return
		System.out.println("anony.get() : " + anony.get());
		
		// main외부 익명객체 get() 함수를 재정의 한 결과를 return
		System.out.println("anony2.get() : " + anony2.get());
	}
	
	static Rectangle anony2 = new Rectangle() {
		int depth = 30;

		@Override
		int get() {
			return width * height * depth;
		}
	};
}

class Rectangle {
	int width = 10;
	int height = 20;
	
	int get() {
		return height;
	}
}