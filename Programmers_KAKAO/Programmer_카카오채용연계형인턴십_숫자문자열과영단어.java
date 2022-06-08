import java.util.*;

public class Programmer_카카오채용연계형인턴십_숫자문자열과영단어 {
	static StringBuilder sb = new StringBuilder();
	static List<Character> list = new ArrayList<>();
	static String num[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	
	public static void main(String[] args) { 
		Programmer_카카오채용연계형인턴십_숫자문자열과영단어 s = new Programmer_카카오채용연계형인턴십_숫자문자열과영단어();
		String str = "2three45sixseven"	;
		
		System.out.println(s.solution(str));		
	} // End of main
	
	   public int solution(String s) {
	    	StringBuilder number = new StringBuilder();
	    	int len = s.length();
	    	
	    	for(int i=0; i<len; i++) {
	    		char ch = s.charAt(i);

	    		// 문자가 숫자일 경우 그대로 StringBuilder에 연결
	    		if(ch >= 48 && ch <= 57) {
	    			sb.append(ch);
	    		}
	    		// 문자가 숫자가 아니라 알파벳일 경우  
	    		else {
	    			number.append(ch);
	    		}
	    		
	    		// 숫자를 의미하는 문자의 최소길이는 3이고 최대길이는 5이다.
	    		// 그러므로 숫자의 문자길이가 3이상일 경우, 검사를 함.
	    		// 검사결과가 false일 경우, 다시 문자열에 요소를 하나 넣고 또 검사를 하면서 
	    		// 반복해서 계속 문자열이 숫자영어와 일치하는지 검사를 함
	    		if(number.length() >= 3) {
	    			String str = number.toString();
	    			if(check(str)) {
	    				find(str);
	    				number = new StringBuilder();
	    			}
	    			else {
	    				continue;
	    			}
	    			
	    		}
	    		
	    	}
	    	
	    	int result = Integer.parseInt(sb.toString());
	        return result;
	    } // End of solution
    
    static boolean check(String str) {
    	
    	for(int i=0; i<10; i++) {
    		String number = num[i];
    		
    		if(str.contains(number)) {
    			return true;
    		}
    		
    	}
    	
    	return false;
    }
    
    static void find(String str) {
    	
    	switch(str) {
    		case "zero": sb.append("0");
    		break;
    		case "one": sb.append("1");
    		break;
    		case "two": sb.append("2");
    		break;
    		case "three": sb.append("3");
    		break;
    		case "four": sb.append("4");
    		break;
    		case "five": sb.append("5");
    		break;
    		case "six": sb.append("6");
    		break;
    		case "seven": sb.append("7");
    		break;
    		case "eight": sb.append("8");
    		break;
    		case "nine": sb.append("9");
    		break;
    	}
    
    } // End of find;
	
} // End of class