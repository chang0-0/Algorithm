import java.util.*;

// 문제가 있는 라운드가 몇 개인지 return 하도록 solution 함수를 작성해주세요.

// 한 라운드에서 두 플레이어가 받은 카드 10장 중에서 중복되는 번호가 있는 경우
// 한 플레이어가 직전 라운드에서 받은 카드 5장과 이번 라운드에서 받은 카드 5장을 비교했을 때, 중복되는 번호가 2개 이상 있는 경우

public class Test1 {

	public static void main(String[] args) {
		int cards1[][] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
		int cards2[][] = {{5, 7, 9, 11, 13}, {11, 13, 15, 17, 19}};
		
		Test1 s = new Test1();
		
		System.out.println(s.solution(cards1, cards2));
	} // End of main
	
    public int solution(int[][] cards1, int[][] cards2) {
    	int N = cards1.length;
    	int count = 0;
    	boolean number[] = new boolean[53];
    	
    	// 규칙 1.
		for(int i=0; i<N; i++) {
			

			for(int j=0; j<5; j++) {
				
				int card1 = cards1[i][j];
				int card2 = cards2[i][j];

				if( !number[card1] ) {
					 number[card1] = true;
					 count++;
				}
				else {
					number[card1] = true;
				}
				
				if( !number[card2] ) {
					 number[card2] = true;
					 count++;
				}
				else {
					number[card2] = true;
				}
				
			}
		}
		
		System.out.println(count);
    	

        int answer = 0;
        return answer;
    } // End of solution

} // End of Main class