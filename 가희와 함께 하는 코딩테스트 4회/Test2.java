import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/25239

public class Test2 {
	static boolean visit[];
	static int Time;
	static int Area;
	
	public static void main(String[] args) throws Exception  {
		System.setIn(new FileInputStream("res/test2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), ":");
		int HOUR = Integer.parseInt(st.nextToken());
		int MIN = Integer.parseInt(st.nextToken());
		Time = (HOUR * 60) + MIN;

		// 6개의 영역
		int arr[] = new int[7];
		visit = new boolean[7];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int L = Integer.parseInt(br.readLine());
		while(L-->0) {
			st = new StringTokenizer(br.readLine());
			double s = Double.parseDouble(st.nextToken());			
			String T = st.nextToken();

			if(T.equals("^")) {
				check_area();
				visit[Area] = true;
				if(check_visit()) break;
				continue;
			}	
			
			if(T.equals("10MIN")) Time += 10;
			else if(T.equals("30MIN")) Time += 30;
			else if(T.equals("50MIN")) Time += 50;
			else if(T.equals("2HOUR")) Time += 120;
			else if(T.equals("4HOUR")) Time += 240;
			else if(T.equals("9HOUR")) Time += 540;
			
			// 12시간 기준 720분이 최대
			if(Time >= 720) Time -= 720;
		}
		
		int h = 0;
		for(int i=1; i<=6; i++) {
			if(!visit[i]) h += arr[i];
		}
		
		if(h >= 100) h = 100;
		
		System.out.print(h);
	} // End of main
	
	static void check_area() {

		if((Time > 0) && (Time < 120)) Area = 1;
		else if((Time > 120) && (Time < 240)) Area = 2;
		else if((Time > 240) && (Time < 360)) Area = 3;
		else if((Time > 360) && (Time < 480)) Area = 4;
		else if((Time > 480) && (Time < 600)) Area = 5;
		else if((Time > 600) && (Time < 720)) Area = 6;
		
	} // End of check_area
	
	static boolean check_visit() {
		
		for(int i=1; i<=6; i++) if(!visit[i]) return false;
		return true;
	} // End of check_visit
} // End of Main class