package BOJ_11060;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11060_DP {

    // https://www.acmicpc.net/problem/11060
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int N;
    private static int[] arr, memo;

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

        memo[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= arr[i]; j++) {
                if (memo[i] == INF) continue; // 이거 없이 Integer.MAX_VALUE INF 값으로 하면 overflow나서 오답됨 

                if (i + j <= N - 1) {
                    memo[i + j] = Math.min(memo[i] + 1, memo[i + j]);
                }
            }
        }

        if (memo[N - 1] == INF) {
            sb.append(-1);
        } else {
            sb.append(memo[N - 1]);
        }

        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        memo = new int[N];
        Arrays.fill(memo, INF);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
