package BOJ_9063;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9063 {

    // https://www.acmicpc.net/problem/9063
    // input
    private static BufferedReader br;

    // variables
    private static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_9063\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            maxX = Math.max(maxX, x);
            minX = Math.min(minX, x);
            maxY = Math.max(maxY, y);
            minY = Math.min(minY, y);
        }

        int ans = (maxX - minX) * (maxY - minY);

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
