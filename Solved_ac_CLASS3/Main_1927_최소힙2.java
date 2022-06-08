import java.io.*;
import java.util.*;

// 문제 : https://www.acmicpc.net/problem/1927

// x가 자연수라면, 배열에 x를 넣으라는 추가하는 연산이고,
// x가 0이라면, 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거하는 경우이다.

// 우선순위 큐 -> 작은 숫자가 높은 우선순위를 가짐.

public class Main_1927_최소힙2 {
	
	static class Heap {
		int[] heap;
		int size;
		

		public Heap(int capacity) {
			heap = new int[capacity + 1];
		}
		
		public void offer(int e) {
			heap[++size] = e;
			int i = size << 1;
			
			while((i >>= 1) > 1) {
				
				if(!swap(i)) {
					break;
				}
			}
		}
		
		public int poll() {
			
			if(size == 0) {
				return 0;
			}
			
			int e = heap[1];
			heap[1] = heap[size--];
			
			int i = 1;
			while((i <<= 1) <= size) {
				if( i < size && heap[i] > heap[i + 1]) {
					i++;
				}
				
				if( !swap(i) ) {
					break;
				}
			}
			
			return e;
		}
		
		public boolean swap(int i) {
			int j = i >> 1;
			
			int p = heap[j];
			int c = heap[i];
			
			if(p < c) {
				return false;
			}
			
			heap[j] = c;
			heap[i] = p;
			
			return true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1927.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Heap heap = new Heap(N);
		
		while(N-->0) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				sb.append(heap.poll()).append('\n');
			}
			else {
				heap.offer(x);
			}

		}
		
		System.out.println(sb);
	} // End of main
	
} // End of Main class