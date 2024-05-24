package BOJ_11052;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11052 {

    // https://www.acmicpc.net/problem/11052
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr, memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_11052\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 규칙이 있다. -> 규칙을 찾자
        // 메모이제이션을 어떻게 설정할 것인가
        // 점화식을 어떻게 세울 수 있는가?

        /*
        N이 100일 때 1로 100을 채울 수 있고 2를 50으로 하고 나머지 1로 50을 채울 수 도 있다
        여러가지 경우의 수를 생각하자
         */

        sb.append(topDown(N));
        return sb.toString();
    } // End of solve()

    private static int topDown(int n) {
        if (n <= 0) return 0;

        if (memo[n] != -1) return memo[n];

        for (int i = 0; i < n; i++) {
            memo[n] = Math.max(memo[n], arr[i] + topDown(n - (i + 1)));
        }

        return memo[n];
    } // End of topDown()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        memo = new int[N + 1];
        Arrays.fill(memo, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
