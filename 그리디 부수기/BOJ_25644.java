package BOJ_25644;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_25644 {

    // https://www.acmicpc.net/problem/25644
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr, memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_25644\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        int minStock = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {

            if (minStock > arr[i]) {
                // 현재보유한 주식보다 더 낮은 가격의 주식이 있다면, 바꾼다.
                minStock = arr[i];
            } else if (minStock < arr[i]) {
                // 현재 보유한 가격보다 크면, 팔고 이 동작을 반복하면서 최대값을 찾는다.
                ans = Math.max(ans, arr[i] - minStock);
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static int topDown(int n, int m) {
        if (n <= 0) return 0;

        if (memo[n] != -1) return memo[n];

        if (m == 0) {
            // 주식을 산다. & 주식을 사지않는다.
            memo[n] = Math.max(topDown(n - 1, m + arr[n - 1]), topDown(n - 1, m));
        } else if (m != 0 && m <= arr[n]) {
            // 주식을 가지고 있다면, 주식을 판다. &  주식을 가지고 있어도 팔지 않는다.
            memo[n] = Math.max(arr[n] - m, topDown(n - 1, m));
        }

        return memo[n];
    } // End of topDown()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        memo = new int[N + 1];
        Arrays.fill(memo, -1);
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
