public class Main_CarTest {
	
	public static class Car {
		String name;
		int num;
		
		public Car(String name) {
			this.name = name;
		}
		
		public Car() {
			
		}
		
		public void carName(String name) {
			System.out.println(name);
		}
		
		public void carName(String name, int num) {

			System.out.println(name + "가 " + num + "대 있습니다.");
		}
	} // End of Car class
	
	
	public static void main(String[] args) {
		
		Car c = new Car("싼타페");
		System.out.println(c.name);
		
		c.carName("소나타", 5);
		c.carName("아반떼");
		
	} // End of main
	
} // End of Main class