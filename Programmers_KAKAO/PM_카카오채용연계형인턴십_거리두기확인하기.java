import java.util.*;

public class PM_카카오채용연계형인턴십_거리두기확인하기 {
	static char rooms[][];
	static boolean visit[][];
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {-1, 1, 0, 0};
	
	static int nowX, nowY, nowCount;
	
	static class Node {
		int x;
		int y;
		int count;
		
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	} // End of Node class
	
	public static void main(String[] args) {
		PM_카카오채용연계형인턴십_거리두기확인하기 s = new PM_카카오채용연계형인턴십_거리두기확인하기();
		
		String places[][] = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		
		System.out.println( Arrays.toString(s.solution(places)) );
		
	} // End of main
	
    public int[] solution(String[][] places) {
    	// 결과를 담을 배열
    	int[] result = new int[places.length];
    	
    	for(int i=0; i<places.length; i++) {
    		String[] place = places[i];
    		rooms = new char[5][5];
    		visit = new boolean[5][5];
    		
    		for(int j=0; j<5; j++) {
    			String temp = place[j];
    			
    			for(int k=0; k<5; k++) {
    				rooms[j][k] = temp.charAt(k);
    			}
    		}
    		
    		// BFS 탐색 시작
    		boolean check = true;
    		
    		for(int k=0; k<5; k++) {
    			for(int l=0; l<5; l++) {
    				
    				if(check == true && rooms[k][l] == 'P' && visit[k][l] == false) {
    					check = BFS(k, l);  				
    				}

    				if( check == false ) {
    					result[i] = 0;
    					break;
    				}
    			}
    		}
    		
    		if(check) {
    			result[i] = 1;
    		}

    	}
    	 	
    	return result;
    } // End of solution
    
    static boolean BFS(int x, int y) {
    	int count = 0;
    	Queue<Node> que = new LinkedList<>();
    	que.offer(new Node(x, y, count));
    	visit[x][y] = true;
    	
    	while( !que.isEmpty() ) {
    		Node node = que.poll();
    		
    		for(int i=0; i<4; i++) {
    			nowX = dirX[i] + node.x;
    			nowY = dirY[i] + node.y;
    			nowCount = node.count;
    			
    			// zero_count가 2 미만 인데 P를 만나면 곧바돌 false를 return
    			if(range_check() && nowCount < 2 && rooms[nowX][nowY] == 'P' && visit[nowX][nowY] == false) {
    				que.clear();
    				return false;
    			}
    			
    			// nowCount가 2를 넘어섰는데, P를 만난 경우 : 그냥 true처리를 해주고 que에 넣지는 않음
    			if(range_check() && nowCount > 2 && rooms[nowX][nowY] == 'P' && visit[nowX][nowY] == false) {
    				visit[nowX][nowY] = true;
    			}
    			
    			if(range_check() && nowCount < 2 && rooms[nowX][nowY] == 'O' && visit[nowX][nowY] == false) {
    				que.offer(new Node(nowX, nowY, nowCount + 1));
    				visit[nowX][nowY] = true;
    			}
    			

    			// X를 만날경우, 그냥 true처리
    			if(range_check() && nowCount < 2 && rooms[nowX][nowY] == 'X' && visit[nowX][nowY] == false) {
    				visit[nowX][nowY] = true;
    			}

    		}
    	}
    	
    	// 전체를 다 돌았는데도 아니면, true를 반환.
    	return true;
    } // End of BFS
    
    static boolean range_check() {
    	return (nowX >= 0 && nowX < 5 && nowY >= 0 && nowY < 5);
    } // End of range_check
	
} // End of Main class