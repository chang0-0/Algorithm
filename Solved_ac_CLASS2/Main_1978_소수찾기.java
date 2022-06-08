import java.util.*;
import java.io.*;

public class Main_1978_소수찾기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1978.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;	
		int loop = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<loop; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int prime_Number = 0;
		for(int i=0; i<loop; i++) {
			// 소수의 개수
			int temp = list.get(i);		
			
			// 1은 소수가 아니기 때문에 건너뜀.
			if(temp == 1) {
				continue;
			}
			else {
				// 에라토스 테네스의 체 사용.
				int sqrt = (int) Math.sqrt(temp);
				
				// sqrt 1은 무조건 소수임(2와 3이 해당).
				if(sqrt == 1) {
					prime_Number++;
				}
				else {
					for(int j=2; j<=sqrt; j++) {
						
						if(temp % j == 0) {
							// 한번이라도 나머지가 0이 걸리는 게 있다면 소수가 아니기때문에 out	
							break;
						}
						
						if(j == sqrt) {
							// 소수 증가
							prime_Number++;
						}
					}
				}
			}
			
		}
		System.out.println(prime_Number);
	}
}