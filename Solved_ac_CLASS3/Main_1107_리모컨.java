import java.util.*;
import java.io.*;

public class Main_1107_리모컨 {
	// 처음에 해결하려던 방식은 문자열을 하나씩 쪼개서 숫자를 조합하려고 했는데,
	// 테스트케이스상 반례가 너무 많아서 if문이 남발해지고 코드 자체가 지저분해져서
	// 해결 불가라는 결론을 내림
	
	static List<Integer> list = new ArrayList<>();
	static int count;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1107.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		// BufferedReader로 입력을 받을 때 주의!
		// M이 0으로 입력됬을때는 br.readLine()을 하지 않도록 조건을 지정해줘야한다.
		if( M != 0) {
			st = new StringTokenizer(br.readLine());
			while(M-- > 0) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}

		int min = Math.abs(N - 100);
		
		// M값이 10일 경우, 탐색 과정 필요 없이 min값을 바로 출력하면됨.
		// +버튼과 - 버튼만 가능
		if(M == 10) {
			System.out.println(min);
		}
		else {
			for(int i = 0; i <= 999999; i++) {			
				remote_control(i);
	      
				// 전체를 탐색하면서 가장 낮게 나온 값 min을 정답으로 채택한다.
				if(count > 0) {
					min = Math.min(min, Math.abs(N - i) + count);				
				}
					
			}
			System.out.print(min);
		}

	} 
	
	private static void remote_control(int num) {
		// remote_control 함수가 실행될 때 마다 count가 0으로 초기화 되어야 함
		count = 0;
		
		// 0부터 시작인데 0을 누를 수 없는 경우
		// 0에서 출발 안하고 100에서 출발 하므로 min값 유지
		if(num == 0 && list.contains(num)) {
			count = 0;
			return;
		}
		// 0부터 시작인데, 0을 누를 수 있는 경우
		// 0을 누를 수 있는 경우, 0을 눌러서 count + 1;
		else if(num == 0 && !list.contains(num)) {
			count = 1;
			return;
		}
		
		// 0~9 자리의 리모컨 번호 특성상 10이하의 값을 list에서 찾기위함.
		while(num > 0) {
			if(list.contains(num % 10)) {
				count = 0; 
				return;
			}
			else {
				count++;
				num /= 10;
				
			}
			
		}
		
	}
}
