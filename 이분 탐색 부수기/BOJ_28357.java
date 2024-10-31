package BOJ_28357;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_28357 {

    // https://www.acmicpc.net/problem/28357
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static long K, max;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_28357\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(binarySearch());
        return sb.toString();
    } // End of solve()

    private static long binarySearch() {
        long low = 0;
        long high = 1_000_000_000_000L;
        long ans = Long.MAX_VALUE;

        while (low <= high) {
            long mid = (low + high) / 2;
            long ret = check(mid); // 학생들이 받은 사탕 개수

            if (ret > K) {
                low = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                high = mid - 1;
            }
        }

        return ans;
    } // End of binarySearch()

    private static long check(long mid) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] > mid) {
                sum += arr[i] - mid;
                if (sum > K) {
                    return sum;
                }
            }
        }
        return sum;
    } // End of check()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, arr[i]);
        }
    } // End of input()
} // End of Main class
