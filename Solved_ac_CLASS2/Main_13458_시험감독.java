import java.util.*;
import java.io.*;

public class Main_13458_시험감독 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_13458.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long sum = 0;
		for(int i=0; i<N; i++) {
			int people = list.get(i);
			people = people - B;
			
			// 총 감독이 관리가능한 인원수 보다 응시생이 많을 경우
			if(people > 0 ) {
				sum++;		
				
				if(people > 0) {
					if(C < people) {
						int div = people / C;		
						sum += div;
						
						int mod = people % C;
						if(mod >= 1) {
							sum++;
						}						
					}
					else {
						sum++;
					}
									
				}	
			}
			// 총 감독한명으로도 응시생들을 모두 커버 가능 할 때
			else {
				sum++;
			}
				
		}

		System.out.println(sum);
	}
}
