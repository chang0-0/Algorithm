import java.io.*;

public class Main_1018_체스판다시칠하기 {
	// 비교할 체스판 생성
	final static String wStart[][] = {{"W","B","W","B","W","B","W","B"},
									  {"B","W","B","W","B","W","B","W"},
									  {"W","B","W","B","W","B","W","B"},
									  {"B","W","B","W","B","W","B","W"},
									  {"W","B","W","B","W","B","W","B"},
								      {"B","W","B","W","B","W","B","W"},
									  {"W","B","W","B","W","B","W","B"},
									  {"B","W","B","W","B","W","B","W"}};
	
	final static String bStart[][] = {{"B","W","B","W","B","W","B","W"},
								      {"W","B","W","B","W","B","W","B"},
								      {"B","W","B","W","B","W","B","W"},
								      {"W","B","W","B","W","B","W","B"},
								      {"B","W","B","W","B","W","B","W"},
								      {"W","B","W","B","W","B","W","B"},
								      {"B","W","B","W","B","W","B","W"},
								      {"W","B","W","B","W","B","W","B"}};
	
	// 최솟값을 계산하는 메소드
	public static int find(String[][] temp) {
		int count1 = 0;
		int count2 = 0;
		int result = 0;
		int i=0;
		int j=0;
		
		char first = temp[0][0].charAt(0);

			while(i<8) {
				j = 0;
				while(j<8) {
					if(temp[i][j].charAt(0) != bStart[i][j].charAt(0)) {
						count1 ++;
					}
					
					if(temp[i][j].charAt(0) != wStart[i][j].charAt(0)) {
						count2 ++;
					}
					
					j++;
				}
				i++;
			}

		result = Math.min(count1, count2);
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1018.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int min = Integer.MAX_VALUE / 16;
		int num = 0;
		
		String arr[] = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
	
		String chess[][] = new String[N][M];
		
		// 입력받은 체스판 생성
		for(int i=0; i<chess.length; i++) {
			String arr2[] = br.readLine().split("");
			for(int j=0; j<arr2.length; j++) {
				chess[i][j] = arr2[j];
			}
		}
		
		// 1. 세로를 기준으로 옆으로 밀어내면서 체스판을 생성하고
		// 2. 세로를 기준으로 더이상 밀어낼 공간이 없다면 밑으로 한칸 내려가서 위 과정을 다시 반복
		for(int x=0; x<=N-8; x++) {
			String temp[][] = new String[8][8];

			for(int y=0; y<=M-8; y++) {
				int g = 0;
				
				for(int i=x; i<=x+7; i++) {
					int s = 0;
					
					for(int j=y; j<=y+7; j++) {
						temp[g][s] = chess[i][j];
						
						if(g == 7 && s == 7) {
							num = find(temp);

							
							// 만약 새로운 값 num이 지금까지의 최솟값 min보다 작다면
							// 또는 지금까지의 최솟값 min 보다 새로운 값 num이 크다면 
							// min최솟값을 num값으로 갱신한다.
							// 이렇게 해서 지속적으로 가장 작은 최솟값을 찾아낸다.
							min = Math.min(num, min);
						}
						
						s++;
					}
					g++;
				}
			}
		}

		System.out.println(min);

	}
}