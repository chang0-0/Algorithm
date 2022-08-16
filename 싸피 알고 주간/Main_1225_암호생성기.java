import java.util.*;
import java.io.*;

public class Main_1225_암호생성기 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1225.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while ((str = br.readLine()) != null) {
            sb.append('#').append(Integer.parseInt(str)).append(' ');

            Queue<Integer> que = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                que.offer(Integer.parseInt(st.nextToken()));
            }

            int cycle = 1;
            for (; ; ) {
                int pollNum = que.poll();
                int newNum = pollNum - cycle;
                if(newNum <= 0) {
                    que.offer(0);
                    break;
                }

                que.offer(newNum);
                if(cycle == 5) {
                    cycle = 1;
                } else {
                    cycle++;
                }
            }

            for(int num : que) {
                sb.append(num).append(' ');
            }

            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main
} // End of Main class