import java.io.*;
import java.util.*;
import java.util.Comparator;

// https://www.acmicpc.net/problem/1931
// 목표 : 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.

// 빅오는 N이 최대값 100000 이므로 정렬과 greedy 두가지를 하니까 O(2N)이 되나?
// 시간은 0.58초가 나왔다.
// 1억이 1초라고 했을 때, 2만이면 0.002초 아닌가???

public class Main_1931_회의실_배정 {
	static List<Time> list = new ArrayList<>();
	static int N;

	static class Time {
		int start;
		int end;
		
		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1931.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.add(new Time(start, end));
		}
		
		compare_sort();
				
		greedy();
		
	} // End of main
	
	static void compare_sort() {
		// 팁 : 끝나는 시간을 기준으로 정렬하면 겹치지않는 것을 찾아서 문제를 해결 할 수 있다.
		// 서로 겹치지 않는 회의시간에 대해 종료시간이 빠르면 더 많은 회의를 할 수 있다.
		
		Collections.sort(list, new Comparator<Time>() {
			// 끝나는 시간 기준으로 정렬
			@Override
			public int compare(Main_1931_회의실_배정.Time o1, Main_1931_회의실_배정.Time o2) {
				
				// 만약 종료시점이 같다면 시작시점을 기준으로 오름차순으로 정렬
				if(o1.end == o2.end) {
					return o1.start - o2.start;
				}
				
				return o1.end - o2.end;
			}
		});
	} // End of compare_sort
	
	static void greedy() {
		int count = 0;
		
		// 회의끝나는 시간 최소값 = 0
		int prev_end_time = 0;
		
		for(int i=0; i<N; i++) {
			Time time = list.get(i);
			
			// 끝나는 시간이 다음 회의가 시작되는 시간과 같거나 클 경우,
			// 즉, 끝나는 시간을 기준으로 바로 다음에 오는 겹치지 않는 회의
			// 최대한 많은 회의를 할 수 있음.
			
			if(prev_end_time <= time.start) {
				prev_end_time = time.end;
				count++;
			}

		}
		
		System.out.println(count);
	} // End of greedy
	
} // End of class
