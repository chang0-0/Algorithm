import java.util.*;

public class Programmer_카카오채용연계형인턴십_숫자문자열과영단어2 {

	public static void main(String[] args) { 
		Programmer_카카오채용연계형인턴십_숫자문자열과영단어2 s = new Programmer_카카오채용연계형인턴십_숫자문자열과영단어2();
		String str = "2threetwo45sixseventwo"	;
		
		System.out.println(s.solution(str));		
	} // End of main
	
	public int solution(String s) {
		 	String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
				 	
		 	// replaceAll(찾는 값, 바꾸려는 값)
		 	// 문자열s에서 number[i]와 똑같은 문자열이 있으면, 전체를 해당하는 인덱스값으로 바꿈
		 	for(int i=0; i<number.length; i++) {
		 		s = s.replaceAll(number[i], Integer.toString(i));
		 	}
		 	
		 	return Integer.parseInt(s);
	} // End of solution
    

} // End of class