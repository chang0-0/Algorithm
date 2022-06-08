import java.io.*;

public class Main_1085_직사각형에서탈출 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1085.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String arr[] = br.readLine().split(" ");
		
		// x, y, w, h는 정수
		int x = Integer.parseInt(arr[0]);
		int y = Integer.parseInt(arr[1]);
		// (x, y)가 현수가 있는 위치
		
		int w = Integer.parseInt(arr[2]);
		int h = Integer.parseInt(arr[3]);
		// (w,h)의 w가 직사각형의 가로길이, h가 직사각형의 세로길이
		
		int row1 = Math.abs(w - x);
		int row2 = Math.abs(0 - x);
		
		int col1 = Math.abs(h - y);
		int col2 = Math.abs(0 - y);
		
		int rowMin = Math.min(row1, row2);
		int colMin = Math.min(col1, col2);
		
		System.out.println(Math.min(rowMin, colMin));
		br.close();
	}
}