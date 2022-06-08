import java.io.*;

public class Main_2292_벌집 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2292.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long num = Integer.parseInt(br.readLine());
		
		// 정해진 규칙과 범위 확인
		// room => 1층 range ->	1
		// 2층 6개 range ->	2 ~ 7
		// 3층 12개	8 ~ 19
		// 4층 18개	20 ~ 37
		// 5층 24개	38 ~ 61
		
		int room = 1;
		int floor = 1;
		int max_range = 1;
		for(;;) {

			if(num <= max_range) {
				System.out.println(floor);
				break;
			}
			
			room = (floor*6);
			floor ++;
			max_range = max_range + room;
		}
	}
}
