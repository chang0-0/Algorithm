import java.util.*;

// 문제 : https://programmers.co.kr/learn/courses/30/lessons/81303?language=java
// 생각해야 할 부분. 마지막위치에서 행이 삭제될 경우, 윗 행렬로 올라옴.

public class PM_카카오채용연계형인턴십_표편집 {
	
	public static void main(String[] args) {
		PM_카카오채용연계형인턴십_표편집 s = new PM_카카오채용연계형인턴십_표편집();
		int n = 8;
		int k = 2;
		String cmd[] = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		
		System.out.println(s.solution(n, k, cmd));
	} // End of main

    public String solution(int n, int k, String[] cmd) {
    	StringTokenizer st = null;
    	StringBuilder sb = null;
    	
    	Stack<Integer> backupList = new Stack<Integer>(); // 삭제한 대상을 가지고 있을 backupList
    	int rowMax_num = n; // 전체 행번호 (행의 최대값)
    	int cmd_len = cmd.length;
    	
    	for(int i=0; i<cmd_len; i++) {
    		st = new StringTokenizer(cmd[i]);
    		String order = st.nextToken();
    		
    		if(order.equals("D") || order.equals("U")) {
    			int X = Integer.parseInt(st.nextToken());
    			
    			if(order.equals("D")) {
    				k+= X;
    			}
    			else if(order.equals("U")) {
    				k-= X;
    			}
    		}
    		else if(order.equals("C")) {
    			backupList.push(k); // 삭제되면 현재행의 번호를 backupList에 넣음.
    			rowMax_num--; // 전체행의 수를 하나 줄임

    			//전체행의 수와 현재행의 번호가 같을 경우, 마지막 행이 삭제가 된것이므로,
    			// 하나위의 행을 선택하기 위해 k값을 1줄임
    			if(k == rowMax_num) {
    				k--;
    			}
    		}
    		else if(order.equals("Z")) {
    			// 되돌리기가 마지막 행이 었을경우, 마지막행을 다시 선택해야 함.
    			// 행 번호를 기준으로 현재 선택한 행 번호를 찾아야 하기 때문에
    			
    			// 현재 행의 위치가 백업리스트에서 가져온 값보다 크면
    			// 예를 들어 현재 선택된 행이 4인데, 4행이 백업되면, 현재 선택된 행은 5가 되어야 하므로
    			// 현재 선택된 행을 올려준다.
    			if(backupList.pop() <= k) {
    				k++;
    			}
    			
    			// 행이 백업되어서 늘어났으므로 최대 행 번호도 올려준다.
    			rowMax_num++;
    		}
    	}

    	sb = new StringBuilder();
    	
    	// 먼저 최대 행 사이즈에 있는 값부터 출력.
    	// 최대 행번호의 의미는 삭제되지 않은 행들이기 때문에 전체 O로 해서 출력하면 된다.
    	for(int i=0; i<rowMax_num; i++) {
    		sb.append('O');
    	}
    	
    	// 마지막남은 제거된 행들은 backList에서 가져와서 
    	// 꺼낸 값의 위치에 StringBuilder에 'X'를 append 해준다.
    	while( !backupList.isEmpty() ) {
    		sb.insert( backupList.pop().intValue() , 'X');
    	}

        return sb.toString();
    } // End of solution
	
} // End of Main class