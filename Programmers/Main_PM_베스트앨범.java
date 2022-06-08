import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42579
// 장르별 상위2개의 곡 선택
// 장르에 속한 곡이 하나일 경우 하나만 선택
// 장르 종류는 하나 미만.

// 1. 장르별 전체 재생 횟수를 파악 => Map을 통해서 구현
// 2. 장르 안에서 많이 재생된 노래를 순서대로 수록
// 3. 장르안에서 재생 횟수가 같은 노래 중에서는 id(고유번호)가 낮은 노래를 먼저 수록한다.

// 인접리스트 구현 > 장르별 리스트 안에 각 곡의 재생 횟수와 이름 값들을 가짐

public class Main_PM_베스트앨범 {

	static class Music {
		String genre_name;
		int Streaming;
		int id;

		public Music(String genre_name, int id, int Streaming) {
			this.genre_name = genre_name;
			this.id = id;
			this.Streaming = Streaming; 
		}
	}
	
    public int[] solution(String[] genres, int[] plays) {
    	HashMap<String, Integer> map = new HashMap<>();
    	ArrayList<String> genre_list = new ArrayList<>();

    	int genres_len = genres.length;
    	for(int i=0; i<genres_len; i++) {
    		
    		if( !map.containsKey(genres[i]) ) {
    			genre_list.add(genres[i]);
    		}	
    		map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
    	}
    	
    	// 장르만 담긴 genre_list를 재생횟수가 높은 순으로 정렬
    	Collections.sort(genre_list, (o1, o2) -> map.get(o2) - map.get(o1));
    	
    	ArrayList<Music> result = new ArrayList<>();
    	for(String genr : genre_list) {
    		ArrayList<Music> list = new ArrayList<>();
    		
    		
    		// genre_list에서 나오는 각 장르 genr의 값을 기준으로
    		// genres의 배열과 genr가 일치하는 값을 list에 Music객체형으로 삽입함
    		
    		// Ex) genre_list에서 pop이 가장 앞에 있으니까 pop이 가장 먼저 나오고,
    		// genres[] 배열에서 pop가 같은 장르를 list에 집어 넣음
    		// 이렇게 하면 pop장르의 노래들만 geres[]배열에서 찾아서 넣을 수 있음
    	
    		for(int i=0; i<genres_len; i++) {
    			if(genres[i].equals(genr)) {
    				list.add(new Music(genr, i, plays[i]));
    			}
    		}
    		
    		// 재생횟수가 높은 순으로 list를 오름차순 정렬함.
    		Collections.sort(list, (o1, o2) -> o2.Streaming - o1.Streaming);

    		// 장르에 포함된 곡을 2개 result에 담기
    		result.add(list.get(0));
    		
    		// 장르에 포함된 곡이 1개 일 경우 하나만 포함
    		if(list.size() > 1) {
    			result.add(list.get(1));
    		}
    	}
    	
    	
    	int result_size = result.size();
    	int arr[] = new int[result_size];
    	for(int i=0; i<result_size; i++) {
    		arr[i] = result.get(i).id;
    	}
    	
    	return arr;
    }
    
	public static void main(String[] args) {
		Main_PM_베스트앨범 s = new Main_PM_베스트앨범();
		
		String genres[] = {"classic", "pop", "classic", "classic", "pop"};
		int plays[] = {500, 600, 150, 800, 2500};
		
		System.out.println(Arrays.toString(s.solution(genres, plays)));
	} // End of main
} // End of class