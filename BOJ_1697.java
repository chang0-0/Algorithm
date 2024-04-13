package BOJ_1697;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1697 {

    // https://www.acmicpc.net/problem/1697
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;

    private static class Jump {
        int num;
        int count;

        public Jump(int num, int count) {
            this.num = num;
            this.count = count;
        }
    } // End of Jump class

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

        sb.append(BFS());
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        ArrayDeque<Jump> que = new ArrayDeque<>();
        int[] memo = new int[K * 2];
        Arrays.fill(memo, -1);

        que.offer(new Jump(N, 0));
        // + 1, - 1, * 2로 이동 가능

        while (!que.isEmpty()) {
            Jump cur = que.poll();

            if (memo[cur.num] != -1) continue;
            memo[cur.num] = cur.count;
            if (cur.num == K) {
                return cur.count;
            }

            if(cur.num * 2 <= K * 2) {
                que.offer(new Jump(cur.num * 2, cur.count + 1));
            }

            que.offer(new Jump(cur.num + 1, cur.count + 1));
            que.offer(new Jump(cur.num - 1, cur.count + 1));
        }

        return 0;
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    } // End of input()
} // End of Main class
