import java.util.*;

public class Main_kakao_순위검색 {
	public int[] solution(String[] info, String[] query) {
		StringTokenizer st = null;
		int[] answer = {};
		HashMap<String, String> hashmap = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<info.length; i++) {
			String temp = info[i];
			list.add(temp);
		}
		
		for(int i=0; i<list.size(); i++) {
			String temp = list.get(i);
		}

		return answer;
	}
	
	public static void main(String[] args) {
		Main_kakao_순위검색 s = new Main_kakao_순위검색();
		
		String info[] = {"java backend junior pizza 150",
						"python frontend senior chicken 210",
						"python frontend senior chicken 150",
						"cpp backend senior pizza 260",
						"java backend junior chicken 80",
						"python backend senior chicken 50"};
		
		String query[] = {"java and backend and junior and pizza 100",
						"python and frontend and senior and chicken 200",
						"cpp and - and senior and pizza 250",
						"- and backend and senior and - 150",
						"- and - and - and chicken 100",
						"- and - and - and - 150"};
		
		System.out.println(Arrays.toString(s.solution(info, query)));
		
	}
}
