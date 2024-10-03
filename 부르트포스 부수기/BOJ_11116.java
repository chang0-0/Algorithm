package BOJ_11116;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11116 {

    // https://www.acmicpc.net/problem/11116
    // input
    private static BufferedReader br;

    // variables
    private static int M;
    private static int[] left = new int[201];
    private static int[] right = new int[201];
    private static final int TIME = 1000;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_11116\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // Arrays.sort(right, 0, M);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        int ans = 0;
        for (int i = 0; i < M; i++) {
            int leftTime = left[i];

            int time = Arrays.binarySearch(right, 0, M, leftTime + TIME);
            if (time >= 0) {
                ans++;
            }
        }

        sb.append(ans / 2).append('\n');
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            right[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
