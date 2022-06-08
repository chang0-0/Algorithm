package 알고리즘스터디;
import java.util.*;
import java.util.Comparator;

public class Comparator_sort {
	public static void main(String[] args) {
		MyInteger[] arr = new MyInteger[10];
		
		// 객체 배열 초기화 (랜덤 값으로) 
		for(int i = 0; i < 10; i++) {
			arr[i] = new MyInteger((int)(Math.random() * 100));
		}
		
		for(int i=0; i<10; i++) {
			System.out.print(arr[i].value + " ");
		}
		System.out.println();
		
		Arrays.sort(arr, comp);
		for(int i=0; i<10; i++) {
			System.out.print(arr[i].value + " ");
		}
	}

	// 익명 객체(클래스)를 생성한다.
	static Comparator<MyInteger> comp = new Comparator<MyInteger>() {
		
		@Override
		public int compare(MyInteger o1, MyInteger o2) {
			return o1.value - o2.value;
		}
	};	
	
}

class MyInteger {
	int value;
	
	public MyInteger(int value) {
		this.value = value;
	}
}
