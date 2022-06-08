import java.util.*;
import java.io.*;

public class Main_1966_프린터큐 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1966.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int i, j;
		int loop = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();
		
		for(i=0; i<loop; i++) {
			st = new StringTokenizer(br.readLine());
			// 문서의 갯수
			int paper = Integer.parseInt(st.nextToken());
			// 찾는 문서의 위치 0부터 시작
			int important = Integer.parseInt(st.nextToken());
			// 찾는 문서의 중요도.
			int find_paper= 0;
			st = new StringTokenizer(br.readLine());
			
			// 처음 덱 생성
			for(j=0; j<paper; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if(j == important) {
					find_paper = temp;
				}
				deque.add(temp);
			}			

			// 찾는 문서의 위치(index)
			int index = important;
			// 현재 가장 높은 우선순위.
			int max = Collections.max(deque);
			// 덱사이즈. 인덱스를 활용하기 위해(0기준) -1 을 해줌.
			int size = deque.size() - 1;

			// 덱에서 꺼낸 값이 최대 중요도 인지 확인함
			// 아닐 경우 앞의 값을 덱 가장 뒤로 넘기면서 앞으로 하나씩 당겨서 최고 우선순위를 가져옴.
			while(deque.peek() != max) {
				deque.addLast(deque.pop());
				
				// 인덱스가 0보자 작거나 같을 경우 현재 덱 사이즈크기로 증가(가장 뒤로 보냄을 의미)
				if(index <= 0) {
					index = size;
				}
				else {
					index --;
				}
			}
			
			// 문서가 빠져나오는 순서
			int turn = 0;
			for(;;) {
				
				// 찾는 문서의 중요도와 현재 차례의 문서 중요도가 같을 경우
				if(max == find_paper) {

					int temp = 0;
					for(int k=0; k<=index; k++) {
						temp = deque.pop();
						
						// 찾는 문서의 중요도는 일치 했고 현재 문서가 위치한 인덱스 만큼 pop() 하고
						// 앞에 있는 우선 순위 먼저 turn 함
						// 첫번째로 출력 할 경우 1이 출력됨
						if(temp == find_paper) {
							turn ++;
						}
					}
					
					System.out.println(turn);
					break;
				}
				// 찾는 문서의 중요도와 현재 차례의 문서 중요도가 불일치 할 경우
				else if(max != find_paper) {
					// 최고 우선순위가 가장 앞에 있는 상황에서 찾는 문서와 일치하지 않는 경우 덱에서 삭제.
					// 삭제 후 인덱스 감소, 사이즈 다시 계산, 문서 빠져나가는 turn 증가
					deque.pop();
					index --;
					turn ++; 
					size --;
					max = Collections.max(deque);
					
					// 최고 우선 순위문서가 나올 때 까지 회전	
					while(deque.peek() != max) {
						// 앞에 있는 값을 뒤로 넘김
						deque.addLast(deque.pop());
						
						// 인덱스 값이 0일 경우 즉 가장 앞일 때,
						if(index <= 0) {
							index = size;
						}
						else {
							index --;
						}
					}

				}
			}// for(;;) End
			deque.clear();
		
		}// for(i) End
	}// main End
}// Class End