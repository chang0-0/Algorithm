package BOJ_19621;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_19621_회의실_배정_2 {

    // https://www.acmicpc.net/problem/19621
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] memo;
    private static Meeting[] meetings;

    private static class Meeting {
        int startTime;
        int endTime;
        int people;

        private Meeting(int startTime, int endTime, int people) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.people = people;
        }

        @Override
        public String toString() {
            return "Meeting{startTime : " + startTime + ", endTime : " + endTime + ", people : " + people + "}";
        }
    } // End of Meeting class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_19621\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(topDown(N));
        System.out.println(Arrays.toString(memo));

        return sb.toString();
    } // End of solve()

    private static int topDown(int n) {
        if (n <= 0) return 0;

        if (memo[n] != -1) return memo[n];

        int ans = topDown(n - 1);
        System.out.println("ans : " + ans + " = topDown(" + (n - 1) + ")");
        ans = Math.max(ans, topDown(n - 2) + meetings[n].people);

        return memo[n] = ans;
    } // End of topDown()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        memo = new int[N + 1];
        Arrays.fill(memo, -1);
        meetings = new Meeting[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

    } // End of input()
} // End of Main class
