package BOJ_5347;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5347 {

    // https://www.acmicpc.net/problem/5347
    // input
    private static BufferedReader br;

    // variables
    private static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_5347\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = GCD(a, b);
            sb.append(LCM(a, b, gcd)).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static int GCD(int a, int b) {
        if (a % b == 0) return b;
        return GCD(b, a % b);
    } // End of GCD()

    private static long LCM(long n, long m, int gcd) {
        return (n * m) / gcd;
    } // End of LCM()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
