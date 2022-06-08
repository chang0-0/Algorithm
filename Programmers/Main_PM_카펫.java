import java.util.*;

// 정사각형이거나 직사각형일 경우 가로가 길다.
// 목표 : 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 
// 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

public class Main_PM_카펫 {
	static int brown_row;
	static int brown_col;
	
   public int[] solution(int brown, int yellow) {
        
        Carpet(brown, yellow);
        
        int answer[] = new int[2];
        answer[0] = brown_row;
        answer[1] = brown_col;
        
        return answer;
    } // End of solution
   
   static void Carpet(int brown, int yellow) {

	   for(int i=1; i<=yellow; i++) {
		   int yellow_row = yellow/i;
		   int yellow_col = i;
		   brown_row = 0;
		   brown_col = 0;
		   
		   // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
		   if(yellow_row >= yellow_col) {
			   // 나머지가 생길 경우, yellow_col 값은 1 증가해주고
			   if(yellow % yellow_row > 0)  {
				   yellow_col++;
			   }

			   // 정사각형을 기준으로 계산 후 brown과 yellow 합으로 비교
			   brown_row = yellow_row + 2;
			   brown_col = yellow_col + 2;

			   if((brown_row * brown_col) == (brown + yellow)) {
				   return;
			   }
		   }
		   else {
			   return;
		   }
		   
	   }
   } // End of Carpet

	public static void main(String[] args) {
		Main_PM_카펫 s = new Main_PM_카펫();
		
		int brown = 24;
		int yellow = 24;

		System.out.println(Arrays.toString(s.solution(brown, yellow)));
	}// End of main
	
} // End of class
