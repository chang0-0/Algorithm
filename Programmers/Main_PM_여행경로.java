import java.util.*;

public class Main_PM_여행경로 {
	static StringBuilder sb = new StringBuilder();
	static String tickets[][];
	static boolean visit[];
	static List<String> list = new ArrayList<>();
	static int len;
	
	public static void main(String[] args) {
		Main_PM_여행경로 s = new Main_PM_여행경로();
		
		String tickets[][] = {{ "ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND" }};
		System.out.println(Arrays.toString(s.solution(tickets)));	
	} // End of main
	
    public String[] solution(String[][] tickets) {
    	this.tickets = tickets;
    	len = tickets.length;
    	visit = new boolean[len];
    	
    	// tickets 정렬 (람다식 정렬)
    	Arrays.sort(tickets, (o1, o2) -> {
    		if(o1[0].equals(o2[0])) {
    			return o1[1].compareTo(o2[1]);
    		}
    		else {
    			return o1[0].compareTo(o2[0]);
    		}
    	});

    	DFS("ICN", "ICN", 0);
    	// 결과 출력
    	
    	String result = list.get(0);
    	StringTokenizer st = new StringTokenizer(result);
    	String answer[] = new String[len+1];
    	for(int i=0; i<len + 1; i++) {
    		
    		answer[i] = st.nextToken();
    	}
    	
        return answer;
    } // End of solution
    
    
    // 백트래킹 -> 재귀 탈출 조건, 백트래킹 탈출 조건 2개 필요
    private static void DFS( String boarding, String route, int depth ) {
    	sb = new StringBuilder();

    	if(depth == len) {
    		list.add(route);
    		return;
    	}
    	
    	for(int i=0; i<len; i++) {
    		
    		if(visit[i]) continue;
    		
    		if( tickets[i][0].equals(boarding) ) {
    			visit[i] = true;
    			sb.append(route).append(' ').append(tickets[i][1]);
    			DFS(tickets[i][1], sb.toString() , depth + 1);
    			visit[i] = false;
    		}
    	}
    	    	
    } // End of DFS
    
} // End of Main class