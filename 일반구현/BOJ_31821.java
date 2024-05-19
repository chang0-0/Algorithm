package BOJ_31821;

import java.io.*;

public class BOJ_31821 {

    // https://www.acmicpc.net/problem/31821
    // input
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_31821\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int M = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(br.readLine());

            ans += arr[temp];
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()
} // End of Main class
