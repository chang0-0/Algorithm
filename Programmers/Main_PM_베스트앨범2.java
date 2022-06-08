import java.util.*;

public class Main_PM_베스트앨범2 {
	
	public int[] solution(String[] genres, int[] plays) { 
    	HashMap<String, Integer> map = new HashMap<>();
    	
    	// 장르만 들어있는 list
    	ArrayList<String> genre_list = new ArrayList<>();
    	
    	for(int i=0; i<genres.length; i++) {	
    		if( !map.containsKey(genres[i]) ) {
    			genre_list.add(genres[i]);
    		}	
    		map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
    	}
    	
    	Collections.sort(genre_list, (o1, o2) -> map.get(o2) - map.get(o1));
    				
		ArrayList<Integer> result_list = new ArrayList<>();
		for(int i=0; i<genre_list.size(); i++) {
			String genre_name = genre_list.get(i);
			
			int max = 0;
			int firstId = -1;
			for(int j = 0; j < genres.length; j++) {
				// 장르는 같은 재생횟수가 더 높을 경우.
				if(genre_name.equals(genres[j]) && max < plays[j]) {
					max = plays[j];
					firstId = j;
				}
			}
			
			max = 0;
			int secondId = -1;
			for(int j=0; j<genres.length; j++) {
				if( genre_name.equals(genres[j]) && max < plays[j] && j != firstId ) {
					max = plays[j];
					secondId = j;
				}
			}
			
			result_list.add(firstId);
			if(secondId >= 0) {
				result_list.add(secondId);
			}
		}
		
		int result_arr[] = new int[result_list.size()];
    	for(int i=0; i<result_list.size(); i++) {
    		result_arr[i] = result_list.get(i);
    	}
    	
    	return result_arr;
    	
	} // End of solution()
	
	public static void main(String[] args) {
		Main_PM_베스트앨범2 s = new Main_PM_베스트앨범2();
		
		String genres[] = {"classic", "pop", "classic", "classic", "pop"};
		int plays[] = {500, 600, 150, 800, 2500};
		
		System.out.println(Arrays.toString(s.solution(genres, plays)));
	}
} // End of class