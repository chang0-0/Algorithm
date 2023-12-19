package BOJ_30959;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_30959_앙상블할래 {

    // https://www.acmicpc.net/problem/30959
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[] corrects;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
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
        M = Integer.parseInt(st.nextToken());

        corrects = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            corrects[i] = Integer.parseInt(st.nextToken());
        }

    } // End of input()
} // End of Main class
