package BOJ_25304;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_25304 {

    // https://www.acmicpc.net/problem/25304
    // input
    private static BufferedReader br;

    // variables
    private static int X, N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_25304\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sum += (a * b);
        }


        if (X == sum) {
            sb.append("Yes");
        } else {
            sb.append("No");
        }

        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        X = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

    } // End of input()
} // End of Main class
