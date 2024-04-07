package BOJ_11060;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11060_BFS {

    // https://www.acmicpc.net/problem/11060
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int N;
    private static int[] arr;

    private static class Jump {
        int start; // 출발지
        int go; // 점프할 곳
        int jumpCount;

        private Jump(int start, int go, int jumpCount) {
            this.start = start;
            this.go = go;
            this.jumpCount = jumpCount;
        }
    } // End of Jump class

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
        if (ret == INF) {
            sb.append(-1);
        } else {
            sb.append(ret);
        }

        return sb.toString();
    } // End of solve()

    private static int BFS() {
        LinkedList<Jump> que = new LinkedList<>();
        int[] memo = new int[N];
        Arrays.fill(memo, INF);
        memo[0] = 0;

        for (int i = 1; i <= arr[0]; i++) {
            memo[i] = 1;
            que.offer(new Jump(i, arr[i], memo[i]));
        }

        while (!que.isEmpty()) {
            Jump current = que.poll();

            for (int i = 1; i <= current.go; i++) {
                if (current.start + i <= N - 1) {
                    if (memo[current.start + i] > memo[current.start] + 1) {
                        memo[current.start + i] = memo[current.start] + 1;
                        que.offer(new Jump(current.start + i, arr[current.start + i], memo[current.start + i]));
                    }
                }
            }
        }

        return memo[N - 1];
    } // End of DFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
