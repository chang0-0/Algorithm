import java.io.*;

public class Main_2751_수정렬하기2_2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2751.txt"));
		//https://www.acmicpc.net/problem/2751
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
			
		// 처음 boolean배열 생성하면 전부 false처리 되어있음
		// false가 default 값임을 감안
		boolean[] arr = new boolean[2000001];	
        
		int N = Integer.parseInt(br.readLine());
        
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000000] = true;
		}
 
		// 최대 배열의 길이를 만들어 놓은 후
		// 들어오는 숫자를 인덱스로 바꿔서 인덱스 자리에 true 값으로 전환한다.
		// 이렇게 되면 들어온 값이 거꾸로 바뀌어도 순서대로 되어있는 array에서는 인덱스로 정리되기 때문에
		// 자동으로 정렬이된다.
		
		// 이후 array를 출력하면 자동으로 순차적으로 출력이됨.
		int size = arr.length;
		for(int i = 0; i < size; i++) {
			if(arr[i]) {
				sb.append((i - 1000000)).append('\n');
				
				System.out.println(sb);
			}
		}
		System.out.print(sb);
		


		
	}
}
