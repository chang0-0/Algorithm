import java.util.*;
import java.io.*;

public class Main_1152_단어의개수 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1152.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String string = br.readLine().trim();
		
		StringTokenizer st = new StringTokenizer(string);
		int count = st.countTokens();
		System.out.println(count);
	}
}
