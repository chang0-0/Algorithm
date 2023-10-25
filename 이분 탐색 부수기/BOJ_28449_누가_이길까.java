package BOJ_28449;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_28449_누가_이길까 {

    // https://www.acmicpc.net/problem/28449
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[] hiArr, arcArr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_28449\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        long draw = 0;
        long hiWin = 0;
        long arcWin = 0;
        for (int i = 0; i < M; i++) {
            int lower = lowerBound(0, N, arcArr[i]);
            int upper = upperBound(0, N, arcArr[i]);

            int temp = upper - lower;
            draw += temp;
            hiWin += N - upper;
            arcWin += upper - temp;
        }

        sb.append(hiWin).append(' ').append(arcWin).append(' ').append(draw);
        return sb.toString();
    } // End of solve()

    private static int lowerBound(int low, int high, int target) {
        if (low == high) return low;

        int mid = (low + high) / 2;
        if (hiArr[mid] < target) {
            return lowerBound(mid + 1, high, target);
        } else {
            return lowerBound(low, mid, target);
        }
    } // End of lowerBound()

    private static int upperBound(int low, int high, int target) {
        if (low == high) return low;

        int mid = (low + high) / 2;
        if (hiArr[mid] <= target) {
            return upperBound(mid + 1, high, target);
        } else {
            return upperBound(low, mid, target);
        }
    } // End of upperBound()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        hiArr = new int[N];
        arcArr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hiArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arcArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(hiArr);
    } // End of input()
} // End of Main class
