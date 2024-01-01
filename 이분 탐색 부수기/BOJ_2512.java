package BOJ_2512;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2512 {

    // https://www.acmicpc.net/problem/2512
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, max, ans;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2512\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        binarySearch(0, max);
        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static int binarySearch(int low, int high) {
        if (low > high) {
            return low;
        }

        int mid = (low + high) / 2;
        if (check(mid) > M) {
            return binarySearch(low, mid - 1);
        } else {
            ans = Math.max(ans, mid);
            return binarySearch(mid + 1, high);
        }
    } // End of binarySearch()

    private static int check(int cap) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.min(cap, arr[i]);
        }

        return sum;
    } // End of check()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        ans = -1;

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        M = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
