import java.util.*;
import java.io.*;

public class Main_2775_부녀회장이될테야 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2775.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		LinkedList<Integer> linkedList = new LinkedList<>();		
	
		for(int i=0; i<T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			// 각 층의 1호는 무조건 1명이므로 공통
			if(n==1) {
				linkedList.add(1);
			}
			else {
				int sum = 0;
				for(int l=0; l<=k; l++) {
					
					for(int j=1; j<=n; j++) {
						
						System.out.println(l + "층 " + j + "호 ============");
						if(l == 0) {
							linkedList.add(j);
						}
						else {
							sum += linkedList.poll();
							linkedList.add(sum);
							System.out.println("거주민 수 : " + sum + "명");
						}
						
						System.out.println("linkedList : " + linkedList);	
					}
					sum = 0;
				}
			}
			
			System.out.println(linkedList.getLast());
			linkedList.clear();
		}

	}
}
