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

    private static class Di implements Comparable<Di> {
        int idx;
        int count;

        private Di(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }

        @Override
        public int compareTo(Di o) {
            if (o.idx == idx) {
                return count - o.count;
            }
            return o.idx - idx;
        }
    } // End of Di class

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

        sb.append(ret == Integer.MAX_VALUE ? -1 : ret);
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        PriorityQueue<Di> que = new PriorityQueue<>();
        int[] memo = new int[N + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);

        que.offer(new Di(0, 0));
        memo[0] = 0;

        while (!que.isEmpty()) {
            Di cur = que.poll();

            if (cur.idx == N) {
                continue;
            }

            for (int i = cur.idx; i <= arr[cur.idx] + cur.idx; i++) {
                if (i > N) break;
                if (memo[i] > memo[cur.idx] + 1) {
                    memo[i] = memo[cur.idx] + 1;
                    que.offer(new Di(i, memo[i]));
                }
            }
        }

        return memo[N - 1];
    } // End of BFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
