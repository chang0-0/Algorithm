import java.io.*;
import java.util.*;
import java.util.Map.Entry;

// https://www.acmicpc.net/problem/1969

// 나올 수 있는 알파벳은 4개뿐
// A, T, G, C
// 미리 알파벳을 순서대로 배열로 생성

public class Main_1969_DNA {
	static int sum = 0;
	static String result = "";
	static int N, M;
	static String arr[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1969.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new String[N];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		DNA();
		
		System.out.println(result);
		System.out.println(sum);
		
	} // End of main
	
	static void DNA() {
		char ch = ' '; // 문자
		int max; // 최대값
		
		// 각 글자마다 가장 많이 나온 글자를 result에 연결시킨다.
		for(int i=0; i<M; i++) {
			HashMap<Character, Integer> map = new HashMap<>();
			max = 0;
			
			for(int j=0; j<N; j++) {	
				String str = arr[j];
				
				map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
			}
						
			// 탐색
			Iterator<Entry<Character, Integer>> it = map.entrySet().iterator();
			
			while(it.hasNext()) {
				Entry<Character, Integer> entrySet = (Entry<Character, Integer>)it.next();
				int value = entrySet.getValue();
				char key =  entrySet.getKey();
				
				// 가장 많이 나온 알파벳 선택.
				if( max < value ) {
					max = value;
					ch = key;
				}
				// 값이 같을 경우 사전순으로 나열
				else if(max == value) {
					// 기존에 있던 ch와 key값을 사전순서로 비교해야함
					char temp = key;
					
					int num1 = Character.getNumericValue(ch);
					int num2 = Character.getNumericValue(temp);
					
					if(num1 > num2) {
						ch = temp;
					}
				}
			}

			// 가장 많이 나온 알파벳의 갯수를 전체와 빼면 
			//Hamming Distance의 최소값이 나옴
			sum += N - max;
			result += ch;
		}
		

	} // End of solution
} // End of class