import java.io.*;
import java.util.*;

public class Main_1920_수찾기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1920.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		List<Long> Nlist = new ArrayList<>();
		List<Long> Mlist = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			Nlist.add(Long.parseLong(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			Mlist.add(Long.parseLong(st.nextToken()));
		}
		
		Collections.sort(Nlist);
		int Nlist_length = N-1;
		
		for(long Mnum : Mlist) {
			int halfidx = Nlist_length/2;
			int max_idx = Nlist_length;
			int min_idx = 0;
			
			long Nlist_halfValue = 0;
			
			while(max_idx >= min_idx) {
				halfidx = (max_idx + min_idx)/2;
				Nlist_halfValue = Nlist.get(halfidx);
				if(Mnum > Nlist_halfValue) {
					min_idx = halfidx + 1;
				}
				else {
					max_idx = halfidx - 1;
				}
				
				if(Nlist_halfValue == Mnum) {
					break;
				}
				
			}
			
			if(Nlist_halfValue == Mnum) {
				result.add(1);
			}
			else {
				result.add(0);
			}
			
		}	
		
		int length = result.size();
		for(int i=0; i<length; i++) {
			System.out.println(result.get(i));
		}
	}
}
