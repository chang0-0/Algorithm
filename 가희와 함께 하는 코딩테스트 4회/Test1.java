import java.util.*;
import java.io.*;

// 유저가 체감하는 몬스터의 방어율 수치가 100보다 크거나 같으면 몬스터에게 대미지를 줄 수 없습니다.
// 몬스터의 방어율 수치를 a, 유저의 방무를 b라고 할 때, 유저가 몬스터에게 대미지를 줄 수 있는지 없는지 알려주세요.  

// 첫 번째 줄에 정수 a와 b가 공백으로 구분되어 주어집니다.
// 몬스터에게 대미지를 줄 수 있으면 1, 그렇지 않으면 0을 출력해 주세요.

public class Test1 {
	public static void main(String[] args) throws Exception  {
		System.setIn(new FileInputStream("res/test1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		
		double defense = a - (a * (b/100)); // 방어율 수치
		
		if(defense >= 100) {
			System.out.println(0);
		}
		else if(defense < 100) {
			System.out.println(1);
		}
		
	} // End of main
} // End of Main class