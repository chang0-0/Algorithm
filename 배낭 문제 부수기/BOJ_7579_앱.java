package BOJ_7579;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

    몇 개를 비활성화 홰서 M 바이트 이상의 메모리를 추가로 확보해야 한다.
    비활성화 했을 경우의 합을 최소화하여라.


 */

public class BOJ_7579_앱 {
    // input
    private static BufferedReader br;
    private static StringBuilder sb;

    // variables
    private static final int MAX_N = 100;
    private static final int MAX_COST = 10000;
    private static int N, M, ans;
    private static int[] aliveApps = new int[MAX_N];
    private static int[] costs = new int[MAX_N];
    private static int[][] memo = new int[MAX_N + 1][MAX_COST + 1];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\Java Algorithm\\JavaAlgorithm\\src\\BOJ_7579\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        input();

        solve();

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void solve() {
//        DFS(0, aliveApps[0], costs[0]);
//        DFS(0, 0, 0);

        for (int i = 0; i <= MAX_COST; i++) {
            int result = killApp(0, i);
            if (result < M) {
                continue;
            }

            sb.append(i);
            break;
        }
    } // End of solve

    private static int killApp(int index, int costIndex) {
        if (index >= N) return 0;

        int ret = memo[index][costIndex];
        if (ret != 0) return ret;

        ret = killApp(index + 1, costIndex);
        if (costs[index] <= costIndex) {
            ret = Math.max(aliveApps[index] + killApp(index + 1, costIndex - costs[index]), ret);
        }

        return ret;
    } // End of killApp

    private static void DFS(int index, int volume, int cost) {
        if (volume >= M) {
            ans = Math.min(ans, cost);
        }

        if (memo[index][cost] != 0 && memo[index][cost] >= volume) {
            return;
        }

        memo[index][cost] = volume;

        if (index + 1 < N) {
            DFS(index + 1, volume + aliveApps[index + 1], cost + costs[index + 1]);
            DFS(index + 1, volume, cost);
        }
    } // End of DFS

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            aliveApps[i] = Integer.parseInt(st.nextToken());
            costs[i] = Integer.parseInt(st2.nextToken());
        }
    } // End of input
} // End of Main class
