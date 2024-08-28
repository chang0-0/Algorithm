package BOJ_14246;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14246 {

    // https://www.acmicpc.net/problem/14246
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_14246\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int end = 0;
        long count = 0;
        for (int start = 0; start < N; start++) {
            while (end < N) {
                sum += arr[end];
                if (sum > K) {
                    count += (N - end);
                    break;
                }
                end++;
            }
            sum -= arr[start];
            sum -= arr[end];
        }

        sb.append(count);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
