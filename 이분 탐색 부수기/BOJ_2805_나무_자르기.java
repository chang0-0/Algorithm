package BOJ_2805;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2805_나무_자르기 {

    // https://www.acmicpc.net/problem/2805
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[] treeHeights;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(""));
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        treeHeights = new int[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            treeHeights[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
