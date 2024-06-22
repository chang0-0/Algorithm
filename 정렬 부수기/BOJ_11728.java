package BOJ_11728;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11728 {

    // https://www.acmicpc.net/problem/11728
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[] nArr, mArr, result;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_11728\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        twoPointer();

        for (int num : result) {
            sb.append(num).append(' ');
        }

        return sb.toString();
    } // End of solve()

    private static void twoPointer() {

        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < N && j < M) {
            if (nArr[i] <= mArr[j]) {
                // 같은 값일 때 A를 우선적으로 삽입 후 B를 삽입
                result[idx++] = nArr[i++];
            } else {
                result[idx++] = mArr[j++];
            }
        }

        while (i < N) {
            result[idx++] = nArr[i++];
        }

        while (j < N) {
            result[idx++] = mArr[j++];
        }
    } // End of twoPointer()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nArr = new int[N];
        mArr = new int[M];
        result = new int[N + M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
