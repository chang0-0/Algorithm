package BOJ_2018;

import java.io.*;

public class BOJ_2018 {

    // https://www.acmicpc.net/problem/2018
    // input
    private static BufferedReader br;

    // variables
    private static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2018\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(twoPointer());
        return sb.toString();
    } // End of solve()

    private static int twoPointer() {
        int left = 1, right = 1, sum = 0, ans = 0;

        while (right <= N + 1) {
            if (sum <= N) {
                if (sum == N) ans++;
                sum += right++;
            } else {
                sum -= left++;
            }
        }

        return ans;
    } // End of twoPointer

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
