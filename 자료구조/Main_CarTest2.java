public class Main_CarTest2 {
	
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
	
	public static class Carmodel extends Car{
		String name;
		String type;
		
		public Carmodel(String name, String type) {
			this.name = name;
			this.type = type;
		}
		
		public Carmodel(String name) {
			
		}
		
		public void carName(String name) {
			super.carName(name);
			System.out.println(name + "은 " + type + "입니다.");
		}		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("======= 부모 클래스 =======" + "\n");
		Car c = new Car("싼타페");
		System.out.println(c.name);
		
		c.carName("소나타", 5);
		c.carName("아반떼" + "\n");
		
		System.out.println("======= 자식 클래스 =======" + "\n");
		
		Carmodel m = new Carmodel("GV80", "SUV");
		
		System.out.println(m.name);
		System.out.println(m.type);
		
		m.carName("G70");	

	} // End of main
	
} // End of Main class