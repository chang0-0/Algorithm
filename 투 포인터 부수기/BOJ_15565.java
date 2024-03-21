package BOJ_15565;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15565 {

    // https://www.acmicpc.net/problem/15565
    // input
    private static BufferedReader br;

    // variables
    private static final int ONE = 1;
    private static int N, K;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_15565\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // K개 이상의 값이 되는 연속된 집합의 크기를 출력한다.
        // 없다면 -1을 출력

        // 1이 K개 이상 있는 가장 작은 연속된 인형들의 집합의 크기
        int ret = twoPointer();
        if (ret == N + 1) {
            sb.append(-1);
        } else {
            sb.append(ret);
        }

        return sb.toString();
    } // End of solve()

    private static int twoPointer() {
        int ans = N + 1;
        int count = 0;
        int start = 0;

        for (int end = 0; end < N; end++) {
            if (arr[end] == 1) count++;
            while (count >= K) {
                ans = Math.min(ans, end - start + 1);
                if (arr[start++] == 1) count--;
            }
        }

        return ans;
    } // End of twoPointer()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp == 1) {
                arr[i] = temp;
            }
        }
    } // End of input()
} // End of Main class
