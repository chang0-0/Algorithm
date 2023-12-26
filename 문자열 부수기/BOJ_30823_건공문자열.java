package BOJ_30823;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_30823_건공문자열 {

    // https://www.acmicpc.net/problem/30823
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static String S;
    private static char[] chArr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_30823\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= N - K; i++) {
            for (int j = i; j < i + K; j++) {


            }
        }

        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        S = br.readLine();
        chArr = S.toCharArray();

    } // End of input()
} // End of Main class
