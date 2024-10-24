package BOJ_32292;

import java.io.*;

public class BOJ_32292 {

    // https://www.acmicpc.net/problem/32292
    // input
    private static BufferedReader br;

    // variables
    private static final String ABB = "ABB";
    private static final String BA = "BA";

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_32292\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        while (s.contains(ABB)) {
            s = s.replace(ABB, BA);
        }

        sb.append(s).append('\n');
        return sb.toString();
    } // End of solve()
} // End of Main class
