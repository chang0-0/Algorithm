import java.io.*;
import java.util.*;

public class Main {

    // https://softeer.ai/practice/6291
    // input
    private static BufferedReader br;
    
    // variables
    private static int N;
    private static PriorityQueue<Time> pque;

    private static class Time implements Comparable<Time> {
        int start;
        int end;

        private Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(end == o.end) {
                return start - o.start;
            }

            return end - o.end;
        }
    } // End of Time class
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();
        
        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        Time now = pque.poll();
        int ans = 1;

        // 끝나는 시간 -> 시작 시간 기준 정렬
        while(!pque.isEmpty()) {
            Time cur = pque.peek();

            if(cur.start < now.end) {
                pque.poll();
            } else {
                pque.poll();
                now.end = cur.end;
                ans++;
            }
        }
        
        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        pque = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pque.offer(new Time(start, end));
        }
    } // End of input()
} // End of Main class
