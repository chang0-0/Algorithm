package BOJ_29792;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_29792 {

    // https://www.acmicpc.net/problem/29792
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, K;
    private static long[] characters;
    private static long[][] boses;
    private static int[][] memo;

    private static final int MAX_TIME = 15 * 60;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_29792\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(characters);
        int ret = 0;

        // 각 캐릭터당 얻을 수 있는 최대 메소를 DP를 통해서 계산한다.
        for (int i = N - 1; i >= N - M; i--) {
            for (int[] t : memo) {
                Arrays.fill(t, -1);
            }

            ret += topDown(K, 900, characters[i]);
        }

        sb.append(ret);
        return sb.toString();
    } // End of solve()

    private static int topDown(int k, int leftTime, long damage) {
        if (k == 0) return 0;

        if (memo[k][leftTime] != -1) return memo[k][leftTime];

        // 잡는다.
        long needTime = boses[k - 1][0] / damage;
        if (boses[k - 1][0] % damage > 0) {
            needTime++;
        }

        if (leftTime >= needTime) {
            memo[k][leftTime] = (int) Math.max(memo[k][leftTime], topDown(k - 1, (int) (leftTime - needTime), damage) + boses[k - 1][1]);
        }

        // 해당 보스를 잡지 않고 넘어감
        memo[k][leftTime] = Math.max(memo[k][leftTime], topDown(k - 1, leftTime, damage));

        return memo[k][leftTime];
    } // End of topDown()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        characters = new long[N];
        boses = new long[K][2];
        memo = new int[K + 1][MAX_TIME + 1];

        for (int i = 0; i < N; i++) {
            characters[i] = Long.parseLong(br.readLine());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            boses[i][0] = Long.parseLong(st.nextToken());
            boses[i][1] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
