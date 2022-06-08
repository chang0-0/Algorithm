import java.io.*;
import java.util.*;

public class Main_2798_블랙잭 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2798.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int temp = (Integer.parseInt(st.nextToken()));
			
			if(temp >= M) {
				continue;
			}
			else {
				list.add(temp);
			}
		}
		
		Collections.sort(list, Collections.reverseOrder());

		int first = 0;
		int second = 0;
		int third = 0;
		int size = list.size();
		int min = list.get(size-1);
		
		for(int i=0; i<size; i++) {			
			int sum = M;
			first = list.get(i);
			int sum1 = first;
			int sum2 = 0;
			int sum3 = 0;
		
			for(int j=i+1; j<size; j++) {
				second = list.get(j);
				sum2 = sum1 + second;
				
				// 적어도 M값에서 list에서 가장 작은 값을 뺀값 보다는 작거나 같아야함.
				// 마지막값이 최소값일 경우를 생각.
				if(sum2 <= (M-min)) {
					for(int k=j+1; k<size; k++) {
						third = list.get(k);
						sum3 = sum2 + third;
						if(sum3 <= M) {
							
							if(sum - sum3 >= 0) {
								result.add(sum3);
							}
							else {
								sum3 = sum2;
							}
							
						}
						
					} // End for(k)
				}
				sum2 = sum1;
				
			} // End for(j)

		} // End for(i)
		System.out.println(Collections.max(result));
		
	}// End Main
}// End Class
