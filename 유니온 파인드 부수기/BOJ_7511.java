package BOJ_7511;

import java.io.*;

public class BOJ_7511 {

    // https://www.acmicpc.net/problem/7511
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_7511\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {

    } // End of input()
} // End of Main class
