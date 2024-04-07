package BOJ_25418;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_25418 {

    // https://www.acmicpc.net/problem/25418
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int A, K;

    private static class Number {
        int num;
        int count;

        private Number(int num, int count) {
            this.num = num;
            this.count = count;
        }
    } // End of Number class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_25418\\res.txt"));
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
        LinkedList<Number> que = new LinkedList<>();
        int[] memo = new int[(K * 2) + 1];
        Arrays.fill(memo, INF);

        que.offer(new Number(A, 0));
        memo[A] = 0;

        while (!que.isEmpty()) {
            Number current = que.poll();

            if (current.num >= K) {
                if (current.num == K) {
                    memo[K] = Math.min(memo[K], current.count);
                }
                continue;
            }

            if (memo[current.num + 1] > memo[current.num] + 1) {
                memo[current.num + 1] = memo[current.num] + 1;
                que.offer(new Number(current.num + 1, memo[current.num + 1]));
            }

            if (memo[current.num * 2] > memo[current.num] + 1) {
                memo[current.num * 2] = memo[current.num] + 1;
                que.offer(new Number(current.num * 2, memo[current.num * 2]));
            }
        }

        return memo[K];
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

    } // End of input()
} // End of Main class
