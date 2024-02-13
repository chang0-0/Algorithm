package BOJ_12847;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_12847 {

    // https://www.acmicpc.net/problem/12847
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_12847\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        long max = arr[M];
        for (int i = M; i <= N; i++) {
            max = Math.max(max, arr[i] - arr[i - M]);
        }

        sb.append(max);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

    } // End of input()
} // End of Main class
