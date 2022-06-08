import java.util.*;
import java.io.*;

public class Main_9019_DSLR {
	
	static class Register {
        int num;
        String command;

        Register(int num, String command) {
            this.num = num;
            this.command = command;
        }
		
        int D() {
            return (num * 2) % 10000;
        }

        int S() {
            return num == 0 ? 9999 : num - 1;
        }

        int L() {
            return num % 1000 * 10 + num / 1000;
        }

        int R() {
            return num % 10 * 1000 + num / 10;
        }
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_9019.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Register> que = new LinkedList<>();
		
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			boolean[] visit = new boolean[10000];
			visit[start] = true;
			
			que.clear();
			que.offer(new Register(start, ""));
			
			while( !que.isEmpty() ) {
				Register reg = que.poll();
				System.out.println("que : (" + reg.num + ", " + reg.command + ")" );
				
				if(reg.num == target) {
					System.out.println(reg.command);
					break;
				}
				
				if(visit[reg.D()] == false) {
					que.offer(new Register(reg.D(), reg.command + "D"));
					visit[reg.D()] = true;
				}
				
				if(visit[reg.S()] == false) {
					que.offer(new Register(reg.S(), reg.command + "S"));
					visit[reg.S()] = true;
				}
				
				if(visit[reg.L()] == false) {
					que.offer(new Register(reg.L(), reg.command + "L"));
					visit[reg.L()] = true;
				}
				
				if(visit[reg.R()] == false) {
					que.offer(new Register(reg.R(), reg.command + "R"));
					visit[reg.R()] = true;
				}

			}
			
		}
	} // End of main
	

} // End of class