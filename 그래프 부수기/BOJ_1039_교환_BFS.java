package BOJ_1039;

import java.io.*;
import java.util.StringTokenizer;


public class BOJ_1039_교환_BFS {

    // https://www.acmicpc.net/problem/1039
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static String str;
    private static int[][] memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1039\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main

    private static String solve() {
        StringBuilder sb = new StringBuilder();


        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        memo = new int[1_000_001][K + 1];
    } // End of input()
} // End of Main class
