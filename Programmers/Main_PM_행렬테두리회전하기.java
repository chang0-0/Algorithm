import java.util.*;

public class Main_PM_행렬테두리회전하기 {
	static int map[][];
	static int temp[][];
	static int rows, columns;
	static int min;
	
	public static void main(String[] args) {
		Main_PM_행렬테두리회전하기 s = new Main_PM_행렬테두리회전하기();
		
		int rows = 6;
		int columns = 6;
		int queries[][] = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};

		System.out.println( Arrays.toString(s.solution(rows, columns, queries)) );
	} // End of main
	
	// x1행 y1열 x2행 y2열까지의 영역에 해당하는 직사각형에서 테두리에 있는 숫자들을 한 칸씩 시계방향으로 회전
	// 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return
    public int[] solution(int rows, int columns, int[][] queries) {
    	this.rows = rows;
    	this.columns = columns;
    	map = new int[rows][columns];
    	temp = new int[rows][columns];
    	int len = queries.length;
    	List<Integer> list = new ArrayList<>();
    	    	
    	int count = 1;
    	for(int i=0; i<rows; i++) {
    		for(int j=0; j<columns; j++) {
    			map[i][j] = count;
    			count ++;
    		}
    	}
    	
    	for(int i=0; i<len; i++) {
    		int x1 = queries[i][0];
    		int y1 = queries[i][1];
    		int x2 = queries[i][2];
    		int y2 = queries[i][3];

    		rotation(x1-1, y1-1, x2-1, y2-1);
    		list.add(min);
    	}
    	
    	int size = list.size();
        int[] answer = new int[size];
        for(int i=0; i<size; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    } // End of solution
    
    // map배열 temp로 카피하는 메소드
    static void copy() {
    	for(int i=0; i<rows; i++) {
    		for(int j=0; j<columns; j++) {
    			temp[i][j] = map[i][j];
    		}
    	}
    } // End of copy
    
    static void rotation(int x1, int y1, int x2, int y2) {
    	min = Integer.MAX_VALUE / 16;
    	copy();
    	
    	// 2 2 5 4 -> 1 1 4 3
    	// (1,1) -> (4,3) 회전
    	// 8부터 28까지를 회전 (중앙 빼고 테두리만)
    	
    	// 상단 회전 
    	// temp1,1 -> map1,2  
    	// temp1,2 -> map1,3
    	for(int i=y1; i<y2; i++) {
    		min = Math.min(temp[x1][i], min);
    		map[x1][i+1] = temp[x1][i];
    	}
    	
    	// 우측 회전
    	// temp 1,3 -> map 2,3
    	// temp 2,3 -> map 3,3
    	// temp 3,3 -> map 4,3
    	for(int i=x1; i<x2; i++) {
    		min = Math.min(temp[i][y2], min);
    		map[i+1][y2] = temp[i][y2];
    	}
    	
    	// 하단 회전
    	// temp 4,3 -> map 4,2
    	// temp 4,2 -> map 4,1
    	for(int i=y2; i>y1; i--) {
    		min = Math.min(temp[x2][i], min);
    		map[x2][i-1] = temp[x2][i];
    	}
    	
    	// 좌측 회전
    	// temp 2,1 -> map 1,1
    	// temp 3,1 -> map 2,1
    	// temp 4,1 -> map 3,1
    	for(int i=x2; i>x1; i--) {
    		min = Math.min(temp[i][y1], min);
    		map[i-1][y1] = temp[i][y1];
    	}
    	
    } // End of rotaion
    
} // End of Main class