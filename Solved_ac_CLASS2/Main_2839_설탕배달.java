import java.io.*;

public class Main_2839_설탕배달 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2839.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 5의 배수는 무조건 최소의 봉지수를 찾을 수 있기 때문에 결과값 바로 출력
		if(N % 5 == 0) {
			System.out.println(N / 5);
		}
		// 3의 배수이거나 5의 배수 일 경우
		else {
			int div_five = N / 5;
			int minus_five = N - 5;

			if(minus_five <= 2) {
				if(N % 3 == 0) {
					System.out.println(N / 3);
				}
				else {
					System.out.println(-1);					
				}
			}
			else {
				for(int i=div_five; i>=1; i--) {
					int count = i;
					int mod = N - (i * 5);
					
					if(mod % 3 == 0) {
						count += mod / 3;
						System.out.println(count);
						break;
					}
					else if(i == 1) {
						
						if(N % 3 == 0) {
							System.out.println(N / 3);
						}
					}
				}
				
			} // End else	
			
		} // End else
		
	} // End Main
} // End Class

