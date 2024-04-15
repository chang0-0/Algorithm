package BOJ_1697;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1697_BFS {

    // https://www.acmicpc.net/problem/1697
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static int[] memo;
    private static final int[] moves = {1, -1, 2};
    private static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1697\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        if (N >= K) {
            sb.append(N - K);
        } else {
            memo = new int[MAX + 1];
            Arrays.fill(memo, -1);

            sb.append(BFS());
        }

        return sb.toString();
    } // End of solve()

    private static int BFS() {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.offer(N);
        memo[N] = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 0; i < 3; i++) {
                int next = cur;

                if (i == 0) next += moves[i];
                else if (i == 1) next += moves[i];
                else next *= moves[i];

                if (next >= 0 && next <= MAX && memo[next] == -1) {
                    memo[next] = memo[cur] + 1;
                    if (next == K) {
                        return memo[next];
                    }
                    que.offer(next);
                }

            }
        }

        return memo[K];
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

    } // End of input()
} // End of Main class
