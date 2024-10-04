package BOJ_13549;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13549 {

    // https://www.acmicpc.net/problem/13549
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static int[] memo;
    private static final int MAX = 100_001;

    private static class Location implements Comparable<Location> {
        int num;
        int time;

        private Location(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Location o) {
            return time - o.time;
        }

        @Override
        public String toString() {
            return "Location{" + num + ", " + time + "}\n";
        }
    } // End of Location

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_13549\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(BFS());
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        PriorityQueue<Location> que = new PriorityQueue<>();
        que.offer(new Location(N, 0));
        memo[N] = 0;

        while (!que.isEmpty()) {
            Location cur = que.poll();

            if (cur.num == K) return cur.time;

            if (cur.num * 2 <= MAX - 1 && memo[cur.num * 2] > memo[cur.num]) {
                memo[cur.num * 2] = memo[cur.num];
                que.offer(new Location(cur.num * 2, memo[cur.num * 2]));
            }

            if (cur.num - 1 >= 0 && memo[cur.num - 1] > memo[cur.num] + 1) {
                memo[cur.num - 1] = memo[cur.num] + 1;
                que.offer(new Location(cur.num - 1, memo[cur.num - 1]));
            }

            if (cur.num + 1 <= MAX - 1 && memo[cur.num + 1] > memo[cur.num] + 1) {
                memo[cur.num + 1] = memo[cur.num] + 1;
                que.offer(new Location(cur.num + 1, memo[cur.num + 1]));
            }
        }

        return 0;
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        memo = new int[MAX];
        Arrays.fill(memo, Integer.MAX_VALUE);
    } // End of input()
} // End of Main class
