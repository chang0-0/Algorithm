import java.util.*;
import java.io.*;

public class Main_2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2869.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long V = Long.parseLong(st.nextToken());
		
		// 목표거리 - 뒤로가는 거리
		long destination = V - B;
		// 낮에 이동거리와 밤에 미끄러지는 거리의 차이 
		// 목표 도달 전 하루 이동 거리.
		long dist = A - B;
		
		long div = destination / dist;
		long mod = destination % dist;
		// div값은 낮에 앞으로 이동후 밤에 뒤로가는 반복으로 인해 생기는 기간
		// mod는 반복후에 마지막에 남는 값이 낮에 이동 범위에 속하는지 확인하기 위해 사용
		// mod가 0이 아닐 경우는 낮에 이동하는 거리로 도달 가능하므로 1일을 추가해야됨,
		// mod가 0일 경우 div값 만으로도 도달 가능을 의미
		
		long day = div;
		if(mod != 0) {
			day = day + 1;
			System.out.println(day);
		}
		else {
			System.out.println(day);
		}
		
	}
}
