import java.util.*;
import java.io.*;

public class Main_피보나치함수_재귀 {
	public static void main(String[] args) throws Exception {
		int input = 8;
		
		for(int i=1; i<=input; i++) {
			System.out.println("i : " + i);
			System.out.println(fibonacci(i));
			System.out.println("---------------------------------");
		}
		
	}
	
	public static int fibonacci(int n) {
		
		System.out.println("n : " + n);
		if(n <= 1) {
			return n;
		}
		else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
		
	}
	
}
