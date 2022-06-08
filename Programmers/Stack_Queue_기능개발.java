import java.util.*;

public class Stack_Queue_기능개발 {
	static final Queue<Integer> progresses_que = new LinkedList<>();
	static final Queue<Integer> speeds_que = new LinkedList<>();
	static final List<Integer> list = new ArrayList<>();
	
	public int[] solution(int [] progresses, int[] speeds) {		
		int size = progresses.length;
				
		for(int i=0; i<size; i++) {			
			progresses_que.add(progresses[i]);
			speeds_que.add(speeds[i]);
		}

		while( !progresses_que.isEmpty() ) {
			
			size = progresses_que.size();
			for(int i=0; i<size; i++) {
				int progress = progresses_que.poll();
				int speed = speeds_que.poll();
				
				progresses_que.add(progress + speed);
				speeds_que.add(speed);
			}
			
			int peek = progresses_que.peek();
			
			int count = 0;
			while(peek >= 100) {
					count ++;
					progresses_que.poll();
					speeds_que.poll();
					
					if(!progresses_que.isEmpty()) {
						peek = progresses_que.peek();						
					}
					else {
						break;
					}
			}
			
			if(count != 0) {
				list.add(count);
			}
		}
			
		size = list.size();
		int answer[] = new int[size];
		int i=0;
		
		for(int num : list) {
			answer[i] = num;
			i++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		Stack_Queue_기능개발 s = new Stack_Queue_기능개발();
		int arr[] = {95, 90, 99, 99, 80, 99};
		int arr2[] = {1, 1, 1, 1, 1, 1};

		System.out.println(Arrays.toString(s.solution(arr, arr2)));
	}
}
