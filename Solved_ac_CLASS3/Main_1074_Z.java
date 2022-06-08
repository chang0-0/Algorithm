import java.util.*;
import java.io.*;

public class Main_1074_Z {
	static int size = 1;
	static int N, r, c;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1074.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		size = (int) Math.pow(2, N);
		
		int count = 0;
		int x = 0;
		int y = 0;
		
		// 시작함과 동시에
		// 전체를 4등분으로 계속 나눠서 위치를 파악
		// 작은 정사각형을 계속 만든다고 생각.
		
		while(size > 0) {
			size /= 2;
			
			// row와 column 둘 다 size보다 작다.
			if(r < x+size && c < y+size) {
				count += 0;
			}
			// row만 size보다 작을 경우
			else if(r < x+size) {
				count += size * size;
				y += size;
			}
			// column만 size보다 작을 경우 
            else if (c < y+size) {
                count += size * size * 2;
                x += size;
            }
			// row column이 둘다 size보다 클 경우 (4분면)
            else {
                count += size * size * 3;
                x += size;
                y += size;
            }
			
			
			 if(size == 1) {
	                System.out.println(count);
	                break;
	            }
			 
		}

		
	} // End of Main
} // End of Class
