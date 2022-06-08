import java.io.*;
import java.util.Map.Entry;
import java.util.*;

// https://www.acmicpc.net/problem/1159
// 목표 : 상근이가 선수 다섯 명을 선발할 수 없는 경우에는 "PREDAJA" (따옴표 없이)를 출력한다.
// 선발할 수 있는 경우에는 가능한 성의 첫 글자를 사전순으로 공백없이 모두 출력한다.

public class Main_1159_농구경기 {
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1159.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Character, Integer> map = new HashMap<>();
		
		while(N --> 0) {
			String str = br.readLine();
			char ch = str.charAt(0);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}		
		
		Iterator<Entry<Character, Integer>> it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Entry<Character, Integer> entrySet = (Entry<Character, Integer>)it.next();   
			
			if(entrySet.getValue() >= 5) {
				sb.append(entrySet.getKey());
			}
		}
		
		
		if(sb.length() == 0) {
			System.out.println("PREDAJA");
		}
		else {
			System.out.println(sb);
		}
		
	}
} // End of class