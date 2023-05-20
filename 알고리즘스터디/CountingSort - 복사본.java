package 알고리즘스터디;

import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		
		int[] array = new int[10];
		int[] counting = new int[11];
		int[] result = new int[10];
		
		// 0 ~ 30 사이의 랜덤 배열 생성.
		for(int i=0; i<array.length; i++) {
			array[i] = (int)(Math.random()*11);
		}
		
		// Counting Sort
		// 과정 1
		for(int i=0; i<array.length; i++) {
			// array의 값을 index로 하는 couning 배열에 각 값에 ++ 해줌
			counting[array[i]]++;
		}
		
		System.out.println(Arrays.toString(counting));
		
		// 과정 2
		for(int i=1; i<counting.length; i++) {
			// 누적합 구해주기
			counting[i] += counting[i-1];
		}
		
		// 과정 3
		for(int i = array.length - 1; i>= 0; i--) {
			/*
			 * array의 i번째 원소를 인덱스로 하는 counting 배열을 1 감소시킨 뒤
			 * couting 배열의 값을 인덱스로 하여 result에 value 값을 저장한다.
			 */
			int value = array[i];
			counting[value]--;
			result[counting[value]] = value;
		}
		
		// 초기 배열 
		System.out.println("array[]");
		for(int i = 0; i < array.length; i++) {
			if(i % 10 == 0) System.out.println();
			System.out.print(array[i] + "\t");
		}
		System.out.println("\n\n");
		
		// Counting 배열 
		System.out.println("counting[]");
		for(int i = 0; i < counting.length; i++) {
			if(i % 10 == 0) System.out.println(); {				
				System.out.print(counting[i] + "\t");
			}
		}
		System.out.println("\n\n");
		
		// 정렬된 배열
		System.out.println("result[]");
		for(int i = 0; i < result.length; i++) {
			if(i % 10 == 0) System.out.println();
			System.out.print(result[i] + "\t");
		}
		System.out.println();
		
	}
}
