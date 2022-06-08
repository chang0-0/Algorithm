
//출처: https://hashcode.tistory.com/entry/저지-테스트케이스-등록하기 [hashcode]

// https://programmers.co.kr/learn/courses/30/lessons/43162?language=java

// 목표 : 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 
// 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
// 네트워크가 서로 연결된 노드들은 하나로 계산

public class Main_PM_네트워크_DFS {
	static boolean visit[];
	
	public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        
        for(int i=0; i<n; i++) {
        		if(visit[i] == false) {
        			answer++;
        			DFS(i, computers, n);
        		}
        }
      
        return answer;
    }
	
	static void DFS(int i, int computers[][], int n) {
		visit[i] = true;	
		
		for(int j=0; j<n; j++) {
			if(visit[j] == false && computers[i][j] == 1) {
				DFS(j, computers, n);
			}
		}

	}
	
	public static void main(String[] args) {
		Main_PM_네트워크_DFS s = new Main_PM_네트워크_DFS();
		
		int computers[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int n = 3;
		
		System.out.println(s.solution(n, computers));
	}
}
