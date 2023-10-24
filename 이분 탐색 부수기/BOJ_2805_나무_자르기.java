package BOJ_2805;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2805_나무_자르기 {

    // https://www.acmicpc.net/problem/2805
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, maxHeight;
    private static long ans;
    private static int[] treeHeights;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2805\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        ans = binarySearch(0, maxHeight);
        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static long binarySearch(long low, long high) {
        if (low > high) {
            return high;
        }

        long mid = (low + high) / 2;
        long treeSum = check(mid);

        if (treeSum < M) {
            return binarySearch(low, mid - 1);
        } else {
            return binarySearch(mid + 1, high);
        }
    } // End of binarySearch()

    private static long check(long mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (treeHeights[i] > mid) {
                sum += (treeHeights[i] - mid);
            }
        }
        return sum;
    } // End of check()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        treeHeights = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            treeHeights[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, treeHeights[i]);
        }
    } // End of input()
} // End of Main class
