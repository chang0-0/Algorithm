package BOJ_11052;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11052_BottomUp {

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

        sb.append(bottomUp());
        return sb.toString();
    } // End of solve()

    private static int bottomUp() {

        // memo[index] 배열에 index장을 만드는 최대값을 저장
        for (int i = 1; i <= N; i++) {
            if (memo[i] != 0) continue;
            for (int j = 1; j <= i; j++) {
                memo[i] = Math.max(memo[i], memo[i - j] + arr[j]);
            }
        }

        return memo[N];
    } // End of bottomUp()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        memo = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
