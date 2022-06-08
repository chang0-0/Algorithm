import java.util.*;
import java.util.Comparator;

public class ArraySort_Test {
	public static void main(String[] args) {
		MyInteger[] arr = new MyInteger[10];
		
		// 객체 배열 초기화 (랜덤 값으로)
		for(int i=0; i<10; i++) {
			arr[i] = new MyInteger((int)(Math.random() * 100));
		}
		
		System.out.print("정렬 전 : ");
		for(int i=0; i<10; i++) {
			System.out.print(arr[i].value + " ");
		}
		System.out.println();
		
		//MyInteger에 대한 Comparator를 구현한 익명객체를 넘겨줌
		Arrays.sort(arr, comp);
		
		System.out.print("정렬 후 : ");
		for(int i=0; i<10; i++) {
			System.out.print(arr[i].value + " ");
		}
	}
	
	static Comparator<MyInteger> comp = new Comparator<MyInteger>() {

		@Override
		public int compare(MyInteger o1, MyInteger o2) {
			return o1.value - o2.value;
		}
		
	};
}

class MyInteger  {
	int value;
	
	public MyInteger(int value) {
		this.value = value;
	}
}
