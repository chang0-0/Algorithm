import java.util.*;

// 경로가 여러개 일 경우, 알파벳 순서가 앞서는 경로를 return
public class Main_PM_여행경로 {
	static String tickets[][];
	static List<String> list = new ArrayList<>();
	static boolean visit[]; 
	static int len;
	
	public static void main(String[] args) {
		Main_PM_여행경로 s = new Main_PM_여행경로();
		
		String tickets[][] = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		System.out.println(Arrays.toString(s.solution(tickets)));
	} // End of main
	
    public String[] solution(String[][] tickets) {
    	this.tickets = tickets;
    	len = tickets.length;
    	visit = new boolean[len];
    	
    	DFS(tickets[0][0], tickets[0][1], 0);
    	    	
    	String[] answer = new String[list.size()];
    	for(int i=0; i<list.size(); i++) {
    		answer[i] = list.get(i);
    	}
    	
        return answer;
    } // End of solution
	
	private static void DFS(String boarding, String destination, int count) {
		
		if(count == len) {
			list.add(destination);
			return;
		}
		
		for(int i=0; i<len; i++) {
			
			if( boarding.equals(tickets[i][0]) && !visit[i] ) {
				visit[i] = true;
				
				DFS(tickets[i][1], tickets[i][1] , count + 1);
				visit[i] = false; // 백트래킹
			}
		}
			
	} // End of DFS
	
} // End of main