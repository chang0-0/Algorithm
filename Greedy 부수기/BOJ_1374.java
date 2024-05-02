package BOJ_1374;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1374 {

    // https://www.acmicpc.net/problem/1374
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static Time[] times;

    private static class Time implements Comparable<Time> {
        int num;
        int start;
        int end;

        private Time(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if (start == o.start) {
                return end - o.end;
            }

            return start - o.start;
        }
    } // End of Time  class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1374\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(times);

        PriorityQueue<Integer> pque = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            Time cur = times[i];

            while (!pque.isEmpty() && pque.peek() <= cur.start) {
                pque.poll();
            }


            pque.offer(cur.end);
            ans = Math.max(ans, pque.size());
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        times = new Time[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = new Time(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }
    } // End of input()
} // End of Main class
