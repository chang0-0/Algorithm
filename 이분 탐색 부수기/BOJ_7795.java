package BOJ_7795;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_7795 {

    // https://www.acmicpc.net/problem/7795
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[] aArr, bArr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_7795\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int num = aArr[i];

            int ret = lowerBound(0, M, num); // 가지고 있는 값 또는 num 보다 낮은 값의 인덱스 반환
            ans += ret;
        }

        sb.append(ans).append('\n');
        return sb.toString();
    } // End of solve()

    private static int lowerBound(int low, int high, int target) {
        if (low == high) {
            return low;
        }

        int mid = (low + high) / 2;
        if (bArr[mid] < target) {
            return lowerBound(mid + 1, high, target);
        } else {
            return lowerBound(low, mid, target);
        }
    } // End of lowerBound()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        aArr = new int[N];
        bArr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(bArr);
    } // End of input()
} // End of Main class
