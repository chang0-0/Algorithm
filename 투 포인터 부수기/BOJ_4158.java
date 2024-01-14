package BOJ_4158;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4158 {

    // https://www.acmicpc.net/problem/4158
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[] nArr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_4158\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (; ; ) {
            String temp = br.readLine();
            if (temp.equals("0 0")) break;

            input(temp);
            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());

            int ret = binarySearch(0, N - 1, target);
            if (ret != -1) ans++;
        }

        sb.append(ans).append('\n');
        return sb.toString();
    } // End of solve()

    private static int binarySearch(int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (nArr[mid] == target) return mid;
        else if (nArr[mid] > target) {
            return binarySearch(low, mid - 1, target);
        } else {
            return binarySearch(mid + 1, high, target);
        }
    } // End of binarySearch()

    private static void input(String temp) throws IOException {
        StringTokenizer st = new StringTokenizer(temp);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nArr = new int[N];
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(br.readLine());
        }
    } // End of input()
} // End of Main class
