package BOJ_2594;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2594 {

    // https://www.acmicpc.net/problem/2594
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static Time[] times;

    private static class Time {
        int start;
        int end;

        private Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Time{start=" + start + ", end=" + end + '}';
        }
    } // End of Time class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2594\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        Arrays.sort(times, Comparator.comparing(o -> o.start));
        Time current = times[0];
        ans = current.start - 600;

        for (int i = 1; i < N; i++) {
            Time next = times[i];

            if (current.end < next.start) {
                ans = Math.max(ans, Math.abs(current.end - next.start));
            }

            current.end = Math.max(current.end, next.end);
        }

        ans = Math.max(ans, 1320 - current.end);
        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        times = new Time[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = 0;
            int end = 0;

            for (int j = 0; j < 2; j++) {
                String time = st.nextToken();
                int time1 = Integer.parseInt(time.substring(0, 2)) * 60;
                int time2 = Integer.parseInt(time.substring(2, 4));

                if (j == 0) {
                    start = time1 + time2 - 10;
                } else {
                    end = time1 + time2 + 10;
                }
            }
            times[i] = new Time(start, end);
        }
    } // End of input()
} // End of Main class
