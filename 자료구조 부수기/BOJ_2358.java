package BOJ_2358;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2358 {

    // https://www.acmicpc.net/problem/2358
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static HashMap<Integer, Integer> xCount, yCount;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2358\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int pairs = 0;
        for (int x : xCount.values()) {
            if (x > 1) {
                pairs++;
            }
        }

        for (int y : yCount.values()) {
            if (y > 1) {
                pairs++;
            }
        }

        sb.append(pairs);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        xCount = new HashMap<>();
        yCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            xCount.put(x, xCount.getOrDefault(x, 0) + 1);
            yCount.put(y, yCount.getOrDefault(y, 0) + 1);
        }
    } // End of input()
} // End of Main class
