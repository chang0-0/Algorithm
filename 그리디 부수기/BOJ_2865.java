package BOJ_2865;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2865 {

    // https://www.acmicpc.net/problem/2865
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, K;
    private static double[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2865\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr);
        double totalScore = 0;
        for (int i = 0; i < K; i++) {
            totalScore += arr[N - i];
        }

        String format = String.format("%.1f", totalScore);
        sb.append(format);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new double[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken()); // 참가자 번호
                double score = Double.parseDouble(st.nextToken()); // 점수
                // j는 등수

                arr[num] = Math.max(arr[num], score);
            }
        }
    } // End of input()
} // End of Main class
