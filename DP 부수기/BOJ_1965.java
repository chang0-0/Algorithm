package BOJ_1965;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1965 {

    // https://www.acmicpc.net/problem/1965
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr, memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1965\\res.txt"));
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
        int ans = 1;

        for (int i = 0; i < N; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }

            ans = Math.max(ans, memo[i]);
        }

        return ans;
    } // End of bottomUp()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        memo = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
