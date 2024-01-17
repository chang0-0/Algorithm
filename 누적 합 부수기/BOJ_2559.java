package BOJ_2559;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2559 {

    // https://www.acmicpc.net/problem/2559
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static int[] arr;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2559\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(prefixSum());
        return sb.toString();
    } // End of solve()

    private static int prefixSum() {
        int max = Integer.MIN_VALUE;

        System.out.println(Arrays.toString(arr));
        for (int i = K; i <= N; i++) {
            max = Math.max(max, arr[i] - arr[i - K]);
        }

        return max;
    } // End of twoPointer()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
