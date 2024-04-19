package BOJ_16568;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16568 {

    // https://www.acmicpc.net/problem/16568
    // input
    private static BufferedReader br;

    // variables
    private static int N, A, B;
    private static final int INF = Integer.MAX_VALUE / 16;
    private static int[] moves;

    private static class Magic {
        int idx;
        int sec;

        private Magic(int idx, int sec) {
            this.idx = idx;
            this.sec = sec;
        }

        @Override
        public String toString() {
            return "Magic{" +
                    "idx=" + idx +
                    ", sec=" + sec +
                    '}';
        }
    } // End of Magic

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_16568\\res.txt"));
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
        ArrayDeque<Magic> que = new ArrayDeque<>();
        int[] memo = new int[N + 1];
        Arrays.fill(memo, INF);

        que.offer(new Magic(0, 0));
        memo[0] = 0;
        // memo[줄 위치] = 최소시간

        while (!que.isEmpty()) {
            Magic cur = que.poll();

            if (cur.idx == N) {
                return memo[cur.idx];
            }

            for (int i = 0; i < 3; i++) {
                int next = cur.idx + moves[i];

                if (next > N || memo[next] != INF) continue;

                memo[next] = cur.sec + 1;
                que.offer(new Magic(next, memo[next]));
            }
        }

        return memo[N];
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken()) + 1;
        B = Integer.parseInt(st.nextToken()) + 1;

        moves = new int[3];
        moves[0] = A;
        moves[1] = B;
        moves[2] = 1;
    } // End of input()
} // End of Main class
