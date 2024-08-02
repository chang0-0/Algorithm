package BOJ_5585;

import java.io.*;

public class BOJ_5585 {

    // https://www.acmicpc.net/problem/5585
    // input
    private static BufferedReader br;

    private static final int 오백 = 500;
    private static final int 백 = 100;
    private static final int 오십 = 50;
    private static final int 십 = 10;
    private static final int 오 = 5;
    private static final int 일 = 1;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_5585\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int n = 1000 - Integer.parseInt(br.readLine());
        int ans = 0;

        if(n >= 오백) {
            ans += n / 오백;
            n %= 오백;
        }

        if(n >= 백) {
            ans += n / 백;
            n %= 백;
        }

        if(n >= 오십) {
            ans += n / 오십;
            n %= 오십;
        }

        if(n >= 십) {
            ans += n / 십;
            n %= 십;
        }

        if(n >= 오) {
            ans += n / 오;
            n %= 오;
        }

        ans += n / 일;
        n %= 일;

        sb.append(ans);
        return sb.toString();
    } // End of solve()
} // End of Main class
