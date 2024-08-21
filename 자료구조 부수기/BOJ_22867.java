package BOJ_22867;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_22867 {

    // https://www.acmicpc.net/problem/22867
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static Time[] times;

    private static class Time implements Comparable<Time> {
        long start;
        long end;

        private Time(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if (start == o.start) {
                return Long.compare(end, o.end);
            }
            return Long.compare(start, o.start);
        }

        @Override
        public String toString() {
            return "Time{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    } // End of Time class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_22867\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(times);
        int ans = 0;
        PriorityQueue<Long> pque = new PriorityQueue<>();
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

    private static long convertTime(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        long h = Long.parseLong(st.nextToken()) * 3600 * 1000;
        long m = Long.parseLong(st.nextToken()) * 60 * 1000;

        String second = st.nextToken();
        StringTokenizer secondSt = new StringTokenizer(second, ".");
        long s = Long.parseLong(secondSt.nextToken()) * 1000;
        long sss = Long.parseLong(secondSt.nextToken());

        return h + m + s + sss;
    } // End of convertTime()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        times = new Time[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();

            long startTime = convertTime(start);
            long endTime = convertTime(end);

            times[i] = new Time(startTime, endTime);
        }
    } // End of input()
} // End of Main class
