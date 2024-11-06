package BOJ_13913;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13913 {

    // https://www.acmicpc.net/problem/13913
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static final int MAX = 100_001;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_13913\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        if (N >= K) {
            int count = 0;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(N).append(' ');
            for (int i = N - 1; i >= K; i--) {
                count++;
                sb2.append(i).append(' ');
            }

            sb.append(count).append('\n');
            sb.append(sb2);
            return sb.toString();
        }

        int[] ret = BFS();
        sb.append(ret.length - 1).append('\n');
        for (int num : ret) {
            sb.append(num).append(' ');
        }

        return sb.toString();
    } // End of solve()

    private static int[] BFS() {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int[] memo = new int[MAX + 1];
        Arrays.fill(memo, -1);
        que.offer(N);
        memo[N] = 0;

        int ans = 0;
        int depth = 0;

        while (!que.isEmpty()) {

            int size = que.size();
            for (int i = 0; i < size; i++) {
                int cur = que.poll();

                if (cur == K) {
                    ans = depth;
                }

                if (cur + 1 < MAX && memo[cur + 1] == -1) {
                    que.offer(cur + 1);
                    memo[cur + 1] = cur;
                }

                if (cur - 1 >= 0 && memo[cur - 1] == -1) {
                    que.offer(cur - 1);
                    memo[cur - 1] = cur;
                }

                if (cur * 2 < MAX && memo[cur * 2] == -1) {
                    que.offer(cur * 2);
                    memo[cur * 2] = cur;
                }
            }

            depth++;
        }


        int[] route = new int[ans + 1];
        int val = K;
        for (int i = ans; i >= 0; i--) {
            route[i] = val;
            val = memo[val];
        }

        return route;
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    } // End of input()
} // End of Main class
