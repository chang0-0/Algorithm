package BOJ_16457;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_16457 {

    // https://www.acmicpc.net/problem/16457
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, K, ans;
    private static int[][] quests;
    private static ArrayDeque<Integer> que;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_16457\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        DFS(0, 1);
        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void DFS(int depth, int idx) {
        if (depth == N) {
            int count = 0;
            for (int i = 0; i < M; i++) {
                boolean flag = true;
                for (int j = 0; j < K; j++) {
                    int skill = quests[i][j];

                    if (!que.contains(skill)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) count++;
            }

            ans = Math.max(ans, count);
            return;
        }

        for (int i = idx; i <= (2 * N); i++) {
            que.offerLast(i);
            DFS(depth + 1, i + 1);
            que.pollLast();
        }
    } // End of DFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = 0;

        quests = new int[M][K];
        que = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                quests[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    } // End of input()
} // End of Main class
