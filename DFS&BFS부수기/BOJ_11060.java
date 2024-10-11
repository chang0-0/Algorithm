package BOJ_11060;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11060 {

    // https://www.acmicpc.net/problem/11060
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;
    private static final int INF = Integer.MAX_VALUE / 2;

    private static class Jump implements Comparable<Jump> {
        int num;
        int count;

        private Jump(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Jump o) {
            return count - o.count;
        }


        @Override
        public String toString() {
            return "Jump{" + num + ", " + count + "}\n";
        }
    } // End of Jump()

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_11060\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ret = BFS();

        if (ret == INF) sb.append(-1);
        else sb.append(ret);
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        PriorityQueue<Jump> que = new PriorityQueue<>();
        int[] memo = new int[N + 1];
        Arrays.fill(memo, INF);
        memo[0] = 0;
        que.offer(new Jump(0, 0));

        while (!que.isEmpty()) {
            Jump cur = que.poll();

            if (cur.num == N - 1) {
                memo[cur.num] = Math.min(memo[cur.num], cur.count);
            }

            for (int i = cur.num + 1; i <= cur.num + arr[cur.num] && i < N; i++) {
                if (memo[i] > memo[cur.num] + 1) {
                    memo[i] = memo[cur.num] + 1;
                    que.offer(new Jump(i, memo[i]));
                }
            }
        }

        return memo[N - 1];
    } // End of BFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
